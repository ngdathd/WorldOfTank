package com.ngdat.worldoftanks.models.listenermanagers;

import com.ngdat.worldoftanks.managers.AssistantEnemyTank;
import com.ngdat.worldoftanks.models.tankcomponents.EnemyTank;

/**
 * Created by HDT
 */
public interface IOnEnemyTanks {
    EnemyTank getEnemyTank();

    void initNewEnemyTank(IOnExplosions iOnExplosions, IOnBullets iOnBullets);

    int getLifeEnemyTank();

    void remove(EnemyTank enemyTank);

    AssistantEnemyTank getAssistantEnemyTank();
}