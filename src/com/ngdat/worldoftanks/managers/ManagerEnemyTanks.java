package com.ngdat.worldoftanks.managers;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.models.Bird;
import com.ngdat.worldoftanks.models.Heart;
import com.ngdat.worldoftanks.models.ImmovableItem;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBullets;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.tankcomponents.MyTank;

import java.awt.*;

/**
 * Created by HDT
 */
public class ManagerEnemyTanks implements IAttributeConstants {
    private AssistantEnemyTank[] assistantEnemyTankArray;
    private int numberEnemyTanks = ENEMYTANK_MAX;

    public ManagerEnemyTanks() {
        assistantEnemyTankArray = new AssistantEnemyTank[ENEMYTANK_MAX];
        assistantEnemyTankArray[0] = new AssistantEnemyTank(this);
        assistantEnemyTankArray[1] = new AssistantEnemyTank(this);
        assistantEnemyTankArray[2] = new AssistantEnemyTank(this);
        assistantEnemyTankArray[3] = new AssistantEnemyTank(this);
    }

    public void drawAllEnemyTanks(Graphics2D graphics2D) {
        for (int i = 0; i < assistantEnemyTankArray.length; i++) {
            if (null != assistantEnemyTankArray[i]) {
                assistantEnemyTankArray[i].drawEnemyTank(graphics2D);
            }
        }
    }

    public void moveAllEnemyTanks(int time, ImmovableItem[][] immovableItems, MyTank myTank, Bird bird, Heart[] hearts) {
        for (int i = 0; i < assistantEnemyTankArray.length; i++) {
            if (null != assistantEnemyTankArray[i]) {
                assistantEnemyTankArray[i].moveEnemyTank(time, immovableItems, myTank, bird, hearts);
            }
        }
    }

    public void fireBulletsEnemyTank(int time) {
        for (int i = 0; i < assistantEnemyTankArray.length; i++) {
            if (null != assistantEnemyTankArray[i]) {
                assistantEnemyTankArray[i].fireBulletsEnemyTank(time);
            }
        }
    }

    public int getNumberEnemyTanks() {
        numberEnemyTanks--;
        return numberEnemyTanks;
    }

    public void removeAssistantEnemyTank(AssistantEnemyTank assistantEnemyTank) {
        for (int i = 0; i < assistantEnemyTankArray.length; i++) {
            if (assistantEnemyTank == assistantEnemyTankArray[i]) {
                assistantEnemyTankArray[i] = null;
            }
        }
    }

    public void removeAllEnemyTanks() {
        for (int i = 0; i < assistantEnemyTankArray.length; i++) {
            if (null != assistantEnemyTankArray[i]) {
                assistantEnemyTankArray[i].removeEnemyTank();
            }
        }
    }

    public void removeAllAssistantEnemyTanks() {
        for (int i = 0; i < assistantEnemyTankArray.length; i++) {
            if (null != assistantEnemyTankArray[i]) {
                assistantEnemyTankArray[i] = null;
            }
        }
    }

    public AssistantEnemyTank[] getAssistantEnemyTankArray() {
        return assistantEnemyTankArray;
    }

    public void initNewEnemyTank(IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        for (int i = 0; i < assistantEnemyTankArray.length; i++) {
            if (null != assistantEnemyTankArray[i]) {
                switch (i) {
                    case 0: {
                        assistantEnemyTankArray[i].initNewEnemyTank(30, 30, iOnExplosions, iOnBullets);
                        break;
                    }
                    case 1: {
                        assistantEnemyTankArray[i].initNewEnemyTank(353, 30, iOnExplosions, iOnBullets);
                        break;
                    }
                    case 2: {
                        assistantEnemyTankArray[i].initNewEnemyTank(675, 30, iOnExplosions, iOnBullets);
                        break;
                    }
                    case 3: {
                        assistantEnemyTankArray[i].initNewEnemyTank(353, 216, iOnExplosions, iOnBullets);
                        break;
                    }
                    default:
                        break;
                }
            }
        }
    }
}