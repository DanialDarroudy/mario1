package objects;

import characters.Character;

import javax.swing.*;
import java.awt.*;

public class Wall {
    int x;
    int y;
    int width = 50;
    int height = 50;
    public static Image image = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\Wall.png").getImage();
    public Wall(int x , int y){
        this.x = x;
        this.y = y;
    }
    //------------------------------------------------methods---------------------------------------------------------//
    public void collision(Character character){
        if (theWall().intersects(character.getCharacter())){
            character.setVy(0);
            character.setVx(0);
        }
    }
    public Rectangle theWall(){
        return new Rectangle(x , y , width , height);
    }

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

}
