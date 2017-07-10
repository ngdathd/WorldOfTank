package com.ngdat.worldoftanks.managers;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.models.Bird;
import com.ngdat.worldoftanks.models.Heart;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.ImmovableItem;
import com.ngdat.worldoftanks.models.listenermanagers.IOnMyTanks;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBullets;
import com.ngdat.worldoftanks.models.tankcomponents.MyTank;

import java.awt.*;

/**
 * Created by HDT
 */
public class ManagerMyTanks implements IOnMyTanks, IAttributeConstants, IImageConstants {
    private MyTank myTank;
    private int lifeMyTank = LIFE_MYTANK;

    public ManagerMyTanks() {
    }

    public void drawMyTank(Graphics2D graphics2D) {
        if (null != myTank) {
            myTank.draw(graphics2D);
        }
    }

    public void moveMyTank(boolean[] press, int time,
                           ImmovableItem[][] immovableItems, AssistantEnemyTank[] assistantEnemyTankArray, Bird bird) {
        if (null != myTank) {
            myTank.moveMyTank(press, time, immovableItems, assistantEnemyTankArray, bird);
        }
    }

    public void fireBulletsMyTank(boolean[] press, int time) {
        if (null != myTank) {
            myTank.fireBulletsMyTank(press, time);
        }
    }

    public void moveMyTankAuto(int time, ImmovableItem[][] immovableItems,
                               AssistantEnemyTank[] assistantEnemyTanks, Bird bird) {
        if (null != myTank) {
            myTank.moveMyTankAuto(time, immovableItems, assistantEnemyTanks, bird);
        }
    }

    public void fireBulletsMyTankAuto(int time) {
        myTank.fireBulletsMyTankAuto(time);
    }

    public void destroyWithHeart(Heart[] hearts) {
        if (null != myTank) {
            if (myTank.destroyedWithHeart(hearts)) {
                lifeMyTank++;
            }
        }
    }

    public void removeMyTank() {
        if (null != myTank) {
            myTank = null;
        }
    }

    public int getRealLifeMyTank() {
        return lifeMyTank;
    }

    @Override
    public MyTank getMyTank() {
        if (null != myTank) {
            return myTank;
        } else {
            return null;
        }
    }

    @Override
    public void initNewMyTank(IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        myTank = new MyTank(X_MYTANK_DEFAULT, Y_MYTANK_DEFAULT, TANK_SIZE, TANK_SIZE, MYTANK_SPEED, UP,
                iOnExplosions, iOnBullets, this);
    }

    @Override
    public int getLifeMyTank() {
        lifeMyTank--;
        return lifeMyTank;
    }

    @Override
    public void remove(MyTank myTank) {
        if (myTank == this.myTank) {
            this.myTank = null;
        }
    }
}