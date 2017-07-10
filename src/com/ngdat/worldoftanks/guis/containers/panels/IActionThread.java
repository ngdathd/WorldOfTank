package com.ngdat.worldoftanks.guis.containers.panels;

/**
 * Created by HDT
 */
public interface IActionThread {
    void pauseGame();

    void playGame();

    void stopGame();

    void startGame(Thread thread);

    void setIsImperishable(boolean isImperishable);

    void setIsAuto(boolean isAuto);
}