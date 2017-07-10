package com.ngdat.worldoftanks.models.tankcomponents;

import com.ngdat.worldoftanks.models.*;
import com.ngdat.worldoftanks.models.abstractmodels.MovableItem;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBullets;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;

import java.awt.*;

/**
 * Created by HDT
 */
public class Bullet extends MovableItem {
    private IOnBullets iOnBullets;

    public Bullet(int x, int y, int width, int height, int speed, int orient,
                  IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        super(x, y, width, height, speed, orient, iOnExplosions);
        this.iOnBullets = iOnBullets;
    }

    @Override
    public Image getImage(int orient) {
        switch (orient) {
            case LEFT: {
                return BULLET_LEFT;
            }
            case RIGHT: {
                return BULLET_RIGHT;
            }
            case UP: {
                return BULLET_UP;
            }
            case DOWN: {
                return BULLET_DOWN;
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(getImage(orient), x, y, width, height, null);
    }

    public void destroyedBullet() {
        destroyed();
        iOnBullets.getBullets().remove(this);
    }

    @Override
    protected boolean isInterSectWithImmovableItem(ImmovableItem immovableItem) {
        return immovableItem != null && immovableItem.getId() != WATER_ID;
    }

    @Override
    protected boolean checkIsDestroyed() {
        return WIDTH_PLAY_PANEL - width - 1 <= x || 1 >= x || HEIGHT_FRAME - width - 1 <= y || 1 >= y;
    }

    @Override
    protected int checkIsDestroyedWithImmovableItem(ImmovableItem[][] immovableItems) {
        ImmovableItem immovableItem = interSectWithImmovableItem(immovableItems);
        if (null != immovableItem) {
            immovableItem.setIsDestroy();
            immovableItem.destroyedImmovableItem();
            return immovableItem.getId();
        }
        return 0;
    }
}