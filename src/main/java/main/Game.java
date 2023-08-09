package main;

import characters.Character;
import characters.Toad;
import objects.Coin;
import objects.WallHaveThings;
import scenes.*;

import javax.swing.*;
import java.awt.*;
public class Game {
    public boolean continueGame = true;
    public int time = 30000;
    public int initCoin = 0;
    public int initScore = 0;
    public int numberOfUsePowerUp = 0;
    public Character selectedCharacter;
    public String helpSelectedCharacter;
    public boolean inSection1 = true;
    public boolean inSection2 = false;
    public Scene1OfSection1OfLevel1 scene1 = new Scene1OfSection1OfLevel1();
    public Scene2OfSection1OfLevel1 scene2 = new Scene2OfSection1OfLevel1();
    public Scene3OfSection1OfLevel1 scene3 = new Scene3OfSection1OfLevel1();
    public Scene4OfSection1OfLevel1 scene4 = new Scene4OfSection1OfLevel1();
    public Scene1OfSection2OfLevel1 scene5 = new Scene1OfSection2OfLevel1();
    public Scene2OfSection2OfLevel1 scene6 = new Scene2OfSection2OfLevel1();
    public Scene3OfSection2OfLevel1 scene7 = new Scene3OfSection2OfLevel1();
    public Scene4OfSection2OfLevel1 scene8 = new Scene4OfSection2OfLevel1();

    //-------------------------------------------------important methods----------------------------------------------//
    public void paint(PanelOfGame panelOfGame) {
        time -= 5;
        panelOfGame.repaint();
    }

    public void move(User user ,int show , String fromWay) {
        if (gameOver()){
            finishGame(true , show , user , fromWay);
        }
        selectedCharacter.move();
    }
    public void level1(Graphics g , int show , User user , String fromWay) {
        finishTime();
        if (inSection1) {
            section1_Level1(g , show , user , fromWay);
        }
        else if (inSection2){
            section2_Level1(g , show , user , fromWay);
        }
    }

