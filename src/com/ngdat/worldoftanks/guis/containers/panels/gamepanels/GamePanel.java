package com.ngdat.worldoftanks.guis.containers.panels.gamepanels;

import com.ngdat.worldoftanks.common.IAttributeConstants;

import javax.swing.*;

/**
 * Created by HDT
 */
public class GamePanel extends JPanel implements IAttributeConstants {
    private PlayPanel playPanel;
    private ScorePanel scorePanel;

    public GamePanel() {
        initGamePanel();
        initComponents();
        addComponents();
        setIActions();
    }

    private void initGamePanel() {
        setLayout(null);
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
    }

    private void initComponents() {
        playPanel = new PlayPanel();
        scorePanel = new ScorePanel();
    }

    private void addComponents() {
        add(playPanel);
        add(scorePanel);
    }

    private void setIActions() {
        scorePanel.setIActionThread(playPanel);
        scorePanel.setIActionShowGame(playPanel);

        playPanel.setIActionPlayGame(scorePanel);
    }

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public PlayPanel getPlayPanel() {
        return playPanel;
    }
}