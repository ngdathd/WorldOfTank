package com.ngdat.worldoftanks.models.listenermanagers;

import com.ngdat.worldoftanks.models.tankcomponents.MyTank;

/**
 * Created by HDT
 */
public interface IOnMyTanks {
    MyTank getMyTank();

    void initNewMyTank(IOnExplosions iOnExplosions, IOnBullets iOnBullets);

    int getLifeMyTank();

    void remove(MyTank myTank);
}