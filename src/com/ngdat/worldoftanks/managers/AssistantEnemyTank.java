package com.ngdat.worldoftanks.managers;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.models.Bird;
import com.ngdat.worldoftanks.models.Heart;
import com.ngdat.worldoftanks.models.listenermanagers.IOnEnemyTanks;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.ImmovableItem;
import com.ngdat.worldoftanks.models.tankcomponents.EnemyTank;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBullets;
import com.ngdat.worldoftanks.models.tankcomponents.MyTank;

import java.awt.*;

/**
 * Created by HDT
 */
public class AssistantEnemyTank implements IOnEnemyTanks, IAttributeConstants, IImageConstants {
    private EnemyTank enemyTank;
    private int lifeEnemyTank = LIFE_ENEMYTANK;
    private ManagerEnemyTanks managerEnemyTanks;

    public AssistantEnemyTank(ManagerEnemyTanks managerEnemyTanks) {
        this.managerEnemyTanks = managerEnemyTanks;
    }

    public void initNewEnemyTank(int x, int y, IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        enemyTank = new EnemyTank(x, y, TANK_SIZE, TANK_SIZE, ENEMYTANK_SPEED, DOWN,
                iOnExplosions, iOnBullets, this);
    }

    public void drawEnemyTank(Graphics2D graphics2D) {
        if (null != enemyTank) {
            enemyTank.draw(graphics2D);
        }
    }

    public void moveEnemyTank(int time, ImmovableItem[][] immovableItems,
                              MyTank myTank, Bird bird, Heart[] hearts) {
        if (null != enemyTank) {
            enemyTank.moveEnemyTank(time, immovableItems, myTank, bird, hearts);
        }
    }

    public void fireBulletsEnemyTank(int time) {
        if (null != enemyTank) {
            enemyTank.fireBullets(time, ENEMYBULLET_FIRE_DELTA);
        }
    }

    public void removeEnemyTank() {
        if (null != enemyTank) {
            enemyTank = null;
        }
    }

    public void destroyAssistantEnemyTank() {
        managerEnemyTanks.removeAssistantEnemyTank(this);
    }

    public int getNumberEnemyTanks() {
        return managerEnemyTanks.getNumberEnemyTanks();
    }

    @Override
    public EnemyTank getEnemyTank() {
        return enemyTank;
    }

    @Override
    public void initNewEnemyTank(IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        enemyTank = new EnemyTank(X_ENEMYTANK_DEFAULT, Y_ENEMYTANK_DEFAULT, TANK_SIZE, TANK_SIZE, ENEMYTANK_SPEED, DOWN,
                iOnExplosions, iOnBullets, this);
    }

    @Override
    public int getLifeEnemyTank() {
        lifeEnemyTank--;
        return lifeEnemyTank;
    }

    @Override
    public void remove(EnemyTank enemyTank) {
        if (enemyTank == this.enemyTank) {
            this.enemyTank = null;
        }
    }

    @Override
    public AssistantEnemyTank getAssistantEnemyTank() {
        return this;
    }
}