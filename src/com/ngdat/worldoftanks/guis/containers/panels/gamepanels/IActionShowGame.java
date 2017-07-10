package com.ngdat.worldoftanks.guis.containers.panels.gamepanels;

/**
 * Created by HDT
 */
public interface IActionShowGame {
    void focusPlayPanel();

    void ignorePlayPanel();

    int getScore();

    int getRealLifeMyTank();

    int getRealLifeBird();
}