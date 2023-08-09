package objects;

import javax.swing.*;
import java.awt.*;

public class Hollow {
    int x;
    int y;
    int width = 200;
    int height = 200;
    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\Hollow.png").getImage();
    public Hollow(int x , int y){
        this.x = x;
        this.y = y;
    }
    //------------------------------------------------methods---------------------------------------------------------//

    //------------------------------------------------getters---------------------------------------------------------//

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    //------------------------------------------------setters---------------------------------------------------------//

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
