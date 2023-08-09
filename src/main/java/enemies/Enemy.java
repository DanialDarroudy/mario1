package enemies;

import characters.Character;

import javax.swing.*;
import java.awt.*;

public abstract class Enemy{
    public int x;
    public int y;
    public int width = 50;
    public int height = 50;
    public boolean exist = true;
    //------------------------------------------------methods---------------------------------------------------------//
    public void paint(Graphics g){}
    public void move() {}
    public void collision(Character character){
            if (theEnemy().intersects(character.getCharacter()) && exist) {
                //if (character.isStrongMan()) {
                //    character.setVy(-10);
                //    character.setVx(-10);
                //    character.setStrongMan(false);
                //    character.setUseGun(false);
                //}
                //else {
                    character.setDecreaseHeart(true);
                    character.setHeart(character.getHeart() - 1);
                    character.setX(0);
                    character.setY(725);
                //}
            }
    }
    public Rectangle theEnemy(){
        return new Rectangle(x , y , width , height);
    }
    //------------------------------------------------getters---------------------------------------------------------//

    public boolean isExist() {
        return exist;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //------------------------------------------------setters---------------------------------------------------------//

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
