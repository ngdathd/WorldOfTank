package com.ngdat.worldoftanks.guis.containers.panels;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IIconConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.guis.containers.IActionEnterGame;
import com.ngdat.worldoftanks.utils.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HDT
 */
public class HiscorePanel extends JPanel implements IAttributeConstants, IIconConstants,
        IImageConstants, ActionListener {
    private JButton btMainMenu;
    private JButton btBack;
    private JButton btNext;

    private JLabel labelHiscorePlayer;
    private JLabel labelComingSoon;

    private IActionEnterGame iActionEnterGame;

    public HiscorePanel() {
        initHiscorePanel();
        initComponents();
        addComponents();
        addEvents();
    }

    private void initHiscorePanel() {
        setLayout(null);
    }

    private void initComponents() {
        initLabelHiscorePlayer();
        initButtons();
    }

    private void initLabelHiscorePlayer() {
        labelHiscorePlayer = new JLabel();
        labelHiscorePlayer.setLocation(521, 30);
        labelHiscorePlayer.setText("<html><p align=\"center\">1 PLAYER");
        labelHiscorePlayer.setForeground(Color.RED);

        Font fontLabelPlayer = new Font("Tahoma", Font.BOLD, 50);
        labelHiscorePlayer.setFont(fontLabelPlayer);

        FontMetrics mtLabelPlayer = getFontMetrics(fontLabelPlayer);
        int widthlabelPlayer = mtLabelPlayer.stringWidth("1 PLAYER ");
        labelHiscorePlayer.setSize(widthlabelPlayer, 50);

        labelComingSoon = new JLabel(COMINGSOON);
        labelComingSoon.setBounds(215, 138, 845, 384);
    }

    private void initButtons() {
        btMainMenu = new MyButton(BUTTON_MENU, BUTTON_MENU1,
                300, 50, 168, 587);
        btBack = new MyButton(BUTTON_BACK, BUTTON_BACK1,
                300, 50, 488, 587);
        btNext = new MyButton(BUTTON_NEXT, BUTTON_NEXT1,
                300, 50, 808, 587);
    }

    private void addComponents() {
        add(labelHiscorePlayer);
        add(labelComingSoon);

        add(btMainMenu);
        add(btBack);
        add(btNext);
    }

    private void addEvents() {
        btMainMenu.addActionListener(this);
        btMainMenu.setActionCommand(MAIN_MENU_BUTTON);

        btBack.addActionListener(this);
        btBack.setActionCommand(BACK_BUTTON);

        btNext.addActionListener(this);
        btNext.setActionCommand(NEXT_BUTTON);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(BACKGROUND2, 0, 0, WIDTH_FRAME, HEIGHT_FRAME, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idButton = e.getActionCommand();
        switch (idButton) {
            case MAIN_MENU_BUTTON: {
                iActionEnterGame.showMainMenuPanel();
                break;
            }
            case BACK_BUTTON: {
                labelHiscorePlayer.setText("1 PLAYER");
                break;
            }
            case NEXT_BUTTON: {
                labelHiscorePlayer.setText("2 PLAYER");
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
}