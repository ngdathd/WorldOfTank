package com.ngdat.worldoftanks.managers;

import com.ngdat.worldoftanks.common.IAttributeConstants;
import com.ngdat.worldoftanks.common.IImageConstants;
import com.ngdat.worldoftanks.models.listenermanagers.IOnExplosions;
import com.ngdat.worldoftanks.models.listenermanagers.IOnImmovableItems;
import com.ngdat.worldoftanks.models.ImmovableItem;

import java.awt.*;
import java.io.*;

/**
 * Created by HDT
 */
public class ManagerImmovableItems implements IOnImmovableItems, IAttributeConstants, IImageConstants {
    private ImmovableItem[][] immovableItems;

    public ManagerImmovableItems(String pathMap, int row, int column,
                                 IOnExplosions iOnExplosions) {
        immovableItems = new ImmovableItem[row][column];
        readMap(immovableItems, pathMap, iOnExplosions, this);
    }

    public void drawAllImmovableItems(Graphics2D graphics2D) {
        for (int i = 0; i < immovableItems.length; i++) {
            for (int j = 0; j < immovableItems[0].length; j++) {
                if (null != immovableItems[i][j]) {
                    immovableItems[i][j].draw(graphics2D);
                }
            }
        }
    }

    public void removeAllImmovableItems() {
        for (int i = 0; i < immovableItems.length; i++) {
            for (int j = 0; j < immovableItems[0].length; j++) {
                if (null != immovableItems[i][j]) {
                    immovableItems[i][j] = null;
                }
            }
        }
    }

    public ImmovableItem[][] getImmovableItems() {
        return immovableItems;
    }

    @Override
    public void remove(ImmovableItem immovableItem) {
        for (int i = 0; i < immovableItems.length; i++) {
            for (int j = 0; j < immovableItems[0].length; j++) {
                if (immovableItem == immovableItems[i][j]) {
                    immovableItems[i][j] = null;
                }
            }
        }
    }

    private void readMap(ImmovableItem[][] immovableItems, String pathMap,
                         IOnExplosions iOnExplosions, IOnImmovableItems iOnImmovableItems) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(pathMap);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String line = bufferedReader.readLine();
            int row = 0; //biến dòng (hàng) thứ row, quyết định y
            while (null != line) {
                for (int column = 0; column < line.length(); column++) { //biến cột (vị trí) thứ column, quyết định x
                    ImmovableItem immovableItem;
                    int id = line.charAt(column) - '0';
                    if (0 == id || 9 == id) {
                        immovableItem = null;
                    } else {
                        immovableItem = new ImmovableItem(id, column * ITEM_SIZE, row * ITEM_SIZE,
                                ITEM_SIZE, ITEM_SIZE, iOnExplosions, iOnImmovableItems);
                    }
                    immovableItems[row][column] = immovableItem;
                }
                row++;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}