    public void section1_Level1(Graphics g , int show , User user , String fromWay) {
        if (selectedCharacter.isDecreaseHeart()) {
            loseInSection1();
            selectedCharacter.setDecreaseHeart(false);
            time = 30000;
        }
        if (!scene1.isFinish()) {
            scene1_Section1_Level1(g);
        }
        else if (!scene2.isFinish()) {
            scene2_Section1_Level1(g);
        }
        else if (!scene3.isFinish()) {
            scene3_Section1_Level1(g);
        }
        else if (!scene4.isFinish()){
            scene4_Section1_Level1(g , show , user , fromWay);
        }
    }
    public void section2_Level1(Graphics g , int show , User user , String fromWay) {
        if (selectedCharacter.isDecreaseHeart()) {
            loseInSection2();
            selectedCharacter.setDecreaseHeart(false);
            time = 30000;
        }
        if (!scene5.isFinish()) {
            scene1_Section2_Level1(g);
        }
        else if (!scene6.isFinish()) {
            scene2_Section2_Level1(g);
        }
        else if (!scene7.isFinish()) {
            scene3_Section2_Level1(g);
        }
        else if (!scene8.isFinish()){
            scene4_Section2_Level1(g , show , user , fromWay);
        }
    }
    public void checkCoin(Coin coin){
        if (coin.isShow()) {
            if (selectedCharacter instanceof Toad){
                if (selectedCharacter.getX() >= coin.getX() - 150 && selectedCharacter.getX() <= coin.getX() + 150){
                    if (selectedCharacter.getY() >= coin.getY() - 200 && selectedCharacter.getY() <= coin.getY() + 200) {
                        initCoin++;
                        coin.setShow(false);
                    }
                }
            }
            else {
                if (selectedCharacter.getX() >= coin.getX() - 50 && selectedCharacter.getX() <= coin.getX() + 50) {
                    if (selectedCharacter.getY() >= coin.getY() - 75 && selectedCharacter.getY() <= coin.getY() + 75) {
                        initCoin++;
                        coin.setShow(false);
                    }
                }
            }
        }
    }
    public boolean checkJump(){
        if (!scene1.isFinish()){
            return scene1.jump(selectedCharacter);
        }
        else if (!scene2.isFinish()){
            return scene2.jump(selectedCharacter);
        }
        else if (!scene3.isFinish()){
            return scene3.jump(selectedCharacter);
        }
        else if (!scene4.isFinish()){
            return scene4.jump(selectedCharacter);
        }
        else if (!scene5.isFinish()){
            return scene5.jump(selectedCharacter);
        }
        else if (!scene6.isFinish()){
            return scene6.jump(selectedCharacter);
        }
        else if (!scene7.isFinish()){
            return scene7.jump(selectedCharacter);
        }
        else if (!scene8.isFinish()){
            return scene8.jump(selectedCharacter);
        }
        else {
            return true;
        }
    }
    public void paintInformation(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Coin : " + initCoin, 50, 50);
        g.drawString("Heart : " + selectedCharacter.getHeart(), 350, 50);
        g.drawString("Time : " + time / 1000, 650 , 50);
        g.drawString("Score : " + initScore , 950 , 50);
        if (inSection1){
            g.drawString("World 1-1" , 1450 , 50);
        }
        else if (inSection2){
            g.drawString("World 1-2" , 1450 , 50);
        }
    }
    public void collisionWallHaveThings(WallHaveThings wallHaveThings){
        if (selectedCharacter.getX() >= wallHaveThings.getX() - 50 &&
                selectedCharacter.getX() <= wallHaveThings.getX() + 50 &&
                selectedCharacter.getY() == wallHaveThings.getY() + 50){
            //Random random = new Random();
            //int chance = random.nextInt(2);
            //if (chance == 0) {
                initCoin++;
            //}
            //else{
            //    powerUp();
            //}
            wallHaveThings.setHit(true);
        }
    }
    public void finishGame(boolean gameOver , int show , User user , String fromWay){
        continueGame = false;
        user.getScores().add(initScore);
        if (show == 1) {
            Main.timer1.stop();
            if (fromWay.equals("Continue")) {
                Main.frameContinueGame1.setVisible(false);
            }
            else if (fromWay.equals("New")) {
                Main.frameNewGame1.setVisible(false);
            }
            Main.newButton1.setText("Null");
            user.setNewButton1(false);
            Main.continueButton1.setText("Null");
            user.setContinueButton1(false);
            user.setGame1(null);
        }
        else if (show == 2) {
            Main.timer2.stop();
            if (fromWay.equals("Continue")) {
                Main.frameContinueGame2.setVisible(false);
            }
            else if (fromWay.equals("New")) {
                Main.frameNewGame2.setVisible(false);
            }
            Main.newButton2.setText("Null");
            user.setNewButton2(false);
            Main.continueButton2.setText("Null");
            user.setContinueButton2(false);
            user.setGame2(null);
        }
        else if (show == 3) {
            Main.timer3.stop();
            if (fromWay.equals("Continue")) {
                Main.frameContinueGame3.setVisible(false);
            }
            else if (fromWay.equals("New")) {
                Main.frameNewGame3.setVisible(false);
            }
            Main.newButton3.setText("Null");
            user.setNewButton3(false);
            Main.continueButton3.setText("Null");
            user.setContinueButton3(false);
            user.setGame3(null);
        }
        Main.frameMain.setVisible(true);
        if (gameOver){
            JOptionPane.showMessageDialog(Main.frameMain , "You are loser" , "Game Over" , JOptionPane.WARNING_MESSAGE);
        }
    }
    public void finishTime(){
        if (time <= 0){
            selectedCharacter.setHeart(selectedCharacter.getHeart() - 1);
            selectedCharacter.setDecreaseHeart(true);
            selectedCharacter.setX(0);
            selectedCharacter.setY(725);
            time = 30000;
        }
    }
    public void loseInSection1(){
        scene1.setFinish(false);
        scene1.getCoin1().setShow(true);
        scene1.getCoin2().setShow(true);
        scene1.getCoin3().setShow(true);
        scene1.getCoin4().setShow(true);
        scene2.setFinish(false);
        scene2.getCoin1().setShow(true);
        scene2.getCoin2().setShow(true);
        scene2.getCoin3().setShow(true);
        scene2.getCoin4().setShow(true);
        scene3.setFinish(false);
        scene3.getCoin1().setShow(true);
        scene3.getCoin2().setShow(true);
        scene3.getCoin3().setShow(true);
        scene3.getCoin4().setShow(true);
        scene4.setFinish(false);
        scene4.getCoin1().setShow(true);
        scene4.getCoin2().setShow(true);
        scene4.getCoin3().setShow(true);
        scene4.getCoin4().setShow(true);
        initCoin = 0;
        initScore = 0;
    }
    public void loseInSection2(){
        scene5.setFinish(false);
        scene5.getCoin1().setShow(true);
        scene5.getCoin2().setShow(true);
        scene5.getCoin3().setShow(true);
        scene5.getCoin4().setShow(true);
        scene6.setFinish(false);
        scene6.getCoin1().setShow(true);
        scene6.getCoin2().setShow(true);
        scene6.getCoin3().setShow(true);
        scene6.getCoin4().setShow(true);
        scene7.setFinish(false);
        scene7.getCoin1().setShow(true);
        scene7.getCoin2().setShow(true);
        scene7.getCoin3().setShow(true);
        scene7.getCoin4().setShow(true);
        scene8.setFinish(false);
        scene8.getCoin1().setShow(true);
        scene8.getCoin2().setShow(true);
        scene8.getCoin3().setShow(true);
        scene8.getCoin4().setShow(true);
        initCoin = 0;
        initScore = 0;
    }
    public void powerUp(){
        numberOfUsePowerUp++;
        if (numberOfUsePowerUp == 1){
            selectedCharacter.setStrongMan(true);
        }
        else {
            selectedCharacter.setUseGun(true);
        }
    }
    public boolean gameOver(){
        return selectedCharacter.getHeart() == 0;
    }

