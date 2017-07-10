package com.ngdat.worldoftanks.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HDT
 */
public class MyLabel extends JLabel {
    public MyLabel(String text, int xLabel, int yLabel) {
        setText(text);
        if (text.equals("ON")) {
            setForeground(Color.GREEN);
        } else {
            setForeground(Color.RED);
        }

        Font fontLabel = new Font("Tahoma", Font.BOLD, 25);
        setFont(fontLabel);

        FontMetrics mtLabel = getFontMetrics(fontLabel);
        int widthlabel = mtLabel.stringWidth("OFF");
        setSize(widthlabel, 40);

        setLocation(xLabel, yLabel);
    }
}