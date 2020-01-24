/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tangkaptelur;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author fajar
 */
public abstract class SuperTelur {

    public int x, y, velTelur=Handler.velTelur;

    public SuperTelur(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void perbarui();

    public abstract void render(Graphics g);
    
    public  int getY(){
        return y;
    }
    
    public Rectangle batasTelur(){
        return new Rectangle(x,y,15,20);
    }
}
