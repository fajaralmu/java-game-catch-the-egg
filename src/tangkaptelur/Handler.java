/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tangkaptelur;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author fajar
 */
public class Handler {

    private LinkedList<SuperTelur> telur = new LinkedList<>();
    private LinkedList<Entitas> entitas = new LinkedList<>();

    public static int velTelur = 5;
    private int jmlawan = 10;
    private boolean menang = false;
    private Awan[] awan = new Awan[jmlawan];
    private KeranjangPemain pemain;
    public static int jatuh = 0, tangkap = 0, jmltelur = 0, maxtelur = 300;

    public Handler() {
        persiapan();
    }

    public void persiapan() {
        pemain = new KeranjangPemain(300, 475);
        tambahEntitas(new Burung(300, 15));
        for (int i = 0; i < jmlawan; i++) {
            Random rand = new Random();
            awan[i] = (new Awan(rand.nextInt(800)-200, rand.nextInt(300)));
        }
    }

    public void perbarui() {

        for (Iterator<SuperTelur> it_telur = telur.iterator(); it_telur.hasNext();) {
            SuperTelur e = it_telur.next();
            if (jmltelur == ((int) Math.ceil(30 / 100 * maxtelur))) {
                velTelur++;
                System.out.println("vel: "+e.velTelur);
            } else if (jmltelur == ((int) Math.ceil(50 / 100 * maxtelur))) {
                velTelur++;
                System.out.println("vel: "+e.velTelur);
            } else if (jmltelur == ((int) Math.ceil(80 / 100 * maxtelur))) {
                velTelur++;
                System.out.println("vel: "+e.velTelur);
            }
            if (e.batasTelur().intersects(pemain.mulutKeranjang())) {
                it_telur.remove();
                tangkap++;
                break;
            }
            
            if (e.getY() > 500) {
                it_telur.remove();
                jatuh++;
                 break;
            }
        }

        if (Burung.bertelur && jmltelur <= maxtelur && !menang) {
            tambahEntitas(new Telur(Burung.x, Burung.y));
            jmltelur++;

            Burung.bertelur = false;
        }
        for (Entitas e : entitas) {
            e.perbarui();
        }
        pemain.perbarui();
        for (int i = 0; i < jmlawan; i++) {
            awan[i].perbarui();
        }
        for (SuperTelur e : telur) {
            e.perbarui();
        }
        if (jmltelur == maxtelur && tangkap >= ((int) Math.ceil(80 / 100 * maxtelur))) {
            menang = true;
        }

    }

    public void render(Graphics g) {
        
        for (int i = 0; i < jmlawan; i++) {
            awan[i].render(g);
        }
        for (Entitas e : entitas) {
            e.render(g);
        }
        for (SuperTelur e : telur) {
            e.render(g);
        }

        pemain.render(g);

        g.setFont(new Font("tnr", Font.PLAIN, 10));
        g.drawString("total telur : " + jmltelur, 600, 10);
        g.setColor(Color.white);
        g.setFont(new Font("tnr", Font.BOLD, 20));
        g.drawString("TANGKAP : " + tangkap, 600, 40);
        g.setColor(Color.red);
        g.drawString("JATUH : " + jatuh, 600, 60);
        
        if (menang) {
            g.setColor(Color.GREEN);
            g.fillRect(260, 260, 400, 70);
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("ENTE  MENANG!!!!", 270, 300);
            
        }
    }

    public void tambahEntitas(Entitas e) {
        entitas.add(e);
    }

    public void tambahEntitas(SuperTelur e) {
        telur.add(e);
    }
}
