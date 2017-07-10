package com.ngdat.worldoftanks.guis.containers.panels;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IIconConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.guis.IActionMusic;
import com.ngdat.worldoftanks.guis.containers.IActionEnterGame;
import com.ngdat.worldoftanks.utils.MyButton;
import com.ngdat.worldoftanks.utils.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HDT
 */
public class ControlsPanel extends JPanel implements IAttributeConstants, IIconConstants,
        IImageConstants, ActionListener, IOnMusic {
    private JButton btLeft;
    private JButton btRight;
    private JButton btUp;
    private JButton btDown;
    private JButton btCtrl;
    private JButton btPlayer1;

    private JButton btA;
    private JButton btD;
    private JButton btW;
    private JButton btS;
    private JButton btTab;
    private JButton btPlayer2;

    private JButton btMainMenu;
    private JButton btMusic;

    private JLabel labelControls;
    private JLabel labelMusic;

    private IActionEnterGame iActionEnterGame;
    private IActionMusic iActionMusicGUI;

    private int onMusic = 0;

    public ControlsPanel() {
        initControlsPanel();
        initComponents();
        addComponents();
        addEvents();
    }

    private void initControlsPanel() {
        setLayout(null);
    }

    private void initComponents() {
        initLabelControls();
        initButtons();
    }

    private void initLabelControls() {
        labelControls = new JLabel();
        labelControls.setLocation(483, 30);
        labelControls.setText("<html><p align=\"center\">CONTROLS");
        labelControls.setForeground(Color.RED);

        Font fontLabelControls = new Font("Tahoma", Font.BOLD, 50);
        labelControls.setFont(fontLabelControls);

        FontMetrics mtLabelControls = getFontMetrics(fontLabelControls);
        int widthlabelControls = mtLabelControls.stringWidth("CONTROLS");
        labelControls.setSize(widthlabelControls, 50);
    }

    private void initButtons() {
        btLeft = new MyButton(BUTTON_LEFT, BUTTON_LEFT1,
                80, 80, 738, 195);
        btRight = new MyButton(BUTTON_RIGHT, BUTTON_RIGHT1,
                80, 80, 938, 195);
        btUp = new MyButton(BUTTON_UP, BUTTON_UP1,
                80, 80, 838, 95);
        btDown = new MyButton(BUTTON_DOWN, BUTTON_DOWN1,
                80, 80, 838, 195);
        btCtrl = new MyButton(BUTTON_CTRL, BUTTON_CTRL1,
                80, 80, 638, 195);
        btPlayer1 = new MyButton(BUTTON_PLAYER1, BUTTON_PLAYER11,
                300, 50, 268, 155);

        btA = new MyButton(BUTTON_A1, BUTTON_A,
                80, 80, 738, 425);
        btD = new MyButton(BUTTON_D1, BUTTON_D,
                80, 80, 938, 425);
        btW = new MyButton(BUTTON_W1, BUTTON_W,
                80, 80, 838, 325);
        btS = new MyButton(BUTTON_S1, BUTTON_S,
                80, 80, 838, 425);
        btTab = new MyButton(BUTTON_TAB1, BUTTON_TAB,
                80, 80, 638, 325);
        btPlayer2 = new MyButton(BUTTON_PLAYER21, BUTTON_PLAYER2,
                300, 50, 268, 385);

        btMainMenu = new MyButton(BUTTON_MENU, BUTTON_MENU1,
                300, 50, 168, 587);

        btMusic = new MyButton(BUTTON_MUSIC, BUTTON_MUSIC1,
                300, 50, 808, 587);
        btMusic.setLayout(null);
        labelMusic = new MyLabel("ON", 240, 5);
    }

    private void addComponents() {
        add(btLeft);
        add(btRight);
        add(btUp);
        add(btDown);
        add(btCtrl);
        add(btPlayer1);

        add(btA);
        add(btD);
        add(btW);
        add(btS);
        add(btTab);
        add(btPlayer2);

        add(btMainMenu);
        add(btMusic);

        add(labelControls);
        btMusic.add(labelMusic);
    }

    private void addEvents() {
        btMainMenu.addActionListener(this);
        btMainMenu.setActionCommand(MAIN_MENU_BUTTON);

        btMusic.addActionListener(this);
        btMusic.setActionCommand(MUSIC_BUTTON);
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
            case MUSIC_BUTTON: {
                onMusic++;
                if (1 == onMusic % 2) {
                    labelMusic.setForeground(Color.RED);
                    labelMusic.setText("<html><p align=\"center\">OFF");

                    iActionMusicGUI.stopMusic();
                } else {
                    labelMusic.setForeground(Color.GREEN);
                    labelMusic.setText("<html><p align=\"center\">ON");

                    iActionMusicGUI.playMusic();
                }
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

    public void setIActionMusicGUI(IActionMusic iActionMusicGUI) {
        this.iActionMusicGUI = iActionMusicGUI;
    }

    @Override
    public int getOnMusic() {
        return onMusic;
    }
}