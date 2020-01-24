/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tangkaptelur;

import java.awt.Graphics;

/**
 *
 * @author fajar
 */
public abstract class Entitas {
    public static int x,y;
    public Entitas(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public abstract void perbarui();
    
    public abstract void render(Graphics g);
}
