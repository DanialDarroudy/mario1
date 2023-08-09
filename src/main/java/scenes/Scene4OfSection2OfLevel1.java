package scenes;

import characters.Character;
import enemies.Plant;
import objects.*;

import javax.swing.*;
import java.awt.*;

public class Scene4OfSection2OfLevel1 {
    public boolean finish = false;
    public static Image backGround = new ImageIcon("F:\\Code\\ProjectAP\\src\\main\\java\\pictures\\BackGround.png").getImage();
    public BigTube bigTube = new BigTube(800 , 600);
    public WallHaveThings wallHaveThings1 = new WallHaveThings(450 , 500);
    public Wall wall1 = new Wall(500 , 500);
    public Wall wall2 = new Wall(550 , 500);
    public Wall wall3 = new Wall(600 , 500);
    public Wall wall4 = new Wall(650 , 500);
    public Wall wall5 = new Wall(1000 , 500);
    public Wall wall6 = new Wall(1050 , 500);
    public Wall wall7 = new Wall(1100 , 500);
    public Wall wall8 = new Wall(1150 , 500);
    public WallHaveThings wallHaveThings2 = new WallHaveThings(1200 , 500);
    public Plant plant = new Plant(825 , 550);
    public Coin coin1 = new Coin(200, 750);
    public Coin coin2 = new Coin(400, 750);
    public Coin coin3 = new Coin(1100, 750);
    public Coin coin4  = new Coin(1300, 750);
    //------------------------------------------------methods---------------------------------------------------------//

    public void drawImage(Graphics g){
        g.drawImage(this.backGround , 0 , 0 , null);
        g.drawImage(this.bigTube.getImage() , 800 , 600 , null);
        g.drawImage(this.wall1.getImage() , 500 , 500 , null);
        g.drawImage(this.wall2.getImage() , 550 , 500 , null);
        g.drawImage(this.wall3.getImage() , 600 , 500 , null);
        g.drawImage(this.wall4.getImage() , 650 , 500 , null);
        g.drawImage(this.wall5.getImage() , 1000 , 500 , null);
        g.drawImage(this.wall6.getImage() , 1050 , 500 , null);
        g.drawImage(this.wall7.getImage() , 1100 , 500 , null);
        g.drawImage(this.wall8.getImage() , 1150 , 500 , null);
        g.drawImage(this.wallHaveThings1.getImage() , 450 , 500 , null);
        g.drawImage(this.wallHaveThings2.getImage() , 1200 , 500 , null);
        if (this.coin1.isShow()) {
            g.drawImage(this.getCoin1().getImage(), 200, 750, null);
        }
        if (this.coin2.isShow()) {
            g.drawImage(this.getCoin2().getImage(), 400, 750, null);
        }
        if (this.coin3.isShow()) {
            g.drawImage(this.getCoin3().getImage(), 1100, 750, null);
        }
        if (this.coin4.isShow()) {
            g.drawImage(this.getCoin4().getImage(), 1300, 750, null);
        }
        g.fillRect(1750 , 600 , 50 , 200);
        appearanceOfPlant(g);
    }
    public boolean jump(Character character){
        if (this.finish){
            return false;
        }
        if (character.getY() == 725){
            return true;
        }
        if (character.getY() == wallHaveThings1.getY() - 75 &&
                character.getX() >= wallHaveThings1.getX() - 50 &&
                character.getX() <= wallHaveThings1.getX() + 50){
            return true;
        }
        if (character.getY() == wallHaveThings2.getY() - 75 &&
                character.getX() >= wallHaveThings2.getX() - 50 &&
                character.getX() <= wallHaveThings2.getX() + 50){
            return true;
        }
        if (character.getY() == bigTube.getY() - 75 &&
                character.getX() >= bigTube.getX() - 50 &&
                character.getX() <= bigTube.getX() + 100) {
            return true;
        }
        if (character.getY() == wall5.getY() - 75 &&
                character.getX() >= wall5.getX() - 50 &&
                character.getX() <= wall8.getX() + 50){
            return true;
        }
        return character.getY() == wall1.getY() - 75 &&
                character.getX() >= wall1.getX() - 50 &&
                character.getX() <= wall4.getX() + 50;
    }
    public void appearanceOfPlant(Graphics g){
        plant.setTime(plant.getTime() + 5);
        if (plant.getTime() >= 5000){
            plant.setTime(0);
            plant.setExist(!plant.isExist());
        }
        if (plant.isExist()) {
            g.drawImage(this.plant.getImage() , 825 , 550 , null);
        }
    }
    //------------------------------------------------getters---------------------------------------------------------//


    public boolean isFinish() {
        return finish;
    }

    public Image getBackGround() {
        return backGround;
    }

    public BigTube getBigTube() {
        return bigTube;
    }

    public Plant getPlant() {
        return plant;
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

    public Wall getWall6() {
        return wall6;
    }

    public Wall getWall7() {
        return wall7;
    }

    public Wall getWall8() {
        return wall8;
    }

    public WallHaveThings getWallHaveThings1() {
        return wallHaveThings1;
    }

    public WallHaveThings getWallHaveThings2() {
        return wallHaveThings2;
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

    public void setBigTube(BigTube bigTube) {
        this.bigTube = bigTube;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
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

    public void setWall6(Wall wall6) {
        this.wall6 = wall6;
    }

    public void setWall7(Wall wall7) {
        this.wall7 = wall7;
    }

    public void setWall8(Wall wall8) {
        this.wall8 = wall8;
    }

    public void setWallHaveThings1(WallHaveThings wallHaveThings1) {
        this.wallHaveThings1 = wallHaveThings1;
    }

    public void setWallHaveThings2(WallHaveThings wallHaveThings2) {
        this.wallHaveThings2 = wallHaveThings2;
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
