package com.ngdat.worldoftanks.guis.containers;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.guis.containers.panels.*;
import com.ngdat.worldoftanks.guis.containers.panels.gamepanels.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HDT
 */
public class MainContainer extends JPanel implements IAttributeConstants, IActionEnterGame {
    private StartPanel startPanel;
    private MainMenuPanel mainMenuPanel;
    private TutorialPanel tutorialPanel;
    private ControlsPanel controlsPanel;
    private HiscorePanel hiscorePanel;
    private GamePanel gamePanel;

    private CardLayout cardLayout;

    public MainContainer() {
        initMainContainer();
        initComponents();
        addComponents();
        setIActions();
    }

    private void initMainContainer() {
        setBackground(Color.CYAN);
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        cardLayout.show(this, START_PANEL);
    }

    private void initComponents() {
        startPanel = new StartPanel();
        mainMenuPanel = new MainMenuPanel();
        tutorialPanel = new TutorialPanel();
        controlsPanel = new ControlsPanel();
        hiscorePanel = new HiscorePanel();
        gamePanel = new GamePanel();
    }

    private void addComponents() {
        add(startPanel, START_PANEL);
        add(mainMenuPanel, MAIN_MENU_PANEL);
        add(tutorialPanel, TUTORIAL_PANEL);
        add(controlsPanel, CONTROLS_PANEL);
        add(hiscorePanel, HISCORE_PANEL);
        add(gamePanel, GAME_PANEL);
    }

    private void setIActions() {
        startPanel.setIActionEnterGame(this);
        mainMenuPanel.setIActionEnterGame(this);
        tutorialPanel.setIActionEnterGame(this);
        controlsPanel.setIActionEnterGame(this);
        hiscorePanel.setIActionEnterGame(this);
        gamePanel.getScorePanel().setIActionEnterGame(this);

        mainMenuPanel.setIActionThread(gamePanel.getPlayPanel());
        tutorialPanel.setIActionThread(gamePanel.getPlayPanel());

        gamePanel.getScorePanel().setIActionMusicPlay1(mainMenuPanel);
        gamePanel.getScorePanel().setIActionMusicPlay2(tutorialPanel);
        gamePanel.getScorePanel().setIOnMusic(controlsPanel);
    }

    public StartPanel getStartPanel() {
        return startPanel;
    }

    public MainMenuPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    public ControlsPanel getControlsPanel() {
        return controlsPanel;
    }

    public TutorialPanel getTutorialPanel() {
        return tutorialPanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    @Override
    public void showMainMenuPanel() {
        cardLayout.show(this, MAIN_MENU_PANEL);
        mainMenuPanel.requestFocus();
    }

    @Override
    public void showTutorialPanel() {
        cardLayout.show(this, TUTORIAL_PANEL);
        tutorialPanel.requestFocus();
    }

    @Override
    public void showControlsPanel() {
        cardLayout.show(this, CONTROLS_PANEL);
        controlsPanel.requestFocus();
    }

    @Override
    public void showHiscorePanel() {
        cardLayout.show(this, HISCORE_PANEL);
        hiscorePanel.requestFocus();
    }

    @Override
    public void showGamePanel() {
        cardLayout.show(this, GAME_PANEL);
        gamePanel.getPlayPanel().setFocusable(true);
        gamePanel.getPlayPanel().requestFocus();
    }

    @Override
    public Runnable addRunnable() {
        return gamePanel.getPlayPanel();
    }
}