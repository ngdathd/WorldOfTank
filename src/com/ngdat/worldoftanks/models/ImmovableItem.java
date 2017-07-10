package com.ngdat.worldoftanks.models;

import com.ngdat.worldoftanks.common.IAudioConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.models.abstractmodels.GameItem;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.listenermanagers.IOnImmovableItems;

import java.awt.*;

/**
 * Created by HDT
 */
public class ImmovableItem extends GameItem implements IImageConstants, IAudioConstants {
    private int id;
    private IOnImmovableItems iOnImmovableItems;
    private ObjectAudio objectAudio;

    public ImmovableItem(int id, int x, int y, int width, int height,
                         IOnExplosions iOnExplosions, IOnImmovableItems iOnImmovableItems) {
        super(x, y, width, height, iOnExplosions);
        this.id = id;
        this.iOnImmovableItems = iOnImmovableItems;

        objectAudio = new ObjectAudio(EXPLOSION_ITEM);
    }

    public int getId() {
        return id;
    }

    @Override
    public Image getImage(int id) {
        switch (id) {
            case BRICK_ID: {
                return BRICK;
            }
            case WATER_ID: {
                return WATER;
            }
            case TREE_ID: {
                return TREE;
            }
            case ROCK_ID: {
                return ROCK;
            }
            case BLACK_ID: {
                return BLACK;
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(getImage(id), x, y, width, height, null);
    }

    public void destroyedImmovableItem() {
        if (destroyed()) {
            iOnImmovableItems.remove(this);
            objectAudio.play();
        }
    }

    @Override
    protected boolean checkIsDestroyed() {
        return isDestroy && id != ROCK_ID && id != WATER_ID;
    }
}