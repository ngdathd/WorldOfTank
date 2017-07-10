package com.ngdat.worldoftanks.managers;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.models.Bird;
import com.ngdat.worldoftanks.models.Bomb;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBirds;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBombs;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBullets;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.ImmovableItem;
import com.ngdat.worldoftanks.models.tankcomponents.MyTank;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by HDT
 */
public class ManagerBombs implements IOnBombs, IAttributeConstants, IImageConstants {
    private Bomb[] bombs;
    private List<Integer> xBombs;
    private List<Integer> yBombs;

    public ManagerBombs(IOnExplosions iOnExplosions) {
        bombs = new Bomb[BOMB_MAX];
        initXBombs();
        initYBombs();
        Random random = new Random();

        for (int i = 0; i < BOMB_MAX; i++) {
            int indexX = random.nextInt(xBombs.size());
            int x = xBombs.get(indexX);
            xBombs.remove(indexX);

            int indexY = random.nextInt(yBombs.size());
            int y = yBombs.get(indexY);
            yBombs.remove(indexY);

            bombs[i] = new Bomb(x, y, BOMB_SIZE, BOMB_SIZE, BOMB_SPEED, DOWN, iOnExplosions, this);
        }
    }

    private void initXBombs() {
        xBombs = new ArrayList<>();
        xBombs.add(108);
        xBombs.add(162);
        xBombs.add(216);
        xBombs.add(270);
        xBombs.add(432);
        xBombs.add(486);
        xBombs.add(540);
        xBombs.add(594);
    }

    private void initYBombs() {
        yBombs = new ArrayList<>();
        yBombs.add(162);
        yBombs.add(216);
        yBombs.add(270);
        yBombs.add(324);
    }

    public void drawAllBombs(Graphics2D graphics2D) {
        for (int i = 0; i < bombs.length; i++) {
            if (null != bombs[i]) {
                bombs[i].draw(graphics2D);
            }
        }
    }

    public void moveAllBombs(int time, ImmovableItem[][] immovableItems) {
        for (int i = 0; i < bombs.length; i++) {
            if (null != bombs[i]) {
                bombs[i].moveBomb(time, immovableItems);
            }
        }
    }

    public boolean destroyBombWithEnemyTank(AssistantEnemyTank[] assistantEnemyTankArray,
                                            IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        if (0 < bombs.length) {
            for (int i = 0; i < bombs.length; i++) {
                if (null != bombs[i]) {
                    int result = bombs[i].destroyedWithEnemyTank(assistantEnemyTankArray, iOnExplosions, iOnBullets);
                    if (0 != result) {
                        bombs[i] = null;
                    }
                    if (2 == result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean destroyBombWithMyTank(MyTank myTank, IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        if (0 < bombs.length) {
            for (int i = 0; i < bombs.length; i++) {
                if (null != bombs[i]) {
                    int result = bombs[i].destroyedWithMyTank(myTank, iOnExplosions, iOnBullets);
                    if (0 != result) {
                        bombs[i] = null;
                    }
                    if (2 == result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean destroyBombWithBird(Bird bird, IOnExplosions iOnExplosions, IOnBirds iOnBirds) {
        if (0 < bombs.length) {
            for (int i = 0; i < bombs.length; i++) {
                if (null != bombs[i]) {
                    int result = bombs[i].destroyedWithBird(bird, iOnExplosions, iOnBirds);
                    if (0 != result) {
                        bombs[i] = null;
                    }
                    if (2 == result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void removeAllBombs() {
        if (0 < bombs.length) {
            for (int i = 0; i < bombs.length; i++) {
                if (null != bombs[i]) {
                    bombs[i] = null;
                }
            }
        }
    }

    public Bomb[] getBombs() {
        return bombs;
    }

    @Override
    public void remove(Bomb bomb) {
        for (int i = 0; i < bombs.length; i++) {
            if (bomb == bombs[i]) {
                bombs[i] = null;
            }
        }
    }
}