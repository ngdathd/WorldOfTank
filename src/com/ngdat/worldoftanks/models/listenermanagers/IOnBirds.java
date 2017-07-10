package com.ngdat.worldoftanks.models.listenermanagers;

import com.ngdat.worldoftanks.models.Bird;

/**
 * Created by HDT
 */
public interface IOnBirds {
    Bird getBird();

    void initNewBird(IOnExplosions iOnExplosions, IOnBirds iOnBirds);

    int getLifeBird();

    void remove(Bird bird);
}