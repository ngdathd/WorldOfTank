package com.ngdat.worldoftanks.guis.containers.panels;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IIconConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.guis.IActionExitGame;
import com.ngdat.worldoftanks.guis.containers.IActionEnterGame;
import com.ngdat.worldoftanks.utils.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HDT
 */
public class StartPanel extends JPanel implements IAttributeConstants, IIconConstants,
        IImageConstants, ActionListener {
    private JButton btStart;
    private JButton btExit;

    private IActionEnterGame iActionEnterGame;
    private IActionExitGame iActionExitGame;

    public StartPanel() {
        initStartPanel();
        initComponents();
        addComponents();
        addEvents();
    }

    private void initStartPanel() {
        setLayout(null);
    }

    private void initComponents() {
        btStart = new MyButton(BUTTON_START, BUTTON_START1,
                300, 50, 488, 325);
        btExit = new MyButton(BUTTON_EXIT, BUTTON_EXIT1,
                300, 50, 488, 425);
    }

    private void addComponents() {
        add(btStart);
        add(btExit);
    }

    private void addEvents() {
        btStart.addActionListener(this);
        btStart.setActionCommand(START_BUTTON);

        btExit.addActionListener(this);
        btExit.setActionCommand(EXIT_BUTTON);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(BACKGROUND1, 0, 0, WIDTH_FRAME, HEIGHT_FRAME, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idButton = e.getActionCommand();
        switch (idButton) {
            case START_BUTTON: {
                iActionEnterGame.showMainMenuPanel();
                break;
            }
            case EXIT_BUTTON: {
                iActionExitGame.exitGame();
                break;
            }
            default: {
                break;
            }
        }
    }

    public void setIActionEnterGame(IActionEnterGame iActionEnterGame) {
        this.iActionEnterGame = iActionEnterGame;
    }

    public void setIActionExitGame(IActionExitGame iActionExitGame) {
        this.iActionExitGame = iActionExitGame;
    }
}