package com.ngdat.worldoftanks.utils;

import com.ngdat.worldoftanks.common.IAudioConstants;
import com.ngdat.worldoftanks.models.ObjectAudio;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by HDT
 */
public class MyButton extends JButton implements IAudioConstants {
    private ObjectAudio objectAudio;

    public MyButton(Icon iconButton, Icon iconButton1,
                    int widthButton, int heightButton, int xButton, int yButton) {
        setIcon(iconButton);
        setContentAreaFilled(false);
        setLocation(xButton, yButton);
        setSize(widthButton, heightButton);

        objectAudio = new ObjectAudio(CLICK);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setIcon(iconButton1);
                objectAudio.play();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(iconButton);
            }
        });
    }
}