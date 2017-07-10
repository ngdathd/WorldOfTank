package com.ngdat.worldoftanks.guis.containers.panels;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IAudioConstants;
import com.ngdat.worldoftanks.common.IIconConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.guis.IActionMusic;
import com.ngdat.worldoftanks.guis.containers.IActionEnterGame;
import com.ngdat.worldoftanks.models.ObjectAudio;
import com.ngdat.worldoftanks.utils.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HDT
 */
public class TutorialPanel extends JPanel implements IAttributeConstants, IIconConstants,
        IImageConstants, ActionListener, IAudioConstants, IActionMusic {
    private JButton btLeft;
    private JButton btRight;
    private JButton btUp;
    private JButton btDown;
    private JButton btCtrl;
    private JButton btMainMenu;
    private JButton btPlay;

    private JLabel labelTutorial;
    private JLabel labelTutorial1;

    private IActionEnterGame iActionEnterGame;
    private IActionThread iActionThread;
    private IActionMusic iActionMusicGUI;

    private ObjectAudio objectAudioPlay;

    public TutorialPanel() {
        initTutorialPanel();
        initComponents();
        addComponents();
        addEvents();
        objectAudioPlay = new ObjectAudio(SOUNDTRACK2);
    }

    private void initTutorialPanel() {
        setLayout(null);
    }

    private void initComponents() {
        initLabelTutorial();
        initButtons();
    }

    private void initLabelTutorial() {
        labelTutorial = new JLabel();
        labelTutorial.setLocation(521, 30);
        labelTutorial.setText("<html><p align=\"center\">ENEMIES");
        labelTutorial.setForeground(Color.RED);

        Font fontLabelTutorial = new Font("Tahoma", Font.BOLD, 50);
        labelTutorial.setFont(fontLabelTutorial);

        FontMetrics mtLabelTutorial = getFontMetrics(fontLabelTutorial);
        int widthlabelTutorial = mtLabelTutorial.stringWidth("ENEMIES");
        labelTutorial.setSize(widthlabelTutorial, 50);

        labelTutorial1 = new JLabel();
        labelTutorial1.setLocation(298, 100);
        labelTutorial1.setText("<html><p align=\"center\">Operate your tank to destroy all the enemy weapons." +
                "<br>In TUTORIAL, your tank has infinite lives," +
                "<br>but in the real game you' d better avoid enemy shells.<br>" +
                "<br>Điều khiển xe tăng của bạn tiêu diệt tất cả các xe tăng địch." +
                "<br>Trong chế độ hướng dẫn, xe tăng của bạn sẽ bất tử," +
                "<br>nhưng trong cuộc chiến thực sự bạn cần tránh hỏa lực địch tốt hơn.<br>");
        labelTutorial1.setForeground(Color.RED);

        Font fontLabelTutorial1 = new Font("Tahoma", Font.BOLD, 20);
        labelTutorial1.setFont(fontLabelTutorial1);

        FontMetrics mtLabelTutorial1 = getFontMetrics(fontLabelTutorial1);
        int widthlabelTutorial1 = mtLabelTutorial1.stringWidth("nhưng trong cuộc chiến thực sự bạn cần tránh hỏa lực địch tốt hơn.");
        labelTutorial1.setSize(widthlabelTutorial1, 180);
    }

    private void initButtons() {
        btLeft = new MyButton(BUTTON_LEFT, BUTTON_LEFT1,
                80, 80, 498, 425);
        btRight = new MyButton(BUTTON_RIGHT, BUTTON_RIGHT1,
                80, 80, 698, 425);
        btUp = new MyButton(BUTTON_UP, BUTTON_UP1,
                80, 80, 598, 325);
        btDown = new MyButton(BUTTON_DOWN, BUTTON_DOWN1,
                80, 80, 598, 425);
        btCtrl = new MyButton(BUTTON_CTRL, BUTTON_CTRL1,
                80, 80, 398, 425);
        btMainMenu = new MyButton(BUTTON_MENU, BUTTON_MENU1,
                300, 50, 168, 587);
        btPlay = new MyButton(BUTTON_PLAY, BUTTON_PLAY1,
                300, 50, 808, 587);
    }

    private void addComponents() {
        add(btLeft);
        add(btRight);
        add(btUp);
        add(btDown);
        add(btCtrl);
        add(btMainMenu);
        add(btPlay);

        add(labelTutorial);
        add(labelTutorial1);
    }

    private void addEvents() {
        btMainMenu.addActionListener(this);
        btMainMenu.setActionCommand(MAIN_MENU_BUTTON);

        btPlay.addActionListener(this);
        btPlay.setActionCommand(PLAY_BUTTON);
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
            case PLAY_BUTTON: {
                objectAudioPlay.loop();
                iActionMusicGUI.stopMusic();
                iActionEnterGame.showGamePanel();
                iActionThread.startGame(new Thread(iActionEnterGame.addRunnable()));
                iActionThread.setIsImperishable(true);
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

    public void setIActionMusicGUI(IActionMusic iActionMusicGUI) {
        this.iActionMusicGUI = iActionMusicGUI;
    }

    @Override
    public void playMusic() {
        objectAudioPlay.loop();
    }

    @Override
    public void stopMusic() {
        objectAudioPlay.stop();
    }
}