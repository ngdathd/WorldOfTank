package com.ngdat.worldoftanks.common;

import com.ngdat.worldoftanks.utils.MyImageIcon;

import java.awt.*;

/**
 * Created by HDT
 */
public interface IImageConstants {
    Image BACKGROUND1 = MyImageIcon.getImage("/resources/images/tank_background(1).jpg");
    Image BACKGROUND2 = MyImageIcon.getImage("/resources/images/tank_background(2).jpg");

    int LEFT = 0;
    int RIGHT = 1;
    int UP = 2;
    int DOWN = 3;
    int FIRE = 4;

    int BRICK_ID = 1;
    int WATER_ID = 2;
    int TREE_ID = 4;
    int ROCK_ID = 5;
    int BLACK_ID = 3;

    Image BRICK = MyImageIcon.getImage("/resources/images/items/brick.png");
    Image WATER = MyImageIcon.getImage("/resources/images/items/water.png");
    Image TREE = MyImageIcon.getImage("/resources/images/items/tree.png");
    Image ROCK = MyImageIcon.getImage("/resources/images/items/rock.png");
    Image BIRD = MyImageIcon.getImage("/resources/images/items/bird.png");
    Image BOMB = MyImageIcon.getImage("/resources/images/weapons/bomb.png");
    Image BLACK = MyImageIcon.getImage("/resources/images/items/black.png");
    Image TANK = MyImageIcon.getImage("/resources/images/tank_icon.png");
    Image HEART = MyImageIcon.getImage("/resources/images/items/heart.png");

    Image MYTANK_LEFT = MyImageIcon.getImage("/resources/images/weapons/player_green_left.png");
    Image MYTANK_RIGHT = MyImageIcon.getImage("/resources/images/weapons/player_green_right.png");
    Image MYTANK_UP = MyImageIcon.getImage("/resources/images/weapons/player_green_up.png");
    Image MYTANK_DOWN = MyImageIcon.getImage("/resources/images/weapons/player_green_down.png");

    Image ENEMYTANK_LEFT = MyImageIcon.getImage("/resources/images/weapons/bossyellow_left.png");
    Image ENEMYTANK_RIGHT = MyImageIcon.getImage("/resources/images/weapons/bossyellow_right.png");
    Image ENEMYTANK_UP = MyImageIcon.getImage("/resources/images/weapons/bossyellow_up.png");
    Image ENEMYTANK_DOWN = MyImageIcon.getImage("/resources/images/weapons/bossyellow_down.png");

    Image BULLET_LEFT = MyImageIcon.getImage("/resources/images/weapons/bullet_left.png");
    Image BULLET_RIGHT = MyImageIcon.getImage("/resources/images/weapons/bullet_right.png");
    Image BULLET_UP = MyImageIcon.getImage("/resources/images/weapons/bullet_up.png");
    Image BULLET_DOWN = MyImageIcon.getImage("/resources/images/weapons/bullet_down.png");

    Image EXP0 = MyImageIcon.getImage("/resources/images/items/exp0.png");
    Image EXP1 = MyImageIcon.getImage("/resources/images/items/exp1.png");
    Image EXP2 = MyImageIcon.getImage("/resources/images/items/exp2.png");
    Image EXP3 = MyImageIcon.getImage("/resources/images/items/exp3.png");
    Image EXP4 = MyImageIcon.getImage("/resources/images/items/exp4.png");
}