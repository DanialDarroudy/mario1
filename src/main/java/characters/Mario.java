package characters;

import javax.swing.*;
import java.awt.*;

public class Mario extends Character {
    public static ImageIcon imageIcon = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\Mario.png");
    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\MarioInGame.png").getImage();
    //------------------------------------------------methods---------------------------------------------------------//
    public void paint(Graphics g){
        g.drawImage(image , x , y , null);
    }
    public void move(){
        super.move();
    }
    //------------------------------------------------getters---------------------------------------------------------//
    public static Image getImage() {
        return image;
    }
    public static ImageIcon getImageIcon() {
        return imageIcon;
    }
    //------------------------------------------------setters---------------------------------------------------------//

}