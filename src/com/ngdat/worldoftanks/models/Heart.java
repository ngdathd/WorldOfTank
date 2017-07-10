package com.ngdat.worldoftanks.models;

import com.ngdat.worldoftanks.common.IAudioConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.models.abstractmodels.GameItem;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.listenermanagers.IOnHearts;

import java.awt.*;

/**
 * Created by HDT
 */
public class Heart extends GameItem implements IImageConstants, IAudioConstants {
    private IOnHearts iOnHearts;
    private ObjectAudio objectAudio;

    public Heart(int x, int y, int width, int height, IOnExplosions iOnExplosions, IOnHearts iOnHearts) {
        super(x, y, width, height, iOnExplosions);
        this.iOnHearts = iOnHearts;
        objectAudio = new ObjectAudio(EXPLOSION_HEART);
    }

    @Override
    public Image getImage(int idGameItem) {
        return null;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(HEART, x, y, width, height, null);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawOval(x, y, width, height);
    }

    public void destroyedHeart() {
        if (destroyed()) {
            iOnHearts.remove(this);
            objectAudio.play();
        }
    }

    @Override
    protected boolean checkIsDestroyed() {
        return isDestroy;
    }
}