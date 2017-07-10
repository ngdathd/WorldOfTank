package com.ngdat.worldoftanks.common;

/**
 * Created by HDT
 */
public interface IAttributeConstants {
    int WIDTH_FRAME = 1270;
    int HEIGHT_FRAME = 756;
    int WIDTH_PLAY_PANEL = 756;

    int COLUMN_PLAYMAP = 28;
    int ROW_PLAYMAP = 28;
    int COLUMN_MENUMAP = 19;
    int ROW_MENUMAP = 28;

    String START_PANEL = "START_PANEL";
    String MAIN_MENU_PANEL = "MAIN_MENU_PANEL";
    String TUTORIAL_PANEL = "TUTORIAL_PANEL";
    String CONTROLS_PANEL = "CONTROLS_PANEL";
    String HISCORE_PANEL = "HISCORE_PANEL";
    String GAME_PANEL = "GAME_PANEL";

    String START_BUTTON = "START_BUTTON";
    String MAIN_MENU_BUTTON = "MAIN_MENU_BUTTON";
    String TUTORIAL_BUTTON = "TUTORIAL_BUTTON";
    String CONTROLS_BUTTON = "CONTROLS_BUTTON";
    String HISCORE_BUTTON = "HISCORE_BUTTON";
    String MUSIC_BUTTON = "MUSIC_BUTTON";
    String NEXT_BUTTON = "NEXT_BUTTON";
    String BACK_BUTTON = "BACK_BUTTON";
    String EXIT_BUTTON = "EXIT_BUTTON";
    String ONE_PLAYER_BUTTON = "ONE_PLAYER_BUTTON";
    String TWO_PLAYER_BUTTON = "TWO_PLAYER_BUTTON";
    String PLAY_BUTTON = "PLAY_BUTTON";
    String AUTO_PLAY_BUTTON = "AUTO_PLAY_BUTTON";
    String PAUSE_BUTTON = "PAUSE_BUTTON";

    int ITEM_SIZE = 27;

    int LIFE_BIRD = 3;
    int X_BIRD_DEFAULT = 13 * ITEM_SIZE - 1;
    int Y_BIRD_DEFAULT = 25 * ITEM_SIZE - 1;

    int HEART_MAX = 3;
    int HEART_SIZE = 45;

    int ORIENT_MAX = 4;

    int TANK_SIZE = 43;

    int MYTANK_SPEED = 5;
    int LIFE_MYTANK = 3;
    int X_MYTANK_DEFAULT = 10 * ITEM_SIZE + 10;
    int Y_MYTANK_DEFAULT = 25 * ITEM_SIZE + 10;
    int MYTANK_TURN_DELTA = 3000;

    int ENEMYTANK_SPEED = 9;
    int LIFE_ENEMYTANK = 5;
    int X_ENEMYTANK_DEFAULT = 30;
    int Y_ENEMYTANK_DEFAULT = 30;

    int ENEMYTANK_MAX = 4;
    int ENEMYTANK_TURN_DELTA = 2500;

    int BOMB_MAX = 4;
    int BOMB_SIZE = 45;
    int BOMB_SPEED = HEIGHT_FRAME;

    int BULLET_MIN = 1;
    int BULLET_SIZE = 9;
    int BULLET_SPEED = 3;
    int MYBULLET_FIRE_DELTA = 300;
    int ENEMYBULLET_FIRE_DELTA = 950;

    int EXPLOSION_SPEED = 7;
    int EXPLOSION_SIZE = 25;

    String MAP_PLAY = "resources/maps/map_play";
    String MAP_MENU = "resources/maps/map_menu.txt";
}