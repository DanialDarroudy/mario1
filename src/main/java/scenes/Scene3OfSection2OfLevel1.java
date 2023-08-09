package scenes;

import characters.Character;
import enemies.Plant;
import objects.*;

import javax.swing.*;
import java.awt.*;

public class Scene3OfSection2OfLevel1 {
    public boolean finish = false;
    public static Image backGround = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\BackGround.png").getImage();
    public SmallTube smallTube1 = new SmallTube(400 , 700);
    public BigTube bigTube1 = new BigTube(600 , 600);
    public BigTube bigTube2 = new BigTube(1150 , 600);
    public SmallTube smallTube2 = new SmallTube(1350 , 700);
    public Plant plant1 = new Plant(425 , 650);
    public Plant plant2 = new Plant(625 , 550);
    public Plant plant3 = new Plant(1175 , 550);
    public Plant plant4 = new Plant(1375 , 650);
    public Wall wall1 = new Wall(800 , 500);
    public Wall wall2 = new Wall(850 , 500);
    public Wall wall3 = new Wall(900 , 500);
    public Wall wall4 = new Wall(950 , 500);
    public Coin coin1 = new Coin(750, 750);
    public Coin coin2 = new Coin(850, 750);
    public Coin coin3 = new Coin(950, 750);
    public Coin coin4  = new Coin(850, 450);
    //------------------------------------------------methods---------------------------------------------------------//

    public void drawImage(Graphics g){
        g.drawImage(backGround , 0 , 0 , null);
        g.drawImage(this.smallTube1.getImage() , 400 , 700 , null);
        g.drawImage(this.bigTube1.getImage() , 600 , 600 , null);
        g.drawImage(this.bigTube2.getImage() , 1150 , 600 , null);
        g.drawImage(this.smallTube2.getImage() , 1350 , 700 , null);
        g.drawImage(this.wall1.getImage() , 800 , 500 , null);
        g.drawImage(this.wall2.getImage() , 850 , 500 , null);
        g.drawImage(this.wall3.getImage() , 900 , 500 , null);
        g.drawImage(this.wall4.getImage() , 950 , 500 , null);
        if (this.coin1.isShow()) {
            g.drawImage(this.getCoin1().getImage(), 750, 750, null);
        }
        if (this.coin2.isShow()) {
            g.drawImage(this.getCoin2().getImage(), 850, 750, null);
        }
        if (this.coin3.isShow()) {
            g.drawImage(this.getCoin3().getImage(), 950, 750, null);
        }
        if (this.coin4.isShow()) {
            g.drawImage(this.getCoin4().getImage(), 850, 450, null);
        }
        g.fillRect(1750 , 600 , 50 , 200);
        appearanceOfPlant1(g);
        appearanceOfPlant2(g);
        appearanceOfPlant3(g);
        appearanceOfPlant4(g);
    }
    public boolean jump(Character character){
        if (this.finish){
            return false;
        }
        if (character.getY() == 725){
            return true;
        }
        if (character.getY() == smallTube1.getY() - 75 &&
                character.getX() >= smallTube1.getX() - 50 &&
                character.getX() <= smallTube1.getX() + 100) {
            return true;
        }
        if (character.getY() == smallTube2.getY() - 75 &&
                character.getX() >= smallTube2.getX() - 50 &&
                character.getX() <= smallTube2.getX() + 100) {
            return true;
        }
        if (character.getY() == bigTube1.getY() - 75 &&
                character.getX() >= bigTube1.getX() - 50 &&
                character.getX() <= bigTube1.getX() + 100) {
            return true;
        }
        if (character.getY() == bigTube2.getY() - 75 &&
                character.getX() >= bigTube2.getX() - 50 &&
                character.getX() <= bigTube2.getX() + 100) {
            return true;
        }
        return character.getY() == wall1.getY() - 75 &&
                character.getX() >= wall1.getX() - 50 &&
                character.getX() <= wall4.getX() + 50;
    }
    public void appearanceOfPlant1(Graphics g){
        plant1.setTime(plant1.getTime() + 5);
        if (plant1.getTime() >= 5000){
            plant1.setTime(0);
            plant1.setExist(!plant1.isExist());
        }
        if (plant1.isExist()) {
            g.drawImage(this.plant1.getImage() , 425 , 650 , null);
        }
    }
    public void appearanceOfPlant2(Graphics g){
        plant2.setTime(plant2.getTime() + 5);
        if (plant2.getTime() >= 5000){
            plant2.setTime(0);
            plant2.setExist(!plant2.isExist());
        }
        if (plant2.isExist()) {
            g.drawImage(this.plant2.getImage() , 625 , 550 , null);
        }
    }
    public void appearanceOfPlant3(Graphics g){
        plant3.setTime(plant3.getTime() + 5);
        if (plant3.getTime() >= 5000){
            plant3.setTime(0);
            plant3.setExist(!plant3.isExist());
        }
        if (plant3.isExist()) {
            g.drawImage(this.plant3.getImage() , 1175 , 550 , null);
        }
    }
    public void appearanceOfPlant4(Graphics g){
        plant4.setTime(plant4.getTime() + 5);
        if (plant4.getTime() >= 5000){
            plant4.setTime(0);
            plant4.setExist(!plant4.isExist());
        }
        if (plant4.isExist()) {
            g.drawImage(this.plant4.getImage() , 1375 , 650 , null);
        }
    }
    //------------------------------------------------getters---------------------------------------------------------//

    public boolean isFinish() {
        return finish;
    }

    public Image getBackGround() {
        return backGround;
    }

    public SmallTube getSmallTube1() {
        return smallTube1;
    }

    public SmallTube getSmallTube2() {
        return smallTube2;
    }

    public BigTube getBigTube1() {
        return bigTube1;
    }

    public BigTube getBigTube2() {
        return bigTube2;
    }

    public Plant getPlant1() {
        return plant1;
    }

    public Plant getPlant2() {
        return plant2;
    }

    public Plant getPlant3() {
        return plant3;
    }

    public Plant getPlant4() {
        return plant4;
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

    public void setSmallTube1(SmallTube smallTube1) {
        this.smallTube1 = smallTube1;
    }

    public void setSmallTube2(SmallTube smallTube2) {
        this.smallTube2 = smallTube2;
    }

    public void setBigTube1(BigTube bigTube1) {
        this.bigTube1 = bigTube1;
    }

    public void setBigTube2(BigTube bigTube2) {
        this.bigTube2 = bigTube2;
    }

    public void setPlant1(Plant plant1) {
        this.plant1 = plant1;
    }

    public void setPlant2(Plant plant2) {
        this.plant2 = plant2;
    }

    public void setPlant3(Plant plant3) {
        this.plant3 = plant3;
    }

    public void setPlant4(Plant plant4) {
        this.plant4 = plant4;
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
