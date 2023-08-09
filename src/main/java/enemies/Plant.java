package enemies;

import javax.swing.*;
import java.awt.*;

public class Plant extends Enemy{

    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\Plant.png").getImage();
    public long time = 0;
    public Plant(int x , int y){
        this.x = x;
        this.y = y;
    }
    //------------------------------------------------methods---------------------------------------------------------//
    public void paint(Graphics g){}

    //------------------------------------------------getters---------------------------------------------------------//

    public Image getImage() {
        return image;
    }

    public long getTime() {
        return time;
    }
    //------------------------------------------------setters---------------------------------------------------------//

    public void setTime(long time) {
        this.time = time;
    }
}
