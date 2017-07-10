package com.ngdat.worldoftanks.managers;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.models.Bird;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBirds;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;

import java.awt.*;

/**
 * Created by HDT
 */
public class ManagerBird implements IOnBirds, IAttributeConstants, IImageConstants {
    private Bird bird;
    private int lifeBird = LIFE_BIRD;

    public ManagerBird() {
    }

    public void drawBird(Graphics2D graphics2D) {
        if (null != bird) {
            bird.draw(graphics2D);
        }
    }

    public void removeBird() {
        if (null != bird) {
            bird = null;
        }
    }

    public int getRealLifeBird() {
        return lifeBird;
    }

    @Override
    public Bird getBird() {
        return bird;
    }

    @Override
    public void initNewBird(IOnExplosions iOnExplosions, IOnBirds iOnBirds) {
        bird = new Bird(X_BIRD_DEFAULT, Y_BIRD_DEFAULT,
                2 * ITEM_SIZE + 2, 2 * ITEM_SIZE, iOnExplosions, this);
    }

    @Override
    public int getLifeBird() {
        lifeBird--;
        return lifeBird;
    }

    @Override
    public void remove(Bird bird) {
        if (bird == this.bird) {
            this.bird = null;
        }
    }
}