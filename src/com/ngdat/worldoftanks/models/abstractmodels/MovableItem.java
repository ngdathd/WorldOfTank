package com.ngdat.worldoftanks.models.abstractmodels;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IAudioConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.managers.AssistantEnemyTank;
import com.ngdat.worldoftanks.models.*;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBirds;
import com.ngdat.worldoftanks.models.listenermanagers.IOnBullets;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.tankcomponents.Bullet;
import com.ngdat.worldoftanks.models.tankcomponents.EnemyTank;
import com.ngdat.worldoftanks.models.tankcomponents.MyTank;

import java.awt.*;
import java.util.List;

/**
 * Created by HDT
 */
public abstract class MovableItem extends GameItem implements IAttributeConstants, IImageConstants, IAudioConstants {
    protected int orient;
    protected int speed;

    public MovableItem(int x, int y, int width, int height,
                       int speed, int orient, IOnExplosions iOnExplosions) {
        super(x, y, width, height, iOnExplosions);
        this.speed = speed;
        this.orient = orient;
    }

    public void setOrient(int orient) {
        this.orient = orient;
    }

    public void move(int time) {
        if (0 == time % speed) {
            switch (orient) {
                case LEFT: {
                    xPrevious = x;
                    x = xPrevious - 1;
                    if (interSectWithFrame()) {
                        x = xPrevious;
                    }
                    break;
                }
                case RIGHT: {
                    xPrevious = x;
                    x = xPrevious + 1;
                    if (interSectWithFrame()) {
                        x = xPrevious;
                    }
                    break;
                }
                case UP: {
                    yPrevious = y;
                    y = yPrevious - 1;
                    if (interSectWithFrame()) {
                        y = yPrevious;
                    }
                    break;
                }
                case DOWN: {
                    yPrevious = y;
                    y = yPrevious + 1;
                    if (interSectWithFrame()) {
                        y = yPrevious;
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private boolean interSectWithFrame() {
        return WIDTH_PLAY_PANEL - width <= x || 0 >= x || HEIGHT_FRAME - height <= y || 0 >= y;
    }

    // Va chạm với ImmovableItem
    public int destroyedWithImmovableItem(ImmovableItem[][] immovableItems) {
        int result = checkIsDestroyedWithImmovableItem(immovableItems);
        if (0 != result) {
            iOnExplosions.addExplosion(new Explosion(x, y, width, height));
            return result;
        }
        return 0;
    }

    protected abstract int checkIsDestroyedWithImmovableItem(ImmovableItem[][] immovableItems);

    public ImmovableItem interSectWithImmovableItem(ImmovableItem[][] immovableItems) {
        int columnTop;
        int rowTop;
        int columnMid;
        int rowMid;
        int columnBot;
        int rowBot;
        switch (orient) {
            case LEFT: {
                columnTop = x / ITEM_SIZE;
                rowTop = y / ITEM_SIZE;
                if (isInterSectWithImmovableItem(immovableItems[rowTop][columnTop])) {
                    x = xPrevious;
                    return immovableItems[rowTop][columnTop];
                }
                if (height > ITEM_SIZE) {
                    rowBot = (y + height) / ITEM_SIZE;
                    if (isInterSectWithImmovableItem(immovableItems[rowBot][columnTop])) {
                        x = xPrevious;
                        return immovableItems[rowBot][columnTop];
                    }
                    if (0 == (rowTop + rowBot) % 2) {
                        rowMid = rowTop + 1;
                        if (isInterSectWithImmovableItem(immovableItems[rowMid][columnTop])) {
                            x = xPrevious;
                            return immovableItems[rowMid][columnTop];
                        }
                    }
                } else if ((ITEM_SIZE - height) < (y % ITEM_SIZE)) {
                    if (isInterSectWithImmovableItem(immovableItems[rowTop + 1][columnTop])) {
                        x = xPrevious;
                        return immovableItems[rowTop + 1][columnTop];
                    }
                }
                break;
            }
            case RIGHT: {
                columnTop = (x + width) / ITEM_SIZE;
                rowTop = y / ITEM_SIZE;
                if (isInterSectWithImmovableItem(immovableItems[rowTop][columnTop])) {
                    x = xPrevious;
                    return immovableItems[rowTop][columnTop];
                }
                if (height > ITEM_SIZE) {
                    rowBot = (y + height) / ITEM_SIZE;
                    if (isInterSectWithImmovableItem(immovableItems[rowBot][columnTop])) {
                        x = xPrevious;
                        return immovableItems[rowBot][columnTop];
                    }
                    if (0 == (rowTop + rowBot) % 2) {
                        rowMid = rowTop + 1;
                        if (isInterSectWithImmovableItem(immovableItems[rowMid][columnTop])) {
                            x = xPrevious;
                            return immovableItems[rowMid][columnTop];
                        }
                    }
                } else if ((ITEM_SIZE - height) < (y % ITEM_SIZE)) {
                    if (isInterSectWithImmovableItem(immovableItems[rowTop + 1][columnTop])) {
                        x = xPrevious;
                        return immovableItems[rowTop + 1][columnTop];
                    }
                }
                break;
            }
            case UP: {
                columnTop = x / ITEM_SIZE;
                rowTop = y / ITEM_SIZE;
                if (isInterSectWithImmovableItem(immovableItems[rowTop][columnTop])) {
                    y = yPrevious;
                    return immovableItems[rowTop][columnTop];
                }
                if (width > ITEM_SIZE) {
                    columnBot = (x + width) / ITEM_SIZE;
                    if (isInterSectWithImmovableItem(immovableItems[rowTop][columnBot])) {
                        y = yPrevious;
                        return immovableItems[rowTop][columnBot];
                    }
                    if (0 == (columnTop + columnBot) % 2) {
                        columnMid = columnTop + 1;
                        if (isInterSectWithImmovableItem(immovableItems[rowTop][columnMid])) {
                            y = yPrevious;
                            return immovableItems[rowTop][columnMid];
                        }
                    }
                } else if ((ITEM_SIZE - width) < (x % ITEM_SIZE)) {
                    if (isInterSectWithImmovableItem(immovableItems[rowTop][columnTop + 1])) {
                        x = xPrevious;
                        return immovableItems[rowTop][columnTop + 1];
                    }
                }
                break;
            }
            case DOWN: {
                columnTop = x / ITEM_SIZE;
                rowTop = (y + height) / ITEM_SIZE;
                if (isInterSectWithImmovableItem(immovableItems[rowTop][columnTop])) {
                    y = yPrevious;
                    return immovableItems[rowTop][columnTop];
                }
                if (width > ITEM_SIZE) {
                    columnBot = (x + width) / ITEM_SIZE;
                    if (isInterSectWithImmovableItem(immovableItems[rowTop][columnBot])) {
                        y = yPrevious;
                        return immovableItems[rowTop][columnBot];
                    }
                    if (0 == (columnTop + columnBot) % 2) {
                        columnMid = columnTop + 1;
                        if (isInterSectWithImmovableItem(immovableItems[rowTop][columnMid])) {
                            y = yPrevious;
                            return immovableItems[rowTop][columnMid];
                        }
                    }
                } else if ((ITEM_SIZE - width) < (x % ITEM_SIZE)) {
                    if (isInterSectWithImmovableItem(immovableItems[rowTop][columnTop + 1])) {
                        x = xPrevious;
                        return immovableItems[rowTop][columnTop + 1];
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }

    protected abstract boolean isInterSectWithImmovableItem(ImmovableItem immovableItem);

    // Va chạm với các EnemyTank
    public int destroyedWithEnemyTank(AssistantEnemyTank[] assistantEnemyTankArray,
                                      IOnExplosions iOnExplosions1, IOnBullets iOnBullets) {
        int result = checkIsDestroyedWithEnemyTank(assistantEnemyTankArray, iOnExplosions1, iOnBullets);
        if (0 != result) {
            iOnExplosions.addExplosion(new Explosion(x, y, width, height));
        }
        return result;
    }

    private int checkIsDestroyedWithEnemyTank(AssistantEnemyTank[] assistantEnemyTankArray,
                                              IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        EnemyTank enemyTank = interSectWithEnemyTanks(assistantEnemyTankArray);
        if (null != enemyTank) {
            enemyTank.setIsDestroy();
            enemyTank.destroyedEnemyTank();
            if (enemyTank.getLifeEnemyTank() > 0) {
                enemyTank.initNewMyTank(iOnExplosions, iOnBullets);
            } else {
                enemyTank.getAssistantEnemyTank().destroyAssistantEnemyTank();
                if (0 == enemyTank.getAssistantEnemyTank().getNumberEnemyTanks()) {
                    return 2;
                }
            }
            return 1;
        }
        return 0;
    }

    protected EnemyTank interSectWithEnemyTanks(AssistantEnemyTank[] assistantEnemyTankArray) {
        Rectangle rectangle1 = new Rectangle(x, y, width, height);
        switch (orient) {
            case LEFT:
            case RIGHT: {
                for (int i = 0; i < assistantEnemyTankArray.length; i++) {
                    if (null != assistantEnemyTankArray[i] && null != assistantEnemyTankArray[i].getEnemyTank()) {
                        Rectangle rectangle2 = new Rectangle(assistantEnemyTankArray[i].getEnemyTank().getX(),
                                assistantEnemyTankArray[i].getEnemyTank().getY(),
                                assistantEnemyTankArray[i].getEnemyTank().getWidth(),
                                assistantEnemyTankArray[i].getEnemyTank().getHeight());
                        if (rectangle1.intersects(rectangle2)) {
                            x = xPrevious;
                            return assistantEnemyTankArray[i].getEnemyTank();
                        }
                    }
                }
                break;
            }
            case UP:
            case DOWN: {
                for (int i = 0; i < assistantEnemyTankArray.length; i++) {
                    if (null != assistantEnemyTankArray[i] && null != assistantEnemyTankArray[i].getEnemyTank()) {
                        Rectangle rectangle2 = new Rectangle(assistantEnemyTankArray[i].getEnemyTank().getX(),
                                assistantEnemyTankArray[i].getEnemyTank().getY(),
                                assistantEnemyTankArray[i].getEnemyTank().getWidth(),
                                assistantEnemyTankArray[i].getEnemyTank().getHeight());
                        if (rectangle1.intersects(rectangle2)) {
                            y = yPrevious;
                            return assistantEnemyTankArray[i].getEnemyTank();
                        }
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }

    // Va chạm với MyTank
    public int destroyedWithMyTank(MyTank myTank, IOnExplosions iOnExplosions1, IOnBullets iOnBullets) {
        int result = checkIsDestroyedWithMyTank(myTank, iOnExplosions1, iOnBullets);
        if (0 != result) {
            iOnExplosions.addExplosion(new Explosion(x, y, width, height));
        }
        return result;
    }

    private int checkIsDestroyedWithMyTank(MyTank myTank, IOnExplosions iOnExplosions, IOnBullets iOnBullets) {
        MyTank myTank1 = interSectWithMyTank(myTank);
        if (null != myTank1) {
            myTank1.setIsDestroy();
            myTank1.destroyedMyTank();
            if (myTank1.getLifeMyTank() > 0) {
                myTank1.initNewMyTank(iOnExplosions, iOnBullets);
            } else {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    protected MyTank interSectWithMyTank(MyTank myTank) {
        Rectangle rectangle1 = new Rectangle(x, y, width, height);
        switch (orient) {
            case LEFT:
            case RIGHT: {
                if (null != myTank) {
                    Rectangle rectangle2 = new Rectangle(myTank.getX(), myTank.getY(),
                            myTank.getWidth(), myTank.getHeight());
                    if (rectangle1.intersects(rectangle2)) {
                        x = xPrevious;
                        return myTank;
                    }
                }
                break;
            }
            case UP:
            case DOWN: {
                if (null != myTank) {
                    Rectangle rectangle2 = new Rectangle(myTank.getX(), myTank.getY(),
                            myTank.getWidth(), myTank.getHeight());
                    if (rectangle1.intersects(rectangle2)) {
                        y = yPrevious;
                        return myTank;
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }

    // Va chạm với Bird
    public int destroyedWithBird(Bird bird, IOnExplosions iOnExplosions1, IOnBirds iOnBirds) {
        int result = checkIsDestroyedWithBird(bird, iOnExplosions1, iOnBirds);
        if (0 != result) {
            iOnExplosions.addExplosion(new Explosion(x, y, width, height));
        }
        return result;
    }

    private int checkIsDestroyedWithBird(Bird bird, IOnExplosions iOnExplosions, IOnBirds iOnBirds) {
        Bird bird1 = interSectWithBird(bird);
        if (null != bird1) {
            bird1.setIsDestroy();
            bird1.destroyedBird();
            if (bird1.getLifeBird() > 0) {
                bird1.initNewBird(iOnExplosions, iOnBirds);
            } else {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    protected Bird interSectWithBird(Bird bird) {
        Rectangle rectangle1 = new Rectangle(x, y, width, height);
        switch (orient) {
            case LEFT:
            case RIGHT: {
                if (null != bird) {
                    Rectangle rectangle2 = new Rectangle(bird.getX(), bird.getY(),
                            bird.getWidth(), bird.getHeight());
                    if (rectangle1.intersects(rectangle2)) {
                        x = xPrevious;
                        return bird;
                    }
                }
                break;
            }
            case UP:
            case DOWN: {
                if (null != bird) {
                    Rectangle rectangle2 = new Rectangle(bird.getX(), bird.getY(),
                            bird.getWidth(), bird.getHeight());
                    if (rectangle1.intersects(rectangle2)) {
                        y = yPrevious;
                        return bird;
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }

    // Va chạm với Heart
    public boolean destroyedWithHeart(Heart[] hearts) {
        return checkIsDestroyedWithHeart(hearts);
    }

    private boolean checkIsDestroyedWithHeart(Heart[] hearts) {
        Heart heart = interSectWithHeart(hearts);
        if (null != heart) {
            heart.setIsDestroy();
            heart.destroyedHeart();
        }
        return null != heart;
    }

    protected Heart interSectWithHeart(Heart[] hearts) {
        Rectangle rectangle1 = new Rectangle(x, y, width, height);
        switch (orient) {
            case LEFT:
            case RIGHT: {
                for (int i = 0; i < hearts.length; i++) {
                    if (null != hearts[i]) {
                        Rectangle rectangle2 = new Rectangle(hearts[i].getX(), hearts[i].getY(),
                                hearts[i].getWidth(), hearts[i].getHeight());
                        if (rectangle1.intersects(rectangle2)) {
                            x = xPrevious;
                            return hearts[i];
                        }
                    }
                }
                break;
            }
            case UP:
            case DOWN: {
                for (int i = 0; i < hearts.length; i++) {
                    if (null != hearts[i]) {
                        Rectangle rectangle2 = new Rectangle(hearts[i].getX(), hearts[i].getY(),
                                hearts[i].getWidth(), hearts[i].getHeight());
                        if (rectangle1.intersects(rectangle2)) {
                            y = yPrevious;
                            return hearts[i];
                        }
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }

    // Va chạm với Bomb
    public boolean destroyedWithBomb(Bomb[] bombs) {
        if (checkIsDestroyedWithBomb(bombs)) {
            iOnExplosions.addExplosion(new Explosion(x, y, width, height));
            return true;
        } else {
            return false;
        }
    }

    private boolean checkIsDestroyedWithBomb(Bomb[] bombs) {
        Bomb bomb = interSectWithBomb(bombs);
        if (null != bomb) {
            bomb.setIsDestroy();
            bomb.destroyedBomb();
        }
        return null != bomb;
    }

    private Bomb interSectWithBomb(Bomb[] bombs) {
        Rectangle rectangle1 = new Rectangle(x, y, width, height);
        switch (orient) {
            case LEFT:
            case RIGHT: {
                for (int i = 0; i < bombs.length; i++) {
                    if (null != bombs[i]) {
                        Rectangle rectangle2 = new Rectangle(bombs[i].getX(), bombs[i].getY(),
                                bombs[i].getWidth(), bombs[i].getHeight());
                        if (rectangle1.intersects(rectangle2)) {
                            x = xPrevious;
                            return bombs[i];
                        }
                    }
                }
                break;
            }
            case UP:
            case DOWN: {
                for (int i = 0; i < bombs.length; i++) {
                    if (null != bombs[i]) {
                        Rectangle rectangle2 = new Rectangle(bombs[i].getX(), bombs[i].getY(),
                                bombs[i].getWidth(), bombs[i].getHeight());
                        if (rectangle1.intersects(rectangle2)) {
                            y = yPrevious;
                            return bombs[i];
                        }
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }

    // Va chạm với Bullet
    public boolean destroyedWithBullet(List<Bullet> bullets) {
        if (checkIsDestroyedWithBullet(bullets)) {
            iOnExplosions.addExplosion(new Explosion(x, y, width, height));
            return true;
        } else {
            return false;
        }
    }

    private boolean checkIsDestroyedWithBullet(List<Bullet> bullets) {
        Bullet bullet = interSectWithBullet(bullets);
        if (null != bullet) {
            bullet.setIsDestroy();
            bullet.destroyedBullet();
        }
        return null != bullet;
    }

    private Bullet interSectWithBullet(List<Bullet> bullets) {
        Rectangle rectangle1 = new Rectangle(x, y, width, height);
        switch (orient) {
            case LEFT:
            case RIGHT: {
                for (int i = 0; i < bullets.size(); i++) {
                    Rectangle rectangle2 = new Rectangle(bullets.get(i).getX(), bullets.get(i).getY(),
                            bullets.get(i).getWidth(), bullets.get(i).getHeight());
                    if (rectangle1.intersects(rectangle2)) {
                        x = xPrevious;
                        return bullets.get(i);
                    }
                }
                break;
            }
            case UP:
            case DOWN: {
                for (int i = 0; i < bullets.size(); i++) {
                    Rectangle rectangle2 = new Rectangle(bullets.get(i).getX(), bullets.get(i).getY(),
                            bullets.get(i).getWidth(), bullets.get(i).getHeight());
                    if (rectangle1.intersects(rectangle2)) {
                        y = yPrevious;
                        return bullets.get(i);
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }
}