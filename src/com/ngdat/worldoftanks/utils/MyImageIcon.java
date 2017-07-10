package com.ngdat.worldoftanks.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HDT
 */
public class MyImageIcon {
    public static Image getImage(String pathImage) {
        return new ImageIcon(MyImageIcon.class.getResource(pathImage)).getImage();
    }

    public static Icon getIcon(String pathIcon) {
        return new ImageIcon(MyImageIcon.class.getResource(pathIcon));
    }
}