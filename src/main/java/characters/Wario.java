package characters;

import javax.swing.*;
import java.awt.*;

public class Wario extends Character{
    public static ImageIcon imageIcon = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\Wario.png");
    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\WarioInGame.png").getImage();

    //------------------------------------------------methods---------------------------------------------------------//
    public void paint(Graphics g){
        g.drawImage(image , x , y , null);
    }
    public void move(){
        super.move();
    }
    @Override
    public boolean jumpLimit(){
        return initY - y < 500;
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
