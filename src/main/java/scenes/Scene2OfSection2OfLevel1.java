package scenes;

import characters.Character;
import objects.*;

import javax.swing.*;
import java.awt.*;

public class Scene2OfSection2OfLevel1 {
    public boolean finish = false;
    public static Image backGround = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\BackGround.png").getImage();
    public Wall wall1 = new Wall(400 , 500);
    public Wall wall2 = new Wall(450 , 500);
    public Wall wall3 = new Wall(500 , 500);
    public Wall wall4 = new Wall(550 , 500);
    public Wall wall5 = new Wall(600 , 500);
    public TubeHide tubeHide = new TubeHide(700 , 700);
    public Wall wall6 = new Wall(850 , 500);
    public Wall wall7 = new Wall(900 , 500);
    public Wall wall8 = new Wall(950 , 500);
    public Wall wall9 = new Wall(1000 , 500);
    public Wall wall10 = new Wall(1050 , 500);
    public Coin coin1 = new Coin(200, 750);
    public Coin coin2 = new Coin(500, 750);
    public Coin coin3 = new Coin(800, 750);
    public Coin coin4  = new Coin(1200, 750);
    //------------------------------------------------methods---------------------------------------------------------//

    public void drawImage(Graphics g){
        g.drawImage(this.backGround , 0 , 0 , null);
        g.drawImage(this.wall1.getImage() , 400 , 500 , null);
        g.drawImage(this.wall2.getImage() , 450 , 500 , null);
        g.drawImage(this.wall3.getImage() , 500 , 500 , null);
        g.drawImage(this.wall4.getImage() , 550 , 500 , null);
        g.drawImage(this.wall5.getImage() , 600 , 500 , null);
        g.drawImage(this.tubeHide.getImage() , 700 , 700 , null);
        g.drawImage(this.wall6.getImage() , 850 , 500 , null);
        g.drawImage(this.wall7.getImage() , 900 , 500 , null);
        g.drawImage(this.wall8.getImage() , 950 , 500 , null);
        g.drawImage(this.wall9.getImage() , 1000 , 500 , null);
        g.drawImage(this.wall10.getImage() , 1050 , 500 , null);
        if (this.coin1.isShow()) {
            g.drawImage(this.getCoin1().getImage(), 200, 750, null);
        }
        if (this.coin2.isShow()) {
            g.drawImage(this.getCoin2().getImage(), 500, 750, null);
        }
        if (this.coin3.isShow()) {
            g.drawImage(this.getCoin3().getImage(), 800, 750, null);
        }
        if (this.coin4.isShow()) {
            g.drawImage(this.getCoin4().getImage(), 1200, 750, null);
        }
        g.fillRect(1750 , 600 , 50 , 200);
    }
    public boolean jump(Character character){
        if (this.finish){
            return false;
        }
        if (character.getY() == 725){
            return true;
        }
        if (character.getY() == wall1.getY() - 75 &&
                character.getX() >= wall1.getX() - 50 &&
                character.getX() <= wall5.getX() + 50) {
            return true;
        }
        return character.getY() == wall6.getY() - 75 &&
                character.getX() >= wall6.getX() - 50 &&
                character.getX() <= wall10.getX() + 50;
    }

    //------------------------------------------------getters---------------------------------------------------------//

    public boolean isFinish() {
        return finish;
    }

    public Image getBackGround() {
        return backGround;
    }

    public Wall getWall1() {
        return wall1;
    }

    public Wall getWall2() {
        return wall2;
    }

    public Wall getWall3() {
        return wall3;
    }

    public Wall getWall4() {
        return wall4;
    }

    public Wall getWall5() {
        return wall5;
    }

    public TubeHide getTubeHide() {
        return tubeHide;
    }

    public Wall getWall6() {
        return wall6;
    }

    public Wall getWall7() {
        return wall7;
    }

    public Wall getWall8() {
        return wall8;
    }

    public Wall getWall9() {
        return wall9;
    }

    public Wall getWall10() {
        return wall10;
    }

    public Coin getCoin1() {
        return coin1;
    }

    public Coin getCoin2() {
        return coin2;
    }

    public Coin getCoin3() {
        return coin3;
    }

    public Coin getCoin4() {
        return coin4;
    }

    //------------------------------------------------setters---------------------------------------------------------//

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setBackGround(Image backGround) {
        this.backGround = backGround;
    }

    public void setWall1(Wall wall1) {
        this.wall1 = wall1;
    }

    public void setWall2(Wall wall2) {
        this.wall2 = wall2;
    }

    public void setWall3(Wall wall3) {
        this.wall3 = wall3;
    }

    public void setWall4(Wall wall4) {
        this.wall4 = wall4;
    }

    public void setWall5(Wall wall5) {
        this.wall5 = wall5;
    }

    public void setTubeHide(TubeHide tubeHide) {
        this.tubeHide = tubeHide;
    }

    public void setWall6(Wall wall6) {
        this.wall6 = wall6;
    }

    public void setWall7(Wall wall7) {
        this.wall7 = wall7;
    }

    public void setWall8(Wall wall8) {
        this.wall8 = wall8;
    }

    public void setWall9(Wall wall9) {
        this.wall9 = wall9;
    }

    public void setWall10(Wall wall10) {
        this.wall10 = wall10;
    }

    public void setCoin1(Coin coin1) {
        this.coin1 = coin1;
    }

    public void setCoin2(Coin coin2) {
        this.coin2 = coin2;
    }

    public void setCoin3(Coin coin3) {
        this.coin3 = coin3;
    }

    public void setCoin4(Coin coin4) {
        this.coin4 = coin4;
    }

}
