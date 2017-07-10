package com.ngdat.worldoftanks.models;

import com.ngdat.worldoftanks.common.IAudioConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.models.abstractmodels.GameItem;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBirds;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;

import java.awt.*;

/**
 * Created by HDT
 */
public class Bird extends GameItem implements IImageConstants, IAudioConstants {
    private IOnBirds iOnBirds;
    private ObjectAudio objectAudio;

    public Bird(int x, int y, int width, int height, IOnExplosions iOnExplosions, IOnBirds iOnBirds) {
        super(x, y, width, height, iOnExplosions);
        this.iOnBirds = iOnBirds;
        objectAudio = new ObjectAudio(EXPLOSION_BIRD);
    }

    @Override
    public Image getImage(int idGameItem) {
        return null;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(BIRD, x, y, width, height, null);
    }

    public void destroyedBird() {
        if (destroyed()) {
            iOnBirds.remove(this);
            objectAudio.play();
        }
    }

    public void initNewBird(IOnExplosions iOnExplosions, IOnBirds iOnBirds) {
        iOnBirds.initNewBird(iOnExplosions, iOnBirds);
    }

    public int getLifeBird() {
        return iOnBirds.getLifeBird();
    }


    @Override
    protected boolean checkIsDestroyed() {
        return isDestroy;
    }
}