    //--------------------------------------------------Scene 1-------------------------------------------------------//
    public void scene1_Section1_Level1(Graphics g) {
        scene1.drawImage(g);
        if (gravityInScene1()){
            selectedCharacter.setY(selectedCharacter.getY() + 5);
        } //for gravity
        collisionInScene1();
        checkCoinInScene1();
        if (finishInScene1()){
            scene1.setFinish(true);
            selectedCharacter.setY(725);
            selectedCharacter.setX(0);
        } // for finish
    }
    public boolean gravityInScene1(){
        if (selectedCharacter.getY() >= 725){
            return false;
        }
        if (selectedCharacter.getY() == scene1.getWall1().getY() - 75 &&
                selectedCharacter.getX() >= scene1.getWall1().getX() - 50 &&
                selectedCharacter.getX() <= scene1.getWall4().getX() + 50){
            return false;
        }
        return selectedCharacter.getY() != scene1.getSmallTube().getY() - 75 ||
                selectedCharacter.getX() < scene1.getSmallTube().getX() - 50 ||
                selectedCharacter.getX() > scene1.getSmallTube().getX() + 100;
    }
    public boolean finishInScene1(){
        return selectedCharacter.getX() >= 1750 && selectedCharacter.getY() >= 600;
    }
    public void checkCoinInScene1(){
        checkCoin(scene1.getCoin1());
        checkCoin(scene1.getCoin2());
        checkCoin(scene1.getCoin3());
        checkCoin(scene1.getCoin4());
    }
    public void collisionInScene1(){
        scene1.getWall1().collision(selectedCharacter);
        scene1.getWall2().collision(selectedCharacter);
        scene1.getWall3().collision(selectedCharacter);
        scene1.getWall4().collision(selectedCharacter);
        scene1.getSmallTube().collision(selectedCharacter);
    }

