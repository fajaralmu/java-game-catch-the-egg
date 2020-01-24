/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tangkaptelur;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author fajar
 */
public class Burung extends Entitas {

    public int velX = 0, tik = 0, tok = 0, dir;
    public int panjang = TangkapTelur.panjang;
    public int lebar = TangkapTelur.lebar;
    public static boolean kanan = false, kiri = false, bertelur = false;

    public Burung(int x, int y) {
        super(x, y);
    }

    @Override
    public void perbarui() {
        tik++;
        tok++;
        if (tok >= 1) {
            Random random = new Random();
            int egg = (random.nextInt(40));
            switch (egg) {
                case 0:
                    bertelur = true;
                    break;
                   
                case 1:
                    bertelur = false;
                    break;
                case 2:
                    bertelur = true;
                    break;
            }
        }
        if (kanan && x > 700) {
            velX = 0;
            kanan = false;
        } else if (kiri && x < 50) {
            velX = 0;
            kiri = false;
        }
        if (tik >= 60) {
            Random random = new Random();
            dir = (random.nextInt(6));
            switch (dir) {
                case 0:
                    velX = -3;
                    break;
                case 1:
                    velX = -5;
                    break;
                case 2:
                    velX = -8;
                    break;
                case 3:
                    velX = 3;
                    break;
                case 4:
                    velX = 5;
                    break;
                case 5:
                    velX = 8;
                    break;
            }
            if (velX == 0) {
                return;
            }
            if (velX < 0) {
                kiri = true;
                kanan = false;
            } else if (x > 0) {
                kanan = true;
                kiri = false;
            }

            tik = 0;
        }
        x += velX;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x - 40, y + 3, 120, 10);//sayap
        g.fillOval(x, y, 40, 30);//badan
        g.setColor(new Color(13,200,60));
        g.fillOval(x + 10, y - 10, 20, 20);
        g.setColor(Color.yellow);
        g.fillOval(x + 17, y + 3, 6, 10);

    }

}
