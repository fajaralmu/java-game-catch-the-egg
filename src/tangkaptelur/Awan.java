/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tangkaptelur;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author fajar
 */
public class Awan {

    private int x, y;
    private BufferedImage image;

    public Awan(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            image = ImageIO.read(Burung.class.getResource("awan.png"));
        } catch (IOException ex) {
            Logger.getLogger(Burung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void perbarui() {
        x += 1;
        if (x > 900) {
            x = -100;
        }
    }

    public void render(Graphics g) {
        g.drawImage(image.getSubimage(0, 0, image.getWidth(), image.getHeight()), x, y, null);
    }

}
