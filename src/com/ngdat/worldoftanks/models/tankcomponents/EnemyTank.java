package com.ngdat.worldoftanks.models.tankcomponents;

import com.ngdat.worldoftanks.managers.AssistantEnemyTank;
import com.ngdat.worldoftanks.models.Bird;
import com.ngdat.worldoftanks.models.Heart;
import com.ngdat.worldoftanks.models.ObjectAudio;
import com.ngdat.worldoftanks.models.listenermanagers.IOnEnemyTanks;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.ImmovableItem;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBullets;

import java.awt.*;
import java.util.*;

/**
 * Created by HDT
 */
public class EnemyTank extends Tank {
    private IOnEnemyTanks iOnEnemyTanks;
    private ObjectAudio objectAudio;

    public EnemyTank(int x, int y, int width, int height, int speed, int orient,
                     IOnExplosions iOnExplosions, IOnBullets iOnBullets,
                     IOnEnemyTanks iOnEnemyTanks) {
        super(x, y, width, height, speed, orient, iOnExplosions, iOnBullets);
        this.iOnEnemyTanks = iOnEnemyTanks;
        objectAudio = new ObjectAudio(EXPLOSION_TANK);
    }

    @Override
    public Image getImage(int orient) {
        switch (orient) {
            case LEFT: {
                return ENEMYTANK_LEFT;
            }
            case RIGHT: {
                return ENEMYTANK_RIGHT;
            }
            case UP: {
                return ENEMYTANK_UP;
            }
            case DOWN: {
                return ENEMYTANK_DOWN;
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

    public void moveEnemyTank(int time, ImmovableItem[][] immovableItems, MyTank myTank, Bird bird, Heart[] hearts) {
        if (0 == time % ENEMYTANK_TURN_DELTA) {
            int i = new Random().nextInt(3) + 1;
            int orient = (this.orient + i) % ORIENT_MAX;
            this.orient = orient;
            setOrient(orient);
        }
        move(time);
        ImmovableItem immovableItem = interSectWithImmovableItem(immovableItems);
        if (null != immovableItem) {
            int i = new Random().nextInt(3) + 1;
            int orient = (this.orient + i) % ORIENT_MAX;
            this.orient = orient;
            setOrient(orient);
        }
        MyTank myTank1 = interSectWithMyTank(myTank);
        if (null != myTank1) {
            int i = new Random().nextInt(3) + 1;
            int orient = (this.orient + i) % ORIENT_MAX;
            this.orient = orient;
            setOrient(orient);
        }
        Bird bird1 = interSectWithBird(bird);
        if (null != bird1) {
            int i = new Random().nextInt(3) + 1;
            int orient = (this.orient + i) % ORIENT_MAX;
            this.orient = orient;
            setOrient(orient);
        }
        Heart heart = interSectWithHeart(hearts);
        if (null != heart) {
            int i = new Random().nextInt(3) + 1;
            int orient = (this.orient + i) % ORIENT_MAX;
            this.orient = orient;
            setOrient(orient);
        }
    }

    public void destroyedEnemyTank() {
        if (destroyed()) {
            iOnEnemyTanks.remove(this);
            objectAudio.play();
        }
    }

    public void initNewMyTank(IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        iOnEnemyTanks.initNewEnemyTank(iOnExplosions, iOnBullets);
    }

    public int getLifeEnemyTank() {
        return iOnEnemyTanks.getLifeEnemyTank();
    }

    public AssistantEnemyTank getAssistantEnemyTank() {
        return iOnEnemyTanks.getAssistantEnemyTank();
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