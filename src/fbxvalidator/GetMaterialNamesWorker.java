/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbxvalidator;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Loris
 */
public class GetMaterialNamesWorker extends SwingWorker<Void, Void> {

    static private boolean lock = false;

    private String path;
    private MainForm form;

    public GetMaterialNamesWorker(String path, MainForm form) {
        this.path = path;
        this.form = form;
    }

    @Override
    protected Void doInBackground() throws Exception {

        if (!lock) {

            lock = true;
            
            form.getProgressBar().setIndeterminate(true);
            String[] ris = null;
            try {
                FbxSdkWrapper fbxsdk = new FbxSdkWrapper();
                ris = fbxsdk.GetMaterialNames(path);
            } catch (java.lang.UnsatisfiedLinkError e) {
                System.out.println("Errore nella lettura della libreria.");
            }
            form.getProgressBar().setIndeterminate(false);
            if (ris != null) {
                form.updateTable(ris);
            }
            form.getFbxFileChooser().rescanCurrentDirectory();

            lock = false;
        }
        else
        {
            JOptionPane.showMessageDialog(form, "Attendere il completamento dell'operazione in corso");
        }

//        System.out.println("DO IN BACKGROUND COMPLETE");
        return null;
    }
}
