package main;
import characters.Character;
import characters.*;
import database.Files;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    //------------------------------------------------fields----------------------------------------------------------//
    public static JFrame frameEnter = new JFrame("Enter");
    public static JFrame frameSignUp = new JFrame("Sign Up");
    public static JFrame frameLogIn = new JFrame("Log In");
    public static JFrame frameMain = new JFrame("Main Panel");
    public static JFrame frameNewGame = new JFrame("New Game");
    public static JFrame frameContinueGame = new JFrame("Continue Game");
    public static JFrame frameHighestResults = new JFrame("Highest Results");
    public static JFrame frameStore = new JFrame("Store");
    public static JFrame frameProfile = new JFrame("Profile");
    public static JFrame frameDifficulty = new JFrame("Select Difficulty and Character");
    public static JFrame frameNewGame1;
    public static JFrame frameNewGame2;
    public static JFrame frameNewGame3;
    public static JFrame frameContinueGame1;
    public static JFrame frameContinueGame2;
    public static JFrame frameContinueGame3;
    //**************************
    public static JButton backToMenu = new JButton("Back to menu");
    public static JButton backToEnter = new JButton("Back and enter with new account");
    public static JButton signUp = new JButton("Sign Up");
    public static JButton logIn = new JButton("Log In");
    public static JButton exit = new JButton("Exit");
    public static JButton signUpNext = new JButton("Next");
    public static JButton logInNext = new JButton("Next");
    public static JButton newGame = new JButton("New Game");
    public static JButton continueGames = new JButton("Continue Games");
    public static JButton highestResults = new JButton("Highest Results");
    public static JButton coins = new JButton("My Coins");
    public static JButton store = new JButton("Store");
    public static JButton profile = new JButton("My Profile");
    public static JButton buyBoo = new JButton("Buy Boo");
    public static JButton buyWario = new JButton("Buy Wario");
    public static JButton buyToad = new JButton("Buy Toad");
    public static JButton buyYoshi = new JButton("Buy Yoshi");
    public static JButton selectBoo = new JButton("Select Boo");
    public static JButton selectWario = new JButton("Select Wario");
    public static JButton selectToad = new JButton("Select Toad");
    public static JButton selectYoshi = new JButton("Select Yoshi");
    public static JButton selectMario = new JButton("Select Mario");
    public static JButton startGame = new JButton("Start Game");
    public static JButton deleteSelectedGames = new JButton("Delete Selected Games");
    public static JButton newButton1 = new JButton("Null");
    public static JButton newButton2 = new JButton("Null");
    public static JButton newButton3 = new JButton("Null");
    public static JButton continueButton1 = new JButton("Null");
    public static JButton continueButton2 = new JButton("Null");
    public static JButton continueButton3 = new JButton("Null");
    //**************************
    public static JTextField signUpUserName = new JTextField("Enter your username");
    public static JTextField signUpPassWord = new JTextField("Enter your password");
    public static JTextField logInUserName = new JTextField("Enter your username");
    public static JTextField logInPassWord = new JTextField("Enter your password");
    //**************************
    public static JLabel labelOfBoo = new JLabel(Boo.getImageIcon());
    public static JLabel labelOfWario = new JLabel(Wario.getImageIcon());
    public static JLabel labelOfToad = new JLabel(Toad.getImageIcon());
    public static JLabel labelOfYoshi = new JLabel(Yoshi.getImageIcon());
    public static JLabel coinOfBoo = new JLabel("For buy Boo (move faster) , you need to 20 coins");
    public static JLabel coinOfWario = new JLabel("For buy Wario (higher jump) , you need to 30 coins");
    public static JLabel coinOfToad = new JLabel("For buy Toad (attract coins) , you need to 20 coins");
    public static JLabel coinOfYoshi = new JLabel("For buy Yoshi (Throw arrows faster) , you need to 10 coins");
    public static JLabel selectedCharacter = new JLabel();
    public static JLabel pictureOfSelectedCharacter = new JLabel();
    public static JLabel nameOfUser = new JLabel();
    public static JLabel highestScore = new JLabel();
    public static JLabel pictureOfBoo = new JLabel(Boo.getImageIcon());
    public static JLabel pictureOfWario = new JLabel(Wario.getImageIcon());
    public static JLabel pictureOfToad = new JLabel(Toad.getImageIcon());
    public static JLabel pictureOfYoshi = new JLabel(Yoshi.getImageIcon());
    public static JLabel pictureOfMario = new JLabel(Mario.getImageIcon());
    public static JLabel selectDifficulty = new JLabel("Select Difficulty :");
    public static JLabel deleteGame = new JLabel("Select For Delete Game :");
    //**************************
    public static JRadioButton hard = new JRadioButton("Hard");
    public static JRadioButton medium = new JRadioButton("Medium");
    public static JRadioButton easy = new JRadioButton("Easy");
    public static ButtonGroup difficulty = new ButtonGroup();
    public static JRadioButton deleteGame1 = new JRadioButton("Delete Game 1");
    public static JRadioButton deleteGame2 = new JRadioButton("Delete Game 2");
    public static JRadioButton deleteGame3 = new JRadioButton("Delete Game 3");
    //**************************
    public static JTable tableOfHighestResults;
    //**************************
    public static ActionListener actionOfGame1 = null;
    public static Timer timer1 = new Timer(5, actionOfGame1);
    public static ActionListener actionOfGame2 = null;
    public static Timer timer2 = new Timer(5, actionOfGame2);
    public static ActionListener actionOfGame3 = null;
    public static Timer timer3 = new Timer(5, actionOfGame3);
    public static PanelOfGame panelOfGame1;
    public static PanelOfGame panelOfGame2;
    public static PanelOfGame panelOfGame3;
    public static boolean signUpFrame = false;
    public static boolean logInFrame = false;
    public static boolean mainFrame = false;
    public static boolean newGameFrame = false;
    public static boolean continueGameFrame = false;
    public static boolean highestResultsFrame = false;
    public static boolean storeFrame = false;
    public static boolean profileFrame = false;
    public static boolean difficultyFrame = false;

    //-------------------------------------------------important methods----------------------------------------------//
    public static void main(String[] args){
        Files.loadUsers();
        enter();
    }
    public static void enter() {
        initializeFrames(frameEnter);
        initializeButtons(signUp, frameEnter, 750, 250, 200, 100, e -> {
            if (signUpFrame) {
                frameEnter.setVisible(false);
                frameSignUp.setVisible(true);
            }
            else {
                signUp();
            }
        });
        initializeButtons(logIn, frameEnter, 750, 400, 200, 100, e -> {
            if (logInFrame) {
                frameEnter.setVisible(false);
                frameLogIn.setVisible(true);
            }
            else {
                logIn();
            }
        });
        initializeButtons(exit, frameEnter, 750, 550, 200, 100, e -> {
            Files.saveUser(Files.arrayUsers);
            System.exit(0);
        });
    }

    public static void signUp() {
        frameEnter.setVisible(false);
        initializeFrames(frameSignUp);
        initializeTextFields(signUpUserName, frameSignUp, 650, 250, 400, 50);
        initializeTextFields(signUpPassWord, frameSignUp, 650, 350, 400, 50);
        initializeButtons(signUpNext, frameSignUp, 750, 500, 200, 100, e -> initializeUser());
        initializeButtons(backToEnter , frameSignUp , 650 , 700 , 400 , 100 , e -> {
            frameSignUp.setVisible(false);
            frameEnter.setVisible(true);
            enter();
        });
        signUpFrame = true;
    }

    public static void logIn() {
        frameEnter.setVisible(false);
        initializeFrames(frameLogIn);
        initializeTextFields(logInUserName, frameLogIn, 650, 250, 400, 50);
        initializeTextFields(logInPassWord, frameLogIn, 650, 350, 400, 50);
        initializeButtons(logInNext, frameLogIn, 750, 500, 200, 100, e -> checkForExistUser());
        initializeButtons(backToEnter , frameLogIn , 650 , 700 , 400 , 100 ,  e -> {
            frameLogIn.setVisible(false);
            frameEnter.setVisible(true);
            enter();
        });
        logInFrame = true;
    }

    public static void mainPanel(User user) {
        frameSignUp.setVisible(false);
        frameLogIn.setVisible(false);
        initializeFrames(frameMain);
        initializeButtons(newGame, frameMain, 200, 200, 400, 100, e -> {
            if (newGameFrame) {
                frameMain.setVisible(false);
                frameNewGame.setVisible(true);
            }
            else {
                enterWithNewGame(user);
            }
        });
        initializeButtons(continueGames, frameMain, 700, 200, 400, 100, e -> {
            if (continueGameFrame) {
                frameMain.setVisible(false);
                frameContinueGame.setVisible(true);
            }
            else {
                enterWithContinueGames(user);
            }
        });
        initializeButtons(highestResults, frameMain, 1200, 200, 400, 100, e -> {
            if (highestResultsFrame) {
                frameMain.setVisible(false);
                frameHighestResults.setVisible(true);
            }
            else {
                highestResults();
            }
        });
        initializeButtons(coins, frameMain, 200, 400, 400, 100, e -> showCoins(user));
        initializeButtons(store, frameMain, 700, 400, 400, 100, e -> {
            if (storeFrame) {
                frameMain.setVisible(false);
                frameStore.setVisible(true);
            }
            else {
                store(user);
            }
        });
        initializeButtons(profile, frameMain, 1200, 400, 400, 100, e -> {
            if (profileFrame) {
                frameMain.setVisible(false);
                frameProfile.setVisible(true);
            }
            else {
                showProfile(user);
            }
        });
        initializeButtons(backToEnter , frameMain , 650 , 700 , 500 , 100 ,  e -> {
            frameMain.setVisible(false);
            frameEnter.setVisible(true);
        });
        mainFrame = true;
    }
    public static void enterWithNewGame(User user){
        frameMain.setVisible(false);
        initializeFrames(frameNewGame);
        if (user.isNewButton1()){
            newButton1.setText("Game1");
        }
        if (user.isNewButton2()){
            newButton2.setText("Game2");
        }
        if (user.isNewButton3()){
            newButton3.setText("Game3");
        }
        initializeButtons(newButton1 , frameNewGame, 450, 250, 200, 100, e -> initNewGame1(user));
        initializeButtons(newButton2 , frameNewGame, 450, 400, 200, 100, e -> initNewGame2(user));
        initializeButtons(newButton3 , frameNewGame, 450, 550, 200, 100, e -> initNewGame3(user));
        initDeleteGame(user);
        initializeButtons(backToMenu , frameNewGame , 450 , 700 , 200 , 100 ,  e -> {
            frameNewGame.setVisible(false);
            frameMain.setVisible(true);
        });
        newGameFrame = true;
    }
    public static void enterWithContinueGames(User user){
        frameMain.setVisible(false);
        initializeFrames(frameContinueGame);
        if (user.isContinueButton1()) {
            continueButton1.setText("Game1");
        }
        if (user.isContinueButton2()){
            continueButton2.setText("Game2");
        }
        if (user.isContinueButton3()){
            continueButton3.setText("Game3");
        }
        initializeButtons(continueButton1 , frameContinueGame, 450, 250, 200, 100, e -> initContinueGame1(user));
        initializeButtons(continueButton2 , frameContinueGame, 450, 400, 200, 100, e -> initContinueGame2(user));
        initializeButtons(continueButton3 , frameContinueGame, 450, 550, 200, 100, e -> initContinueGame3(user));
        initializeButtons(backToMenu , frameContinueGame , 450 , 700 , 200 , 100 , e -> {
            frameContinueGame.setVisible(false);
            frameMain.setVisible(true);
        });
        continueGameFrame = true;
    }
    public static void highestResults(){
        frameMain.setVisible(false);
        initializeFrames(frameHighestResults);
        frameHighestResults.add(initHighestResults());
        initializeButtons(backToMenu, frameHighestResults, 50, 50, 200, 100, e -> {
            frameHighestResults.setVisible(false);
            frameMain.setVisible(true);
        });
        highestResultsFrame = true;
    }
    public static void showCoins(User user){
        JOptionPane.showMessageDialog(frameMain , "Your number of coins : " + user.getCoin() , "Coin" , JOptionPane.WARNING_MESSAGE);
    }
    public static void store(User user){
        frameMain.setVisible(false);
        initializeFrames(frameStore);
        initStore(user);
        initializeButtons(backToMenu , frameStore , 50 , 50 , 200 , 100 , e -> {
            frameStore.setVisible(false);
            frameMain.setVisible(true);
        });
        storeFrame = true;
    }
    public static void showProfile(User user){
        frameMain.setVisible(false);
        initializeFrames(frameProfile);
        informationOfUser(user);
        chooseCharacter(user , frameProfile);
        initializeButtons(backToMenu , frameProfile , 50 , 850 , 200 , 100 , e -> {
            frameProfile.setVisible(false);
            frameMain.setVisible(true);
        });
        profileFrame = true;
    }
    public static void selectDifficulty(User user , int show){
        frameNewGame.setVisible(false);
        initializeFrames(frameDifficulty);
        initSelectDifficulty();
        chooseCharacter(user , frameDifficulty);
        initializeButtons(startGame, frameDifficulty, 50, 500, 100, 50, e -> newGame(user, show));
        difficultyFrame = true;
    }
    public static void newGame(User user , int show){
        frameDifficulty.setVisible(false);
        String fromWay = "New";
        nullAllFrames();
        if (show == 1) {
            frameNewGame1 = new JFrame("Game");
            initializeFrames(frameNewGame1);
            initGame(user, user.getGame1());
            panelOfGame1 = new PanelOfGame(user.getGame1() , show , user , fromWay);
            initializePanel(panelOfGame1, frameNewGame1);
            helpGame1(user , fromWay);
        }
        else if (show == 2){
            frameNewGame2 = new JFrame("Game");
            initializeFrames(frameNewGame2);
            initGame(user, user.getGame2());
            panelOfGame2 = new PanelOfGame(user.getGame2() , show , user , fromWay);
            initializePanel(panelOfGame2, frameNewGame2);
            helpGame2(user , fromWay);
        }
        else if (show == 3){
            frameNewGame3 = new JFrame("Game");
            initializeFrames(frameNewGame3);
            initGame(user, user.getGame3());
            panelOfGame3 = new PanelOfGame(user.getGame3() , show , user , fromWay);
            initializePanel(panelOfGame3, frameNewGame3);
            helpGame3(user , fromWay);
        }
        helpWindow(user , show , fromWay);
    }
    public static void continueGame(User user , int show){
        frameContinueGame.setVisible(false);
        String fromWay = "Continue";
        nullAllFrames();
        if (show == 1) {
            frameContinueGame1 = new JFrame("Game");
            initializeFrames(frameContinueGame1);
            panelOfGame1 = new PanelOfGame(user.getGame1() , show , user ,fromWay);
            initializePanel(panelOfGame1, frameContinueGame1);
            helpGame1(user , fromWay);
        }
        else if (show == 2){
            frameContinueGame2 = new JFrame("Game");
            initializeFrames(frameContinueGame2);
            panelOfGame2 = new PanelOfGame(user.getGame2() , show , user , fromWay);
            initializePanel(panelOfGame2, frameContinueGame2);
            helpGame2(user , fromWay);
        }
        else if (show == 3){
            frameContinueGame3 = new JFrame("Game");
            initializeFrames(frameContinueGame3);
            panelOfGame3 = new PanelOfGame(user.getGame3() , show , user , fromWay);
            initializePanel(panelOfGame3, frameContinueGame3);
            helpGame3(user , fromWay);
        }
        helpWindow(user , show , fromWay);
    }
    //----------------------------------------------------initialization----------------------------------------------//
    public static void initializeFrames(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setIconImage(new ImageIcon("Icon.png").getImage());
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(1800, 1000);
    }

    public static void initializePanel(JPanel panel , JFrame frame){
        panel.setBounds(0 , 0 , 1800 , 1000);
        panel.setVisible(true);
        frame.add(panel);
    }
    public static void initializeRadioButtons(JRadioButton radioButton , JFrame frame
            , int x , int y , int width , int height){
        frame.add(radioButton);
        radioButton.setBounds(x , y , width , height);

    }

    public static void initializeButtonGroup(ButtonGroup buttonGroup , JRadioButton ... radioButtons){
        for (JRadioButton radioButton : radioButtons) {
            buttonGroup.add(radioButton);
        }
    }
    public static void initializeButtons(JButton button, JFrame frame
            , int x, int y, int width, int height
            , ActionListener actionListener) {
        frame.add(button);
        button.setBounds(x, y, width, height);
        button.addActionListener(actionListener);
    }

    public static void initializeTextFields(JTextField textField, JFrame frame
            , int x, int y, int width, int height) {
        frame.add(textField);
        textField.setBounds(x, y, width, height);
    }

    public static void initializeLabel(JLabel label , JFrame frame , int x , int y , int width , int height){
        frame.add(label);
        label.setBounds(x , y , width , height);
    }

    public static void initializeUser(){
        User user = new User(signUpUserName.getText(), signUpPassWord.getText());
        mainPanel(user);
    }
