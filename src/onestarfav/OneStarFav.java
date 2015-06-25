/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onestarfav;

/**
 *
 * @author makiron
 */
import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.image.BufferStrategy;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//☆１こにつきランダム１こ
//ってゆうかFrame引数にできたらおわりだし，
public class OneStarFav {

    GetFav getfav;
    JFrame jframe;
    //BufferStrategy bs;
    ImageIcon starImage;
    //int count = 0;
    JLabel jlabel;
    //List<JLabel> listJlabel = new ArrayList<JLabel>();
    //JLabel[] JLabel;

    //Star[] stars = new Star[10];
    ArrayList stars = new ArrayList();
    boolean spaceKey = false;

    //スタート地点
    //Random rand;
    //int rd;
    public OneStarFav() {
        jframe = new JFrame();

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocation(300, 300);
        jframe.setSize(1600, 900);

        //jlabel = new JLabel();
        //最前
        //jframe.setAlwaysOnTop(true);
        jframe.setLayout(null);
        jframe.setUndecorated(true);
        jframe.setBackground(new Color(0, 0, 0, 0));
        jframe.setLocationRelativeTo(null);
        //これここでええんか．．．なに以降だったらあかんねんやろ
        jframe.setVisible(true);

        //JFrameに用意されている，標準の画面書き換え処理を無効化
        //forBufferStrateg
        jframe.setIgnoreRepaint(true);
        //バッファの数　ダブルバッファリング
        //jframe.createBufferStrategy(2);
        //実際の描画はMyTimerTaskのrunメソッドで
        //runメソッドが呼び出される前に，BufferStategyのクラスを用意
        //bs = jframe.getBufferStrategy();

        //jframe.addKeyListener(new MyKeyAdapter());
        starImage = new ImageIcon(getClass().getResource("StarImg.png"));
        //starImage =  ImageIO.read(getClass().getResource("star_transparent.png"));

        getfav = new GetFav();

        Timer t = new Timer();
        t.schedule(new MyTimerTask(), 10, 100);
    }

    public static void main(String[] args) {
        new OneStarFav();
    }

    class MyTimerTask extends TimerTask {

        public void run() {
            //Graphics g = bs.getDrawGraphics();
            //if (jlabel.contentsLost() == false) {//もしかかれてなかったら

            //画面白く塗る
            //g.clearRect(0, 0, 1600, 900);
            if (getfav.isFav() == true) {//押されてたら，配列に☆増やす

                //stars.add(new Star(starImage));
                //多分同じインスタンス化したラベルやしぃ
                System.out.println("run true");

                jlabel = new JLabel();
                //透明ありにする
                jlabel.setOpaque(true);
                jlabel.setBackground(new Color(0, 0, 0, 0));

                jframe.add(jlabel);
                stars.add(new Star(starImage, jlabel));
            }

            //
            for (int i = 0; i < stars.size(); i++) {
                Star star = (Star) stars.get(i);//ArryList
                star.draw(jlabel);
            }

            //バッファの切り替え
            //bs.show();
            //Graphicsのインスタンスの破棄
            //g.dispose();
        }
        //count++;
    }

    /*
     class MyKeyAdapter extends KeyAdapter {

     public void keyPressed(KeyEvent e) {
     if (e.getKeyCode() == KeyEvent.VK_SPACE) {
     spaceKey = true;
     System.out.println("押す");
     }
     }

     public void keyReleased(KeyEvent e) {
     if (e.getKeyCode() == KeyEvent.VK_SPACE) {
     spaceKey = false;
     System.out.println("放す");
     }
     }
     }
     */
}
