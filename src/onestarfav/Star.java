package onestarfav;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * ラベルはこっちだけで 無理やん
 *
 * 向こうでラベル貼っといて
 *
 * @author makiron
 */
public class Star {

    int x, y;
    //BufferedImage bufferIm;
    ImageIcon image;

    Star(ImageIcon icon, JLabel jlabel) {
        //bufferIm = bi;
        image = icon;
        jlabel.setIcon(icon);
        appear();
    }

    void appear() {
        x = 1600;
        y = (int) (Math.random() * 900*0.4);
    }

    void draw(JLabel jlabel) {
        //g.drawImage(bufferIm, x, y, io);//io = jframe

        jlabel.setBounds(x, y, x + image.getIconWidth(), y + image.getIconHeight());

        //移動
        x -= 100;
        y += 13;
    }
}
