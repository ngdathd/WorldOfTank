package com.ngdat.worldoftanks.guis.containers;

/**
 * Created by HDT
 */
public interface IActionEnterGame {
    void showMainMenuPanel();

    void showTutorialPanel();

    void showControlsPanel();

    void showHiscorePanel();

    void showGamePanel();

    Runnable addRunnable();
}