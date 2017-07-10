package com.ngdat.worldoftanks.models.abstractmodels;

import com.ngdat.worldoftanks.models.Explosion;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;

/**
 * Created by HDT
 */
public abstract class GameItem extends Object2D {
    protected IOnExplosions iOnExplosions;
    protected int xPrevious;
    protected int yPrevious;
    protected boolean isDestroy;

    public GameItem(int x, int y, int width, int height, IOnExplosions iOnExplosions) {
        super(x, y, width, height);
        this.iOnExplosions = iOnExplosions;
        xPrevious = x;
        yPrevious = y;
    }

    public void setIsDestroy() {
        isDestroy = true;
    }

    public boolean destroyed() {
        if (checkIsDestroyed()) {
            iOnExplosions.addExplosion(new Explosion(x, y, width, height));
            return true;
        } else {
            return false;
        }
    }

    protected abstract boolean checkIsDestroyed();
}