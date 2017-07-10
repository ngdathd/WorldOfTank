package com.ngdat.worldoftanks.models.listenermanagers;

import com.ngdat.worldoftanks.models.tankcomponents.Bullet;

import java.util.List;

/**
 * Created by HDT
 */
public interface IOnBullets {
    void addBullet(Bullet bullet);

    List<Bullet> getBullets();
}