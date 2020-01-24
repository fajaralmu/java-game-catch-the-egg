/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tangkaptelur;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author fajar
 */
public class TangkapTelur extends Canvas implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static int panjang = 800, lebar = 600;

    private boolean running = false, tunggu = true;

    private Handler handler;

    private Thread thread;

    /**
     */
    public TangkapTelur() {
        Dimension size = new Dimension(panjang, lebar);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

    }

    public static void main(String[] args) {
        TangkapTelur gameTelur = new TangkapTelur();
        JFrame Frame = new JFrame("Tangkap Telor");
        Frame.add(gameTelur);
        Frame.pack();
        Frame.setResizable(false);
        Frame.setLocationRelativeTo(null);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);

        gameTelur.start();

    }

    public void init() {
        addMouseMotionListener(new Kendali());
        addKeyListener(new Kendali());
        handler = new Handler();
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Point hotSpot = new Point(0, 0);
//        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
//        Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");
//        setCursor(invisibleCursor);
    }

    public void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this, "Thread");
        thread.start();

    }

    public void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        init();
        requestFocus();

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double delta = 0;
        double ns = 1000000000.0 / 60.0;
        int frames = 0;
        int ticks = 0;
        while (running) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                perbarui();
                ticks++;
                delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println(frames + " fps " + ticks + "ticks");
                frames = 0;
                ticks = 0;
            }
        }
        stop();
    }

    public void perbarui() {
        handler.perbarui();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = (Graphics2D) bs.getDrawGraphics();
        g.setColor(new Color(16, 190, 240));
        g.fillRect(0, 0, panjang + 10, lebar + 10);
        g.setColor(Color.lightGray);
        g.fillRect(0,525,810,85);
        for (int i = 0; i < 8; i++) {
            g.setColor(Color.gray);
            g.fillRect(i * 100 + 5, 530, 95, 40);

        }
        for (int i = 0; i < 9; i++) {
            g.setColor(Color.gray);
            g.fillRect(i * 100 - 47, 575, 95, 40);
        }
        handler.render(g);

        bs.show();
        g.dispose();

    }

}