    //--------------------------------------------------Scene 2-------------------------------------------------------//
    public void scene2_Section1_Level1(Graphics g) {
        scene2.drawImage(g);
        if (gravityInScene2()){
            selectedCharacter.setY(selectedCharacter.getY() + 5);
        } //for gravity
        collisionInScene2();
        checkCoinInScene2();
        if (finishInScene2()){
            scene2.setFinish(true);
            selectedCharacter.setY(725);
            selectedCharacter.setX(0);
        } // for finish
    }
    public boolean gravityInScene2(){
        if (selectedCharacter.getY() >= 725){
            return false;
        }
        if (selectedCharacter.getY() == scene2.getWall1().getY() - 75 &&
                selectedCharacter.getX() >= scene2.getWall1().getX() - 50 &&
                selectedCharacter.getX() <= scene2.getWall4().getX() + 50){
            return false;
        }
        return selectedCharacter.getY() != scene2.getBigTube().getY() - 75 ||
                selectedCharacter.getX() < scene2.getBigTube().getX() - 50 ||
                selectedCharacter.getX() > scene2.getBigTube().getX() + 100;
    }
    public boolean finishInScene2(){
        return selectedCharacter.getX() >= 1750 && selectedCharacter.getY() >= 600;
    }
    public void checkCoinInScene2(){
        checkCoin(scene2.getCoin1());
        checkCoin(scene2.getCoin2());
        checkCoin(scene2.getCoin3());
        checkCoin(scene2.getCoin4());
    }
    public void collisionInScene2(){
        scene2.getWall1().collision(selectedCharacter);
        scene2.getWall2().collision(selectedCharacter);
        scene2.getWall3().collision(selectedCharacter);
        scene2.getWall4().collision(selectedCharacter);
        scene2.getBigTube().collision(selectedCharacter);
    }
    //--------------------------------------------------Scene 3-------------------------------------------------------//
    public void scene3_Section1_Level1(Graphics g) {
        scene3.drawImage(g);
        if (gravityInScene3()){
            selectedCharacter.setY(selectedCharacter.getY() + 5);
        } //for gravity
        collisionInScene3();
        checkCoinInScene3();
        if (finishInScene3()){
            scene3.setFinish(true);
            selectedCharacter.setY(725);
            selectedCharacter.setX(0);
        } // for finish
    }
    public boolean gravityInScene3(){
        if (selectedCharacter.getY() >= 725){
            return false;
        }
        if (selectedCharacter.getY() == scene3.getSmallTube().getY() - 75 &&
                selectedCharacter.getX() >= scene3.getSmallTube().getX() - 50 &&
                selectedCharacter.getX() <= scene3.getSmallTube().getX() + 100){
            return false;
        }
        return selectedCharacter.getY() != scene3.getBigTube().getY() - 75 ||
                selectedCharacter.getX() < scene3.getBigTube().getX() - 50 ||
                selectedCharacter.getX() > scene3.getBigTube().getX() + 100;
    }
    public boolean finishInScene3(){
        return selectedCharacter.getX() >= 1750 && selectedCharacter.getY() >= 600;
    }
    public void checkCoinInScene3(){
        checkCoin(scene3.getCoin1());
        checkCoin(scene3.getCoin2());
        checkCoin(scene3.getCoin3());
        checkCoin(scene3.getCoin4());
    }
    public void collisionInScene3(){
        scene3.getPlant().collision(selectedCharacter);
        scene3.getSmallTube().collision(selectedCharacter);
        scene3.getBigTube().collision(selectedCharacter);
    }
    //--------------------------------------------------Scene 4-------------------------------------------------------//
    public void scene4_Section1_Level1(Graphics g ,int show , User user , String fromWay) {
        scene4.drawImage(g);
        if (gravityInScene4()){
            selectedCharacter.setY(selectedCharacter.getY() + 5);
        } //for gravity
        collisionInScene4();
        checkCoinInScene4();
        if (finishInScene4()){
            scene4.setFinish(true);
            selectedCharacter.setY(725);
            selectedCharacter.setX(0);
            initScore += (10 * initCoin)+(selectedCharacter.getHeart() * 20)+
                    (time/1000); //+(killed enemy = 15) * (numberOfPowerUp + 1)
            time = 30000;
            user.setCoin(user.getCoin() + initCoin);
            initCoin = 0;
            inSection1 = false;
            inSection2 = true;
            //numberOfUsePowerUp = 0;
            //selectedCharacter.setUseGun(false);
            //selectedCharacter.setStrongMan(false);
        } // for finish
    }
    public boolean gravityInScene4(){
        if (selectedCharacter.getY() >= 725 && !(selectedCharacter.getX() >= scene4.getHollow().getX() &&
                selectedCharacter.getX() <= scene4.getHollow().getX() + 150)){
            return false;
        }
        return selectedCharacter.getY() != scene2.getWall1().getY() - 75 ||
                selectedCharacter.getX() < scene2.getWall1().getX() - 50 ||
                selectedCharacter.getX() > scene2.getWall4().getX() + 50;
    }
    public boolean finishInScene4(){
        return selectedCharacter.getX() >= 1750 && selectedCharacter.getY() >= 600;
    }
    public void checkCoinInScene4(){
        checkCoin(scene4.getCoin1());
        checkCoin(scene4.getCoin2());
        checkCoin(scene4.getCoin3());
        checkCoin(scene4.getCoin4());
    }
    public void collisionInScene4(){
        scene4.getWall1().collision(selectedCharacter);
        scene4.getWall2().collision(selectedCharacter);
        scene4.getWall3().collision(selectedCharacter);
        scene4.getWall4().collision(selectedCharacter);
    }
    //--------------------------------------------------Scene 5-------------------------------------------------------//
    public void scene1_Section2_Level1(Graphics g) {
        scene5.drawImage(g);
        if (gravityInScene5()){
            selectedCharacter.setY(selectedCharacter.getY() + 5);
        } //for gravity
        collisionInScene5();
        checkCoinInScene5();
        if (finishInScene5()){
            scene5.setFinish(true);
            selectedCharacter.setY(725);
            selectedCharacter.setX(0);
        } // for finish
    }
    public boolean gravityInScene5(){
        if (selectedCharacter.getY() >= 725 && !(selectedCharacter.getX() >= scene5.getHollow().getX() &&
                selectedCharacter.getX() <= scene5.getHollow().getX() + 150)){
            return false;
        }
        if (selectedCharacter.getY() == scene5.getWallHaveThings().getY() - 75 &&
                selectedCharacter.getX() >= scene5.getWallHaveThings().getX() - 50 &&
                selectedCharacter.getX() <= scene5.getWallHaveThings().getX() + 50){
            return false;
        }
        if (selectedCharacter.getY() == scene5.getBigTube().getY() - 75 &&
                selectedCharacter.getX() >= scene5.getBigTube().getX() - 50 &&
                selectedCharacter.getX() <= scene5.getBigTube().getX() + 100){
            return false;
        }
        return selectedCharacter.getY() != scene5.getSmallTube().getY() - 75 ||
                selectedCharacter.getX() < scene5.getSmallTube().getX() - 50 ||
                selectedCharacter.getX() > scene5.getSmallTube().getX() + 100;
    }
    public boolean finishInScene5(){
        return selectedCharacter.getX() >= 1750 && selectedCharacter.getY() >= 600;
    }
    public void checkCoinInScene5(){
        checkCoin(scene5.getCoin1());
        checkCoin(scene5.getCoin2());
        checkCoin(scene5.getCoin3());
        checkCoin(scene5.getCoin4());
    }
    public void collisionInScene5(){
        if (!scene5.getWallHaveThings().isHit()) {
            collisionWallHaveThings(scene5.getWallHaveThings());
        }
        scene5.getWallHaveThings().collision(selectedCharacter);
        scene5.getBigTube().collision(selectedCharacter);
        scene5.getSmallTube().collision(selectedCharacter);
    }

