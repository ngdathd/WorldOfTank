package com.ngdat.worldoftanks.managers;

import com.ngdat.worldoftanks.models.Explosion;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HDT
 */
public class ManagerExplosions implements IOnExplosions {
    private List<Explosion> explosions;

    public ManagerExplosions() {
        explosions = new ArrayList<>();
    }

    public void drawExplosion(Graphics2D graphics2D) {
        for (int i = 0; i < explosions.size(); i++) {
            explosions.get(i).draw(graphics2D);
        }
    }

    public void occurExplosion(int time) {
        for (int i = 0; i < explosions.size(); i++) {
            if (explosions.get(i).explosion(time)) {
                explosions.remove(i);
            }
        }
    }

    public void removeExplosion() {
        explosions.clear();
    }

    @Override
    public void addExplosion(Explosion explosion) {
        explosions.add(explosion);
    }
}