/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbxvalidator;

import java.nio.file.Path;
import javax.swing.Icon;

/**
 *
 * @author Loris
 */
public class MaterialGroupInfo {

    String name;
    String mTextureSetName;

    public MaterialGroupInfo() {
        name = null;
        mTextureSetName = null;
    }

    Path[] mTextures = new Path[MainForm.eSuffix.values().length / 2];
    Path[] cTextures = new Path[MainForm.eSuffix.values().length / 2];

    Icon isOkIcon;

    void resetCTextures() {
        for (int i = 0; i < cTextures.length; i++) {
            cTextures[i] = null;
        }
    }

    void resetMTextures() {
        for (int i = 0; i < mTextures.length; i++) {
            mTextures[i] = null;
        }
    }

    boolean checkMTexturesIsEmpty() {
        for (Path mTexture : mTextures) {
            if (mTexture != null) {
                return false;
            }
        }
        return true;
    }
}