    //--------------------------------------------------Scene 6-------------------------------------------------------//
    public void scene2_Section2_Level1(Graphics g) {
        scene6.drawImage(g);
        if (gravityInScene6()){
            selectedCharacter.setY(selectedCharacter.getY() + 5);
        } //for gravity
        collisionInScene6();
        checkCoinInScene6();
        if (finishInScene6()){
            scene6.setFinish(true);
            selectedCharacter.setY(725);
            selectedCharacter.setX(0);
        } // for finish
    }
    public boolean gravityInScene6(){
        if (selectedCharacter.getY() >= 725 ){
            return false;
        }
        if (selectedCharacter.getY() == scene6.getWall1().getY() - 75 &&
                selectedCharacter.getX() >= scene6.getWall1().getX() - 50 &&
                selectedCharacter.getX() <= scene6.getWall5().getX() + 50) {
            return false;
        }
        return selectedCharacter.getY() != scene6.getWall6().getY() - 75 ||
                selectedCharacter.getX() < scene6.getWall6().getX() - 50 ||
                selectedCharacter.getX() > scene6.getWall10().getX() + 50;
    }
    public boolean finishInScene6(){
        return selectedCharacter.getX() >= 1750 && selectedCharacter.getY() >= 600;
    }
    public void checkCoinInScene6(){
        checkCoin(scene6.getCoin1());
        checkCoin(scene6.getCoin2());
        checkCoin(scene6.getCoin3());
        checkCoin(scene6.getCoin4());
    }
    public void collisionInScene6(){
        scene6.getWall1().collision(selectedCharacter);
        scene6.getWall2().collision(selectedCharacter);
        scene6.getWall3().collision(selectedCharacter);
        scene6.getWall4().collision(selectedCharacter);
        scene6.getWall5().collision(selectedCharacter);
        scene6.getWall6().collision(selectedCharacter);
        scene6.getWall7().collision(selectedCharacter);
        scene6.getWall8().collision(selectedCharacter);
        scene6.getWall9().collision(selectedCharacter);
        scene6.getWall10().collision(selectedCharacter);
        scene6.getTubeHide().collision(selectedCharacter);
    }
    //--------------------------------------------------Scene 7-------------------------------------------------------//
    public void scene3_Section2_Level1(Graphics g) {
        scene7.drawImage(g);
        if (gravityInScene7()){
            selectedCharacter.setY(selectedCharacter.getY() + 5);
        } //for gravity
        collisionInScene7();
        checkCoinInScene7();
        if (finishInScene7()){
            scene7.setFinish(true);
            selectedCharacter.setY(725);
            selectedCharacter.setX(0);
        } // for finish
    }
    public boolean gravityInScene7(){
        if (selectedCharacter.getY() >= 725){
            return false;
        }
        if (selectedCharacter.getY() == scene7.getSmallTube1().getY() - 75 &&
                selectedCharacter.getX() >= scene7.getSmallTube1().getX() - 50 &&
                selectedCharacter.getX() <= scene7.getSmallTube1().getX() + 100) {
            return false;
        }
        if (selectedCharacter.getY() == scene7.getSmallTube2().getY() - 75 &&
                selectedCharacter.getX() >= scene7.getSmallTube2().getX() - 50 &&
                selectedCharacter.getX() <= scene7.getSmallTube2().getX() + 100) {
            return false;
        }
        if (selectedCharacter.getY() == scene7.getBigTube1().getY() - 75 &&
                selectedCharacter.getX() >= scene7.getBigTube1().getX() - 50 &&
                selectedCharacter.getX() <= scene7.getBigTube1().getX() + 100) {
            return false;
        }
        if (selectedCharacter.getY() == scene7.getBigTube2().getY() - 75 &&
                selectedCharacter.getX() >= scene7.getBigTube2().getX() - 50 &&
                selectedCharacter.getX() <= scene7.getBigTube2().getX() + 100) {
            return false;
        }
        return selectedCharacter.getY() != scene7.getWall1().getY() - 75 ||
                selectedCharacter.getX() < scene7.getWall1().getX() - 50 ||
                selectedCharacter.getX() > scene7.getWall4().getX() + 50;
    }
    public boolean finishInScene7(){
        return selectedCharacter.getX() >= 1750 && selectedCharacter.getY() >= 600;
    }
    public void checkCoinInScene7(){
        checkCoin(scene7.getCoin1());
        checkCoin(scene7.getCoin2());
        checkCoin(scene7.getCoin3());
        checkCoin(scene7.getCoin4());
    }
    public void collisionInScene7(){
        scene7.getBigTube1().collision(selectedCharacter);
        scene7.getBigTube2().collision(selectedCharacter);
        scene7.getSmallTube1().collision(selectedCharacter);
        scene7.getSmallTube2().collision(selectedCharacter);
        scene7.getWall1().collision(selectedCharacter);
        scene7.getWall2().collision(selectedCharacter);
        scene7.getWall3().collision(selectedCharacter);
        scene7.getWall4().collision(selectedCharacter);
        scene7.getPlant1().collision(selectedCharacter);
        scene7.getPlant2().collision(selectedCharacter);
        scene7.getPlant3().collision(selectedCharacter);
        scene7.getPlant4().collision(selectedCharacter);
    }
    //--------------------------------------------------Scene 8-------------------------------------------------------//
    public void scene4_Section2_Level1(Graphics g , int show , User user , String fromWay) {
        scene8.drawImage(g);
        if (gravityInScene8()){
            selectedCharacter.setY(selectedCharacter.getY() + 5);
        } //for gravity
        collisionInScene8();
        checkCoinInScene8();
        if (finishInScene8()){
            scene8.setFinish(true);
            selectedCharacter.setY(725);
            selectedCharacter.setX(0);
            initScore += (10 * initCoin)+(selectedCharacter.getHeart() * 20)+
                    (time/1000); //+(killed enemy = 15) * (numberOfPowerUp + 1)
            time = 30000;
            user.setCoin(user.getCoin() + initCoin);
            initCoin = 0;
            finishGame(false , show , user , fromWay);
            inSection2 = false;
            //TODO inSection3 = true;
            //numberOfUsePowerUp = 0;
            //selectedCharacter.setUseGun(false);
            //selectedCharacter.setStrongMan(false);
        } // for finish
    }
    public boolean gravityInScene8(){
        if (selectedCharacter.getY() >= 725){
            return false;
        }
        if (selectedCharacter.getY() == scene8.getWallHaveThings1().getY() - 75 &&
                selectedCharacter.getX() >= scene8.getWallHaveThings1().getX() - 50 &&
                selectedCharacter.getX() <= scene8.getWallHaveThings1().getX() + 50){
            return false;
        }
        if (selectedCharacter.getY() == scene8.getWallHaveThings2().getY() - 75 &&
                selectedCharacter.getX() >= scene8.getWallHaveThings2().getX() - 50 &&
                selectedCharacter.getX() <= scene8.getWallHaveThings2().getX() + 50){
            return false;
        }
        if (selectedCharacter.getY() == scene8.getBigTube().getY() - 75 &&
                selectedCharacter.getX() >= scene8.getBigTube().getX() - 50 &&
                selectedCharacter.getX() <= scene8.getBigTube().getX() + 100) {
            return false;
        }
        if (selectedCharacter.getY() == scene8.getWall5().getY() - 75 &&
                selectedCharacter.getX() >= scene8.getWall5().getX() - 50 &&
                selectedCharacter.getX() <= scene8.getWall8().getX() + 50){
            return false;
        }
        return selectedCharacter.getY() != scene8.getWall1().getY() - 75 ||
                selectedCharacter.getX() < scene8.getWall1().getX() - 50 ||
                selectedCharacter.getX() > scene8.getWall4().getX() + 50;
    }
    public boolean finishInScene8(){
        return selectedCharacter.getX() >= 1750 && selectedCharacter.getY() >= 600;
    }
    public void checkCoinInScene8(){
        checkCoin(scene8.getCoin1());
        checkCoin(scene8.getCoin2());
        checkCoin(scene8.getCoin3());
        checkCoin(scene8.getCoin4());
    }
    public void collisionInScene8(){
        if (!scene8.getWallHaveThings1( ).isHit()) {
            collisionWallHaveThings(scene8.getWallHaveThings1());
        }
        scene8.getWallHaveThings1().collision(selectedCharacter);
        if (!scene8.getWallHaveThings2( ).isHit()) {
            collisionWallHaveThings(scene8.getWallHaveThings2());
        }
        scene8.getWallHaveThings2().collision(selectedCharacter);
        scene8.getBigTube().collision(selectedCharacter);
        scene8.getWall1().collision(selectedCharacter);
        scene8.getWall2().collision(selectedCharacter);
        scene8.getWall3().collision(selectedCharacter);
        scene8.getWall4().collision(selectedCharacter);
        scene8.getWall5().collision(selectedCharacter);
        scene8.getWall6().collision(selectedCharacter);
        scene8.getWall7().collision(selectedCharacter);
        scene8.getWall8().collision(selectedCharacter);
        scene8.getPlant().collision(selectedCharacter);
    }
    //--------------------------------------------------------getters-------------------------------------------------//

