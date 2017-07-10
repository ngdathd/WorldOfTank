package com.ngdat.worldoftanks.guis.containers.panels.gamepanels;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IIconConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.guis.IActionMusic;
import com.ngdat.worldoftanks.guis.containers.IActionEnterGame;
import com.ngdat.worldoftanks.guis.containers.panels.IActionThread;
import com.ngdat.worldoftanks.guis.containers.panels.IOnMusic;
import com.ngdat.worldoftanks.managers.ManagerExplosions;
import com.ngdat.worldoftanks.managers.ManagerImmovableItems;
import com.ngdat.worldoftanks.utils.MyButton;
import com.ngdat.worldoftanks.utils.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HDT
 */
public class ScorePanel extends JPanel implements IAttributeConstants, IIconConstants,
        ActionListener, IActionPlayGame, IImageConstants {
    private ManagerImmovableItems managerImmovableItems;

    private JLabel labelScore;
    private JLabel labelPlayer;
    private JLabel labelAutoPlay;
    private JLabel labelMusic;
    private JLabel labelPause;

    private JButton btAutoPlay;
    private JButton btPause;
    private JButton btMusic;
    private JButton btMainMenu;

    private IActionEnterGame iActionEnterGame;
    private IActionThread iActionThread;
    private IActionShowGame iActionShowGame;
    private IActionMusic iActionMusicPlay1;
    private IActionMusic iActionMusicPlay2;
    private IActionMusic iActionMusicGUI;
    private IOnMusic iOnMusic;

    private int isAutoPlay = 0;
    private int isPause = 0;
    private int onMusic = 0;

    public ScorePanel() {
        initScorePanel();
        initComponents();
        addComponents();
        addEvents();
    }

    private void initScorePanel() {
        setBackground(Color.BLACK);
        setLayout(null);
        setSize(WIDTH_FRAME - WIDTH_PLAY_PANEL, HEIGHT_FRAME);
        setLocation(WIDTH_PLAY_PANEL + 1, 0);
    }

    private void initComponents() {
        initManagersItems();
        initLabelPlayer();
        initButtons();
    }

    private void initManagersItems() {
        managerImmovableItems = new ManagerImmovableItems(MAP_MENU, ROW_MENUMAP, COLUMN_MENUMAP, new ManagerExplosions());
    }

    private void initLabelPlayer() {
        labelScore = new JLabel();
        labelScore.setLocation(100, 120);
        labelScore.setText("<html><p align=\"center\">SCORE: ");
        labelScore.setForeground(Color.GREEN);

        Font fontLabelScore = new Font("Tahoma", Font.BOLD, 45);
        labelScore.setFont(fontLabelScore);

        FontMetrics mtLabelScore = getFontMetrics(fontLabelScore);
        int widthlabelScore = mtLabelScore.stringWidth("SCORE: "); // width = 155, height = 55
        labelScore.setSize(widthlabelScore, 45);

        labelPlayer = new JLabel();
        labelPlayer.setLocation(150, 30);
        labelPlayer.setText("<html><p align=\"center\">PLAYER");
        labelPlayer.setForeground(Color.GREEN);

        Font fontLabelPlayer = new Font("Tahoma", Font.BOLD, 45);
        labelPlayer.setFont(fontLabelPlayer);

        FontMetrics mtLabelPlayer = getFontMetrics(fontLabelPlayer);
        int widthlabelPlayer = mtLabelPlayer.stringWidth("PLAYER");
        labelPlayer.setSize(widthlabelPlayer, 45);
    }

    private void initButtons() {
        btAutoPlay = new MyButton(BUTTON_AUTOPLAY, BUTTON_AUTOPLAY1,
                300, 50, 95, 425);
        btAutoPlay.setLayout(null);
        labelAutoPlay = new MyLabel("OFF", 240, 5);

        btPause = new MyButton(BUTTON_PAUSE, BUTTON_PAUSE1,
                300, 50, 95, 500);
        btPause.setLayout(null);
        labelPause = new MyLabel("OFF", 240, 5);

        btMusic = new MyButton(BUTTON_MUSIC, BUTTON_MUSIC1,
                300, 50, 95, 575);
        btMusic.setLayout(null);
        labelMusic = new MyLabel("ON", 240, 5);

        btMainMenu = new MyButton(BUTTON_MENU, BUTTON_MENU1,
                300, 50, 95, 650);
    }

    private void addComponents() {
        add(labelScore);
        add(labelPlayer);

        add(btAutoPlay);
        add(btPause);
        add(btMusic);
        add(btMainMenu);

        btAutoPlay.add(labelAutoPlay);
        btPause.add(labelPause);
        btMusic.add(labelMusic);
    }

    private void addEvents() {
        btAutoPlay.addActionListener(this);
        btAutoPlay.setActionCommand(AUTO_PLAY_BUTTON);

        btPause.addActionListener(this);
        btPause.setActionCommand(PAUSE_BUTTON);

        btMusic.addActionListener(this);
        btMusic.setActionCommand(MUSIC_BUTTON);

        btMainMenu.addActionListener(this);
        btMainMenu.setActionCommand(MAIN_MENU_BUTTON);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        managerImmovableItems.drawAllImmovableItems(graphics2D);
        drawScore(graphics2D);
        drawLifeMyTank(graphics2D);
        drawLifeBird(graphics2D);
        repaint();
    }

    private void drawScore(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(new Font("Tahoma", Font.BOLD, 45));
        graphics2D.drawString("" + iActionShowGame.getScore(), 300, 160);
    }

    private void drawLifeMyTank(Graphics2D graphics2D) {
        switch (iActionShowGame.getRealLifeMyTank()) {
            case 1: {
                graphics2D.drawImage(MYTANK_UP, 220, 220, 50, 50, null);
                break;
            }
            case 2: {
                graphics2D.drawImage(MYTANK_UP, 183, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 252, 220, 50, 50, null);
                break;
            }
            case 3: {
                graphics2D.drawImage(MYTANK_UP, 151, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 220, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 289, 220, 50, 50, null);
                break;
            }
            case 4: {
                graphics2D.drawImage(MYTANK_UP, 114, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 183, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 252, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 321, 220, 50, 50, null);
                break;
            }
            case 5: {
                graphics2D.drawImage(MYTANK_UP, 82, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 151, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 220, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 289, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 358, 220, 50, 50, null);
                break;
            }
            case 6: {
                graphics2D.drawImage(MYTANK_UP, 45, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 114, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 183, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 252, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 321, 220, 50, 50, null);
                graphics2D.drawImage(MYTANK_UP, 390, 220, 50, 50, null);
                break;
            }
            default: {
                break;
            }
        }
    }

    private void drawLifeBird(Graphics2D graphics2D) {
        switch (iActionShowGame.getRealLifeBird()) {
            case 1: {
                graphics2D.drawImage(BIRD, 220, 320, 50, 50, null);
                break;
            }
            case 2: {
                graphics2D.drawImage(BIRD, 183, 320, 50, 50, null);
                graphics2D.drawImage(BIRD, 252, 320, 50, 50, null);
                break;
            }
            case 3: {
                graphics2D.drawImage(BIRD, 151, 320, 50, 50, null);
                graphics2D.drawImage(BIRD, 220, 320, 50, 50, null);
                graphics2D.drawImage(BIRD, 289, 320, 50, 50, null);
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idButton = e.getActionCommand();
        switch (idButton) {
            case AUTO_PLAY_BUTTON: {
                if (0 == isPause % 2) {
                    isAutoPlay++;
                    if (1 == isAutoPlay % 2) {
                        labelAutoPlay.setForeground(Color.GREEN);
                        labelAutoPlay.setText("<html><p align=\"center\">ON");
                        iActionThread.setIsAuto(true);
                    } else {
                        labelAutoPlay.setForeground(Color.RED);
                        labelAutoPlay.setText("<html><p align=\"center\">OFF");
                        iActionThread.setIsAuto(false);
                        iActionShowGame.focusPlayPanel();
                    }
                }
                break;
            }
            case PAUSE_BUTTON: {
                isPause++;
                if (1 == isPause % 2) {
                    labelPause.setForeground(Color.GREEN);
                    labelPause.setText("<html><p align=\"center\">ON");

                    iActionThread.pauseGame();
                    iActionMusicPlay1.stopMusic();
                    iActionMusicPlay2.stopMusic();
                    iActionShowGame.ignorePlayPanel();
                } else {
                    labelPause.setForeground(Color.RED);
                    labelPause.setText("<html><p align=\"center\">OFF");

                    iActionThread.playGame();
                    if (0 == onMusic % 2) {
                        iActionMusicPlay1.playMusic();
                        iActionMusicPlay2.playMusic();
                    }
                    iActionShowGame.focusPlayPanel();
                }
                break;
            }
            case MUSIC_BUTTON: {
                if (0 == isPause % 2) {
                    onMusic++;
                    if (1 == onMusic % 2) {
                        labelMusic.setForeground(Color.RED);
                        labelMusic.setText("<html><p align=\"center\">OFF");

                        iActionMusicPlay1.stopMusic();
                        iActionMusicPlay2.stopMusic();
                    } else {
                        labelMusic.setForeground(Color.GREEN);
                        labelMusic.setText("<html><p align=\"center\">ON");

                        iActionMusicPlay1.playMusic();
                        iActionMusicPlay2.playMusic();
                    }

                    iActionShowGame.focusPlayPanel();
                }
                break;
            }
            case MAIN_MENU_BUTTON: {
                backMenuMainPanel();
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

    public void setIActionThread(IActionThread iActionThread) {
        this.iActionThread = iActionThread;
    }

    public void setIActionShowGame(IActionShowGame iActionShowGame) {
        this.iActionShowGame = iActionShowGame;
    }

    public void setIActionMusicPlay1(IActionMusic iActionMusicPlay) {
        this.iActionMusicPlay1 = iActionMusicPlay;
    }

    public void setIActionMusicPlay2(IActionMusic iActionMusicPlay2) {
        this.iActionMusicPlay2 = iActionMusicPlay2;
    }

    public void setIOnMusic(IOnMusic iOnMusic) {
        this.iOnMusic = iOnMusic;
    }

    public void setIActionMusicGUI(IActionMusic iActionMusicGUI) {
        this.iActionMusicGUI = iActionMusicGUI;
    }

    @Override
    public void backMenuMainPanel() {
        iActionEnterGame.showMainMenuPanel();
        iActionMusicPlay1.stopMusic();
        iActionMusicPlay2.stopMusic();

        iActionThread.stopGame();

        if (0 == iOnMusic.getOnMusic() % 2) {
            iActionMusicGUI.playMusic();
        }

        if (1 == isAutoPlay % 2) {
            isAutoPlay = 0;
            labelAutoPlay.setForeground(Color.RED);
            labelAutoPlay.setText("<html><p align=\"center\">OFF");
        }

        if (1 == isPause % 2) {
            isPause = 0;
            labelPause.setForeground(Color.RED);
            labelPause.setText("<html><p align=\"center\">OFF");
        }

        if (1 == onMusic % 2) {
            onMusic = 0;
            labelMusic.setForeground(Color.GREEN);
            labelMusic.setText("<html><p align=\"center\">ON");
        }
    }
}