/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tangkaptelur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author fajar
 */
public class Telur extends SuperTelur {

    public int x = Burung.x + 10, y = Burung.y + 20;

    public Telur(int x, int y) {
        super(x, y);
    }

    @Override
    public void perbarui() {
        y += velTelur;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, 15, 20);
    }

    public int getY() {
        return y;
    }

    public Rectangle batasTelur() {
        return new Rectangle(x, y, 15, 20);
    }

}