    public int getTime() {
        return time;
    }

    public String getHelpSelectedCharacter() {
        return helpSelectedCharacter;
    }

    public int getInitCoin() {
        return initCoin;
    }

    public int getInitScore() {
        return initScore;
    }

    public Scene1OfSection1OfLevel1 getScene1() {
        return scene1;
    }

    public Scene2OfSection1OfLevel1 getScene2() {
        return scene2;
    }

    public Scene3OfSection1OfLevel1 getScene3() {
        return scene3;
    }

    public Scene4OfSection1OfLevel1 getScene4() {
        return scene4;
    }

    public Scene1OfSection2OfLevel1 getScene5() {
        return scene5;
    }

    public Scene2OfSection2OfLevel1 getScene6() {
        return scene6;
    }

    public Scene3OfSection2OfLevel1 getScene7() {
        return scene7;
    }

    public Scene4OfSection2OfLevel1 getScene8() {
        return scene8;
    }
    public Character getSelectedCharacter() {
        return selectedCharacter;
    }

    public boolean isContinueGame() {
        return continueGame;
    }
    //--------------------------------------------------------setters-------------------------------------------------//

    public void setTime(int time) {
        this.time = time;
    }

    public void setInitCoin(int initCoin) {
        this.initCoin = initCoin;
    }

