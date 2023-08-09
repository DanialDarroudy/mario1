package characters;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Character{
    public int x = 0;
    public int y = 725;
    public int vx = 0;
    public int vy = 0;
    public int heart = 3;
    public boolean strongMan = false;
    public boolean useGun = false;
    public boolean decreaseHeart = false;
    public static int width = 50;
    public static int height = 75;
    public int initX;
    public int initY;
    //------------------------------------------------methods---------------------------------------------------------//

    public static ArrayList<String> characters(){
        ArrayList<String> characters = new ArrayList<>();
        characters.add("Mario");
        characters.add("Wario");
        characters.add("Toad");
        characters.add("Boo");
        characters.add("Yoshi");
        return characters;
    }
    public static HashMap<String , ImageIcon> pictureOfCharacters(){
        HashMap<String , ImageIcon> pictureOfCharacters = new HashMap<>();
        pictureOfCharacters.put("Mario" , Mario.getImageIcon());
        pictureOfCharacters.put("Wario" , Wario.getImageIcon());
        pictureOfCharacters.put("Toad" , Toad.getImageIcon());
        pictureOfCharacters.put("Boo" , Boo.getImageIcon());
        pictureOfCharacters.put("Yoshi" , Yoshi.getImageIcon());
        return pictureOfCharacters;
    }
    public void paint(Graphics g){}
    public void move() {
        if (jumpLimit()) {
            y += vy;
        }
        x += vx;
        checkMove();
    }
    public void checkMove(){
        if (x <= 0) {
            x += 5;
        }
        if (x >= 1750 && y <= 600) {
            x -= 5;
        }
        if (y <= 0) {
            y += 10;
        }
        if (y >= 900){
            heart--;
            this.setDecreaseHeart(true);
            this.setX(0);
            this.setY(725);
        }
    }
    public boolean jumpLimit(){
        return initY - y < 300;
    }
    public Rectangle getCharacter(){
        return new Rectangle(x , y , width , height);
    }

    //------------------------------------------------getters---------------------------------------------------------//

    public int getVx() {
        return vx;
    }

    public boolean isStrongMan() {
        return strongMan;
    }

    public boolean isUseGun() {
        return useGun;
    }

    public int getInitX() {
        return initX;
    }

    public int getInitY() {
        return initY;
    }

    public boolean isDecreaseHeart() {
        return decreaseHeart;
    }

    public int getVy() {
        return vy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeart() {
        return heart;
    }
    //------------------------------------------------setters---------------------------------------------------------//

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public void setDecreaseHeart(boolean decreaseHeart) {
        this.decreaseHeart = decreaseHeart;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }


    public void setStrongMan(boolean strongMan) {
        this.strongMan = strongMan;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public void setUseGun(boolean useGun) {
        this.useGun = useGun;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setInitX(int initX) {
        this.initX = initX;
    }

    public void setInitY(int initY) {
        this.initY = initY;
    }
}
