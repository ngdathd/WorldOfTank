package com.ngdat.worldoftanks.models;

import com.ngdat.worldoftanks.models.abstractmodels.MovableItem;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBombs;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;

import java.awt.*;
import java.util.Random;

/**
 * Created by HDT
 */
public class Bomb extends MovableItem {
    private IOnBombs iOnBombs;
    private ObjectAudio objectAudio;

    public Bomb(int x, int y, int width, int height,
                int speed, int orient, IOnExplosions iOnExplosions, IOnBombs iOnBombs) {
        super(x, y, width, height, speed, orient, iOnExplosions);
        this.iOnBombs = iOnBombs;
        objectAudio = new ObjectAudio(EXPLOSION_BOMB);
    }

    @Override
    public Image getImage(int idGameItem) {
        return null;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(BOMB, x, y, width, height, null);
        graphics2D.setColor(Color.RED);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawOval(x, y, width, height);
    }

    public void moveBomb(int time, ImmovableItem[][] immovableItems) {
        move(time);
        ImmovableItem immovableItem = interSectWithImmovableItem(immovableItems);
        if (null != immovableItem) {
            int i = new Random().nextInt(3) + 1;
            int orient = (this.orient + i) % ORIENT_MAX;
            this.orient = orient;
            setOrient(orient);
        }
    }

    public void destroyedBomb() {
        if (destroyed()) {
            iOnBombs.remove(this);
            objectAudio.play();
        }
    }

    @Override
    protected boolean isInterSectWithImmovableItem(ImmovableItem immovableItem) {
        return immovableItem != null && immovableItem.getId() == ROCK_ID;
    }

    @Override
    protected boolean checkIsDestroyed() {
        return isDestroy;
    }

    @Override
    protected int checkIsDestroyedWithImmovableItem(ImmovableItem[][] immovableItems) {
        return 0;
    }
}