    public void setInitScore(int initScore) {
        this.initScore = initScore;
    }

    public void setScene1(Scene1OfSection1OfLevel1 scene1) {
        this.scene1 = scene1;
    }

    public void setScene2(Scene2OfSection1OfLevel1 scene2) {
        this.scene2 = scene2;
    }

    public void setScene3(Scene3OfSection1OfLevel1 scene3) {
        this.scene3 = scene3;
    }

    public void setScene4(Scene4OfSection1OfLevel1 scene4) {
        this.scene4 = scene4;
    }

    public void setScene5(Scene1OfSection2OfLevel1 scene5) {
        this.scene5 = scene5;
    }

    public void setScene6(Scene2OfSection2OfLevel1 scene6) {
        this.scene6 = scene6;
    }

    public void setScene7(Scene3OfSection2OfLevel1 scene7) {
        this.scene7 = scene7;
    }

    public void setScene8(Scene4OfSection2OfLevel1 scene8) {
        this.scene8 = scene8;
    }

    public void setSelectedCharacter(Character selectedCharacter) {
        this.selectedCharacter = selectedCharacter;
    }

    public void setContinueGame(boolean continueGame) {
        this.continueGame = continueGame;
    }

    public void setHelpSelectedCharacter(String helpSelectedCharacter) {
        this.helpSelectedCharacter = helpSelectedCharacter;
    }
}