//----------------------------------------------------other methods---------------------------------------------------//
    public static void checkForExistUser(){
        if (Files.users.containsKey(logInUserName.getText())) {
            User user = Files.users.get(logInUserName.getText());
            if (user.getPassWord().equals(logInPassWord.getText())) {
                mainPanel(user);
            } else {
                JOptionPane.showMessageDialog(frameLogIn, "Your username is found but password is wrong!"
                        , "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frameLogIn, "Your username not found!"
                    , "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void nullAllFrames(){
        frameNewGame1 = null;
        frameNewGame2 = null;
        frameNewGame3 = null;
        frameContinueGame1 = null;
        frameContinueGame2 = null;
        frameContinueGame3 = null;
    }
    public static void initNewGame1(User user){
        newButton1.setText("Game1");
        user.setNewButton1(true);
        user.setGame1(new Game());
        if (difficultyFrame) {
            frameNewGame.setVisible(false);
            frameDifficulty.setVisible(true);
        }
        else {
            selectDifficulty(user , 1);
        }
    }
    public static void initNewGame2(User user) {
        newButton2.setText("Game2");
        user.setNewButton2(true);
        System.out.println("game 2 new shod");
        user.setGame2(new Game());
        if (difficultyFrame) {
            frameNewGame.setVisible(false);
            frameDifficulty.setVisible(true);
        }
        else {
            selectDifficulty(user , 2);
        }
    }
    public static void initNewGame3(User user){
        newButton3.setText("Game3");
        user.setNewButton3(true);
        user.setGame3(new Game());
        if (difficultyFrame) {
            frameNewGame.setVisible(false);
            frameDifficulty.setVisible(true);
        }
        else {
            selectDifficulty(user , 3);
        }
    }
    public static void initContinueGame1(User user){
        if (continueButton1.getText().equals("Game1")){
            user.getGame1().setContinueGame(true);
            continueGame(user , 1);
        }
        else {
            JOptionPane.showMessageDialog(frameContinueGame , "this button is empty"
                    , "Error" , JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void initContinueGame2(User user){
        if (continueButton2.getText().equals("Game2")){
            user.getGame2().setContinueGame(true);
            continueGame(user , 2);
        }
        else {
            JOptionPane.showMessageDialog(frameContinueGame , "this button is empty"
                    , "Error" , JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void initContinueGame3(User user) {
        if (continueButton3.getText().equals("Game3")){
            user.getGame3().setContinueGame(true);
            continueGame(user , 3);
        }
        else {
            JOptionPane.showMessageDialog(frameContinueGame , "this button is empty"
                    , "Error" , JOptionPane.WARNING_MESSAGE);
        }
    }
    public static JScrollPane initHighestResults(){
        String[] column = {"Name of user" , "Highest Score"};
        String[][] row = new String[Files.arrayUsers.size()][2];
        for (int i = 0; i < Files.arrayUsers.size(); i++) {
            row[i][0] = Files.arrayUsers.get(i).getUserName();
            int highestScore = getHighestScore(Files.arrayUsers.get(i));
            row[i][1] = String.valueOf(highestScore);
        }
        tableOfHighestResults = new JTable(row , column);
        tableOfHighestResults.setBounds(600 , 200 , 800 , 600);
        tableOfHighestResults.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(tableOfHighestResults);
        scrollPane.setVisible(true);
        scrollPane.setBounds(600 , 200 , 800 , 600);
        return scrollPane;
    }
    public static void buyBoo(User user){
        if (user.getCoin() >= 20){
            user.getCharacters().add("Boo");
            JOptionPane.showMessageDialog(frameStore , "You buy Boo" , "Buy" , JOptionPane.WARNING_MESSAGE);
            user.setCoin(user.getCoin() - 20);
        }
        else {
            JOptionPane.showMessageDialog(frameStore , "You do not have required coins"
                    , "Error" , JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void buyWario(User user){
        if (user.getCoin() >= 30){
            user.getCharacters().add("Wario");
            JOptionPane.showMessageDialog(frameStore , "You buy Wario" , "Buy" , JOptionPane.WARNING_MESSAGE);
            user.setCoin(user.getCoin() - 30);
        }
        else {
            JOptionPane.showMessageDialog(frameStore , "You do not have required coins"
                    , "Error" , JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void buyToad(User user){
        if (user.getCoin() >= 20){
            user.getCharacters().add("Toad");
            JOptionPane.showMessageDialog(frameStore , "You buy Toad" , "Buy" , JOptionPane.WARNING_MESSAGE);
            user.setCoin(user.getCoin() - 20);
        }
        else {
            JOptionPane.showMessageDialog(frameStore , "You do not have required coins"
                    , "Error" , JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void buyYoshi(User user){
        if (user.getCoin() >= 10){
            user.getCharacters().add("Yoshi");
            JOptionPane.showMessageDialog(frameStore , "You buy Yoshi" , "Buy" , JOptionPane.WARNING_MESSAGE);
            user.setCoin(user.getCoin() - 10);
        }
        else {
            JOptionPane.showMessageDialog(frameStore , "You do not have required coins"
                    , "Error" , JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void initStore(User user){
        initializeLabel(labelOfBoo , frameStore , 150 , 300 , 230 , 230);
        initializeLabel(labelOfWario , frameStore , 500 , 300 , 400 , 250);
        initializeLabel(labelOfToad , frameStore , 1000 , 300 , 200 , 300);
        initializeLabel(labelOfYoshi , frameStore , 1300 , 300 , 240 , 230);
        initializeLabel(coinOfBoo , frameStore , 150 , 200 , 350 , 50);
        initializeLabel(coinOfWario , frameStore , 550 , 200 , 350 , 50);
        initializeLabel(coinOfToad , frameStore , 975 , 200 , 350 , 50);
        initializeLabel(coinOfYoshi , frameStore , 1300 , 200 , 350 , 50);
        initializeButtons(buyBoo, frameStore, 160, 700, 200, 100, e -> buyBoo(user));
        initializeButtons(buyWario, frameStore, 600, 700, 200, 100, e -> buyWario(user));
        initializeButtons(buyToad, frameStore, 1000, 700, 200, 100, e -> buyToad(user));
        initializeButtons(buyYoshi, frameStore, 1310, 700, 200, 100, e -> buyYoshi(user));
    }
    public static void informationOfUser(User user){
        initializeLabel(selectedCharacter , frameProfile , 50 , 50 , 300 , 50);
        selectedCharacter.setText("Your current character is " + user.getSelectedCharacter());
        initializeLabel(pictureOfSelectedCharacter , frameProfile , 50 , 100 , 400 , 400);
        pictureOfSelectedCharacter.setIcon(Character.pictureOfCharacters().get(user.getSelectedCharacter()));
        initializeLabel(nameOfUser , frameProfile , 50 , 500 , 200 , 50);
        nameOfUser.setText("Your name is " + user.getUserName());
        initializeLabel(highestScore , frameProfile , 50 , 700 , 200 , 50);
        highestScore.setText("Your highest score is : " + getHighestScore(user));
    }
    public static int getHighestScore(User user){
        int highestScore = 0;
        for (int i = 0; i < user.getScores().size(); i++) {
            if (user.getScores().get(i) > highestScore){
                highestScore = user.getScores().get(i);
            }
        }
        return highestScore;
    }
    public static void chooseCharacter(User user , JFrame frame) {
        if (user.getCharacters().contains("Boo")) {
            initializeLabel(pictureOfBoo, frame, 600, 50, 230, 230);
            initializeButtons(selectBoo, frame, 620, 400, 200, 100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frameProfile, "Boo is selected");
                    user.setSelectedCharacter("Boo");
                }
            });
        }
        if (user.getCharacters().contains("Wario")) {
            initializeLabel(pictureOfWario, frame, 900, 50, 400, 250);
            initializeButtons(selectWario, frame, 1000, 400, 200, 100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frameProfile, "Wario is selected");
                    user.setSelectedCharacter("Wario");
                }
            });
        }
        if (user.getCharacters().contains("Toad")) {
            initializeLabel(pictureOfToad, frame, 1380, 50, 200, 300);
            initializeButtons(selectToad, frame, 1380, 400, 200, 100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frameProfile, "Toad is selected");
                    user.setSelectedCharacter("Toad");
                }
            });
        }
        if (user.getCharacters().contains("Yoshi")) {
            initializeLabel(pictureOfYoshi, frame, 800, 500, 240, 230);
            initializeButtons(selectYoshi, frame, 820, 800, 200, 100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frameProfile, "Yoshi is selected");
                    user.setSelectedCharacter("Yoshi");
                }
            });
        }
        if (user.getCharacters().contains("Mario")) {
            initializeLabel(pictureOfMario, frame, 1300, 500, 200, 200);
            initializeButtons(selectMario, frame, 1300, 800, 200, 100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frameProfile, "Mario is selected");
                    user.setSelectedCharacter("Mario");
                }
            });
        }
    }
    public static void initSelectDifficulty(){
        initializeLabel(selectDifficulty , frameDifficulty , 50 , 50 , 100 , 50);
        initializeRadioButtons(hard , frameDifficulty , 50 , 150 , 100 , 50);
        initializeRadioButtons(medium , frameDifficulty , 50 , 250 , 100 , 50);
        initializeRadioButtons(easy , frameDifficulty , 50 , 350 , 100 , 50);
        initializeButtonGroup(difficulty , hard , medium , easy);
    }
    public static void initGame(User user , Game game){
        game.setHelpSelectedCharacter(user.getSelectedCharacter());
        switch (user.getSelectedCharacter()) {
            case "Mario":
                game.setSelectedCharacter(new Mario());
                break;
            case "Boo":
                game.setSelectedCharacter(new Boo());
                break;
            case "Wario":
                game.setSelectedCharacter(new Wario());
                break;
            case "Toad":
                game.setSelectedCharacter(new Toad());
                break;
            case "Yoshi":
                game.setSelectedCharacter(new Yoshi());
                break;
        }
    }
    public static void helpGame1(User user , String fromWay){
           actionOfGame1 = e -> {
               user.getGame1().move(user, 1, fromWay);
               user.getGame1().paint(panelOfGame1);
           };
        timer1.addActionListener(actionOfGame1);
        timer1.start();
    }
    public static void helpGame2(User user , String fromWay){
        actionOfGame2 = e -> {
            user.getGame2().move(user, 2, fromWay);
            user.getGame2().paint(panelOfGame2);
        };
        timer2.addActionListener(actionOfGame2);
        timer2.start();
    }
    public static void helpGame3(User user , String fromWay){
        actionOfGame3 = e -> {
            user.getGame3().move(user, 3,fromWay);
            user.getGame3().paint(panelOfGame3);
        };
        timer3.addActionListener(actionOfGame3);
        timer3.start();
    }
    public static void helpWindow(User user , int show , String fromWay){
        if (show == 1 && fromWay.equals("New")) {
            frameNewGame1.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    user.getGame1().setContinueGame(false);
                    timer1.stop();
                    int init = JOptionPane.showConfirmDialog(panelOfGame1, "Are you sure you want to exit the game?"
                            , "Stop", JOptionPane.YES_NO_OPTION);
                    if (init == JOptionPane.YES_OPTION) {
                        continueButton1.setText("Game1");
                        user.setContinueButton1(true);
                        panelOfGame1.setVisible(false);
                        //frameNewGame1.setVisible(false);
                        frameNewGame1.dispose();
                        frameMain.setVisible(true);
                        timer1.removeActionListener(actionOfGame1);
                        timer1.stop();
                    } else if (init == JOptionPane.NO_OPTION) {
                        user.getGame1().setContinueGame(true);
                        timer1.start();
                    }
                }
            });
        }
        if (show == 2 && fromWay.equals("New")) {
            frameNewGame2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    user.getGame2().setContinueGame(false);
                    timer2.stop();
                    int init = JOptionPane.showConfirmDialog(panelOfGame2, "Are you sure you want to exit the game?"
                            , "Stop", JOptionPane.YES_NO_OPTION);
                    if (init == JOptionPane.YES_OPTION) {
                        continueButton2.setText("Game2");
                        user.setContinueButton2(true);
                        panelOfGame2.setVisible(false);
                        frameNewGame2.setVisible(false);
                        frameMain.setVisible(true);
                        timer2.removeActionListener(actionOfGame2);
                        timer2.stop();
                    } else if (init == JOptionPane.NO_OPTION) {
                        user.getGame2().setContinueGame(true);
                        timer2.start();
                    }
                }
            });
        }
        if (show == 3 && fromWay.equals("New")) {
            frameNewGame3.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    user.getGame3().setContinueGame(false);
                    timer3.stop();
                    int init = JOptionPane.showConfirmDialog(panelOfGame3, "Are you sure you want to exit the game?"
                            , "Stop", JOptionPane.YES_NO_OPTION);
                    if (init == JOptionPane.YES_OPTION) {
                        continueButton3.setText("Game3");
                        user.setContinueButton3(true);
                        panelOfGame3.setVisible(false);
                        frameNewGame3.setVisible(false);
                        frameMain.setVisible(true);
                        timer3.removeActionListener(actionOfGame3);
                        timer3.stop();
                    } else if (init == JOptionPane.NO_OPTION) {
                        user.getGame3().setContinueGame(true);
                        timer3.start();
                    }
                }
            });
        }
        if (show == 1 && fromWay.equals("Continue")) {
            frameContinueGame1.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    user.getGame1().setContinueGame(false);
                    timer1.stop();
                    int init = JOptionPane.showConfirmDialog(panelOfGame1, "Are you sure you want to exit the game?"
                            , "Stop", JOptionPane.YES_NO_OPTION);
                    if (init == JOptionPane.YES_OPTION) {
                        panelOfGame1.setVisible(false);
                        frameContinueGame1.setVisible(false);
                        frameMain.setVisible(true);
                        timer1.removeActionListener(actionOfGame1);
                    } else if (init == JOptionPane.NO_OPTION) {
                        user.getGame1().setContinueGame(true);
                        timer1.start();
                    }
                }
            });
        }
        if (show == 2 && fromWay.equals("Continue")) {
            frameContinueGame2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    user.getGame2().setContinueGame(false);
                    timer2.stop();
                    int init = JOptionPane.showConfirmDialog(panelOfGame2, "Are you sure you want to exit the game?"
                            , "Stop", JOptionPane.YES_NO_OPTION);
                    if (init == JOptionPane.YES_OPTION) {
                        panelOfGame2.setVisible(false);
                        frameContinueGame2.setVisible(false);
                        frameMain.setVisible(true);
                        timer2.removeActionListener(actionOfGame2);
                    } else if (init == JOptionPane.NO_OPTION) {
                        user.getGame2().setContinueGame(true);
                        timer2.start();
                    }
                }
            });
        }
        if (show == 3 && fromWay.equals("Continue")) {
            frameContinueGame3.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    user.getGame3().setContinueGame(false);
                    timer3.stop();
                    int init = JOptionPane.showConfirmDialog(panelOfGame3, "Are you sure you want to exit the game?"
                            , "Stop", JOptionPane.YES_NO_OPTION);
                    if (init == JOptionPane.YES_OPTION) {
                        panelOfGame3.setVisible(false);
                        frameContinueGame3.setVisible(false);
                        frameMain.setVisible(true);
                        timer3.removeActionListener(actionOfGame3);
                    } else if (init == JOptionPane.NO_OPTION) {
                        user.getGame3().setContinueGame(true);
                        timer3.start();
                    }
                }
            });
        }
    }
    public static void initDeleteGame(User user){
        initializeLabel(deleteGame , frameNewGame , 800 , 150 , 200 , 100);
        initializeRadioButtons(deleteGame1 , frameNewGame , 800 , 250 , 200 , 100);
        initializeRadioButtons(deleteGame2 , frameNewGame , 800 , 400 , 200 , 100);
        initializeRadioButtons(deleteGame3 , frameNewGame , 800 , 550 , 200 , 100);
        initializeButtons(deleteSelectedGames, frameNewGame, 800, 700, 200, 100, e -> {
            if (deleteGame1.isSelected() && newButton1.getText().equals("Game1")){
                user.setNewButton1(false);
                newButton1.setText("Null");
                continueButton1.setText("Null");
                user.setContinueButton1(false);
                user.setGame1(null);
            }
            if (deleteGame2.isSelected() && newButton2.getText().equals("Game2")){
                user.setNewButton2(false);
                newButton2.setText("Null");
                continueButton2.setText("Null");
                user.setContinueButton2(false);
                user.setGame2(null);
            }
            if (deleteGame3.isSelected() && newButton3.getText().equals("Game3")){
                user.setNewButton3(false);
                newButton3.setText("Null");
                continueButton3.setText("Null");
                user.setContinueButton3(false);
                user.setGame3(null);
            }
        });
    }
}