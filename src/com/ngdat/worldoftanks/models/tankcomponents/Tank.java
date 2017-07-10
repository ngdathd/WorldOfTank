package com.ngdat.worldoftanks.models.tankcomponents;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IAudioConstants;
import com.ngdat.worldoftanks.models.ObjectAudio;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.ImmovableItem;
import com.ngdat.worldoftanks.models.abstractmodels.MovableItem;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBullets;

/**
 * Created by HDT
 */
public abstract class Tank extends MovableItem implements IAttributeConstants, IAudioConstants {
    private IOnBullets iOnBullets;
    private ObjectAudio objectAudio;

    public Tank(int x, int y, int width, int height, int speed, int orient,
                IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        super(x, y, width, height, speed, orient, iOnExplosions);
        this.iOnBullets = iOnBullets;
        objectAudio = new ObjectAudio(SHOOT);
    }

    public void fireBullets(int time, int fireDelta) {
        if (0 == time % fireDelta) {
            objectAudio.play();
            int bulletX = getX();
            int bulletY = getY();

            switch (orient) {
                case LEFT: {
                    bulletX -= BULLET_SIZE;
                    bulletY += (TANK_SIZE - BULLET_SIZE) / 2;
                    Bullet bullet = new Bullet(bulletX, bulletY, 2 * BULLET_SIZE, BULLET_SIZE,
                            BULLET_SPEED, orient, iOnExplosions, iOnBullets);
                    iOnBullets.addBullet(bullet);
                    break;
                }
                case RIGHT: {
                    bulletX += TANK_SIZE;
                    bulletY += (TANK_SIZE - BULLET_SIZE) / 2;
                    Bullet bullet = new Bullet(bulletX, bulletY, 2 * BULLET_SIZE, BULLET_SIZE,
                            BULLET_SPEED, orient, iOnExplosions, iOnBullets);
                    iOnBullets.addBullet(bullet);
                    break;
                }
                case UP: {
                    bulletX += (TANK_SIZE - BULLET_SIZE) / 2;
                    bulletY -= BULLET_SIZE;
                    Bullet bullet = new Bullet(bulletX, bulletY, BULLET_SIZE, 2 * BULLET_SIZE,
                            BULLET_SPEED, orient, iOnExplosions, iOnBullets);
                    iOnBullets.addBullet(bullet);
                    break;
                }
                case DOWN: {
                    bulletX += (TANK_SIZE - BULLET_SIZE) / 2;
                    bulletY += TANK_SIZE;
                    Bullet bullet = new Bullet(bulletX, bulletY, BULLET_SIZE, 2 * BULLET_SIZE,
                            BULLET_SPEED, orient, iOnExplosions, iOnBullets);
                    iOnBullets.addBullet(bullet);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    @Override
    protected boolean isInterSectWithImmovableItem(ImmovableItem immovableItem) {
        return immovableItem != null && immovableItem.getId() != TREE_ID;
    }
}