/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbxvalidator;

/**
 *
 * @author Loris
 */
public class FbxSdkWrapper {
    
    public native String[] GetMaterialNames(String modelpath);
    public static final int GROUP_SIZE = 3;
    static
    {
        System.loadLibrary("FbxSdkUtilities");
    }
}
