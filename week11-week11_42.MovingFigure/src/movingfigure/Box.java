/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;

/**
 *
 * @author User
 */
public class Box extends Figure {
    private int width, height;
    
    public Box(int x, int y, int width, int heigth) {
        super(x, y);
        this.width = width;
        this.height = heigth;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(super.getX(), super.getY(), width, height);
    }
    
}
