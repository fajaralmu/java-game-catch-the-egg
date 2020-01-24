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
public class KeranjangPemain {

    public static int x, y;
    public int velX = 0, actualSpeed = 8;
    public static boolean kanan = false, kiri = false;

    public KeranjangPemain(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void perbarui() {
        //x += velX;
        if (x < 0) {
            x = 0;
        } else if (x > 711) {
            x = 710;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 100, 20);
        g.setColor(Color.blue);
        g.fillRect(x + 10, y + 20, 80, 30);
        g.setColor(new Color(40,40,250));
        g.fillRect(x + 12, y + 22, 30, 25);
        g.setColor(new Color(80,100,250));
        g.fillRect(x + 12, y + 22, 10, 25);
    }

    public Rectangle mulutKeranjang() {
        return new Rectangle(x + 10, y, 80, 1);
    }

}
