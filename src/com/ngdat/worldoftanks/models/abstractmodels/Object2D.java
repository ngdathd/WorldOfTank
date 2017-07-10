package com.ngdat.worldoftanks.models.abstractmodels;

import java.awt.*;

/**
 * Created by HDT
 */
public abstract class Object2D {
    protected int x;
    protected int y;

    protected int width;
    protected int height;

    public Object2D(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract Image getImage(int idGameItem);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void draw(Graphics2D graphics2D);
}