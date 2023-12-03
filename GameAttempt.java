import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
//Gridlayout below lets you change the layout, i.e. the layout of the choice buttons
import java.awt.GridLayout;
//ActionEvent gives function to the game, i.e. makes the start button work
import java.awt.event.ActionEvent;
//ActionListener listens to the function being given.
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//you set your imports first, then adjust the parameters below to suit your needs
public class GameAttempt {
  // JFrame creates a frame, like JOptionFrame
  JFrame window;
  // the container is where the JPanel below will go. container is old by now, you
  // can use window.add(titleNamePanel); instead.
  Container con;
  // JPanel below creates a panel on your JFrame
  JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
  // JLabel below is used for putting text onto the JPanel and screen
  JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
  // Font below lets you change the font of your writing, i.e. its style, size...
  Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
  Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
  // JButton below creates a button. this will go into the JPanel, which is in the
  // container now
  JButton startButton, choice1, choice2, choice3, choice4;
  // the below import lets you create a text area on a panel.
  JTextArea mainTextArea;
  // the below int sets the health of the player! this code is in the
  // playerSetup() class further below.
  int playerHP, orcHP, silverRing;
  // the below String sets the weapon you have. it is also in the playerSetup()
  // section. the position string declares your position, i.e. the town gate for
  // exmaple. it lets the programme recognise where you are.
  String weapon, position;

  TitleScreenHandler tsHandler = new TitleScreenHandler();
  ChoiceHandler choiceHandler = new ChoiceHandler();

  public static void main(String[] args) {
    new GameAttempt();
  }

  // parameters
  public GameAttempt() {
    window = new JFrame();
    window.setSize(800, 600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setBackground(Color.black);
    window.setLayout(null);
    // the commented out code below isn't working for me here, so i have put it into
    // the Game() section further below.
    // window.setVisible(true);

    con = window.getContentPane();

    titleNamePanel = new JPanel();
    titleNamePanel.setBounds(100, 100, 600, 150);
    titleNamePanel.setBackground(Color.blue);

    titleNameLabel = new JLabel("ADVENTURE");
    titleNameLabel.setForeground(Color.white);
    titleNameLabel.setFont(titleFont);

    startButtonPanel = new JPanel();
    startButtonPanel.setBounds(300, 400, 200, 100);
    startButtonPanel.setBackground(Color.blue);

    startButton = new JButton("START");
    startButton.setBackground(Color.black);
    startButton.setForeground(Color.white);
    startButton.setFont(normalFont);
    // the below code will call the pubic class TitleScreenHandler below, it will
    // give the start button some function.
    startButton.addActionListener(tsHandler);
    // the below line of code removes the weird line that appears inside the
    // buttons. if you remove this code, the line will reappear!
    startButton.setFocusPainted(false);

    titleNamePanel.add(titleNameLabel);
    // the below line of code places the START button onto the button panel. It will
    // then be placed onto the container, due to the code a few lines below this.
    startButtonPanel.add(startButton);
    // the below parameters add the JPanels to the container!
    con.add(titleNamePanel);
    con.add(startButtonPanel);

    window.setVisible(true);
  }

  public void createGameScreen() {

    // you have to disable the titleNamePanel and startButton Panel once you want to
    // move onto the next page of the game, otherwise it will be over what you want
    // on the next page. The below code does that. it will therefore allow the below
    // code to begin appearing onto the screen.
    titleNamePanel.setVisible(false);
    startButtonPanel.setVisible(false);

    mainTextPanel = new JPanel();
    mainTextPanel.setBounds(100, 100, 600, 250);
    mainTextPanel.setBackground(Color.blue);

    con.add(mainTextPanel);

    mainTextArea = new JTextArea("This is the main text area.");
    mainTextArea.setBounds(100, 100, 600, 250);
    mainTextArea.setBackground(Color.black);
    mainTextArea.setForeground(Color.white);
    mainTextArea.setFont(normalFont);
    // the below line of code wraps the words so they dont go off the panel.
    mainTextArea.setLineWrap(true);
    mainTextPanel.add(mainTextArea);

    choiceButtonPanel = new JPanel();
    choiceButtonPanel.setBounds(250, 350, 300, 150);
    choiceButtonPanel.setBackground(Color.red);
    // the below line of code changes the layout of the choice buttons
    choiceButtonPanel.setLayout(new GridLayout(4, 1));

    con.add(choiceButtonPanel);

    choice1 = new JButton("Choice 1");
    choice1.setBackground(Color.black);
    choice1.setForeground(Color.white);
    choice1.setFont(normalFont);
    choice1.setFocusPainted(false);
    choice1.addActionListener(choiceHandler);
    // the programme wouldn't recognise the difference between each choice without
    // the line of code directly below: PS i have put it in with the other choices.
    choice1.setActionCommand("c1");
    choiceButtonPanel.add(choice1);

    choice2 = new JButton("Choice 2");
    choice2.setBackground(Color.black);
    choice2.setForeground(Color.white);
    choice2.setFont(normalFont);
    choice2.setFocusPainted(false);
    choice2.addActionListener(choiceHandler);
    choice2.setActionCommand("c2");
    choiceButtonPanel.add(choice2);

    choice3 = new JButton("Choice 3");
    choice3.setBackground(Color.black);
    choice3.setForeground(Color.white);
    choice3.setFont(normalFont);
    choice3.setFocusPainted(false);
    choice3.addActionListener(choiceHandler);
    choice3.setActionCommand("c3");
    choiceButtonPanel.add(choice3);

    choice4 = new JButton("Choice 4");
    choice4.setBackground(Color.black);
    choice4.setForeground(Color.white);
    choice4.setFont(normalFont);
    choice4.setFocusPainted(false);
    choice4.addActionListener(choiceHandler);
    choice4.setActionCommand("c4");
    choiceButtonPanel.add(choice4);

    playerPanel = new JPanel();
    playerPanel.setBounds(100, 15, 600, 50);
    playerPanel.setBackground(Color.green);
    playerPanel.setLayout(new GridLayout(1, 4));
    con.add(playerPanel);

    hpLabel = new JLabel("HP:");
    hpLabel.setFont(normalFont);
    hpLabel.setForeground(Color.white);
    playerPanel.add(hpLabel);

    hpLabelNumber = new JLabel();
    hpLabelNumber.setFont(normalFont);
    hpLabelNumber.setForeground(Color.white);
    playerPanel.add(hpLabelNumber);

    weaponLabel = new JLabel("Weapon:");
    weaponLabel.setFont(normalFont);
    weaponLabel.setForeground(Color.white);
    playerPanel.add(weaponLabel);

    weaponLabelName = new JLabel();
    weaponLabelName.setFont(normalFont);
    weaponLabelName.setForeground(Color.white);
    playerPanel.add(weaponLabelName);

    // the below code here will call the playerSetup class below this!
    playerSetup();

  }

  // the below class adds variables i.e. amount od health and weapon types
  public void playerSetup() {
    playerHP = 15;
    orcHP = 20;
    weapon = "Knife";
    weaponLabelName.setText(weapon);

    hpLabelNumber.setText("" + playerHP);

    // the below line of code calls the townGate class just below.
    townGate();
  }

  public void townGate() {
    mainTextArea.setText(
        "You are at the gate of the town and you want to go\nin. \nA guard is standing in front of you. \n\nWhat do you do?");
    position = "townGate";
    choice1.setText("Talk to the guard");
    choice2.setText("Attack the guard");
    choice3.setText("Leave");
    choice4.setText("");
  }

  public void talkGuard() {
    position = "talkGuard";
    mainTextArea.setText(
        "Guard: Hello stranger.\n I have never seen you before. I'm sorry, but we \ncannot let a stranger enter our town.");
    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
  }

  // the below class is used to add function to the game, i.e. to make the start
  // button work at the beginning.
  public class TitleScreenHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {

      createGameScreen();
    }
  }

  public void attackGuard() {
    position = "attackGuard";
    mainTextArea
        .setText("Guard: Hey, don't be stupid! \n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
    // the player's HP needs to be reduced, so the below code does that:
    playerHP = playerHP - 3;
    hpLabelNumber.setText("" + playerHP);
    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
  }

  public void crossRoad() {
    position = "crossRoad";
    mainTextArea.setText("You are at a crossroad. \nIf you go south, you return to the town.");
    choice1.setText("Go north");
    choice2.setText("Go east");
    choice3.setText("Go south");
    choice4.setText("Go west");
  }

  public void north() {
    position = "north";
    mainTextArea.setText("There is a river. \nYou drink the water from the riverside. \n\nYou receive +2 HP)");
    playerHP = playerHP + 2;
    hpLabelNumber.setText("" + playerHP);
    choice1.setText("Go south");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");

  }

  public void east() {
    position = "east";
    mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
    weapon = "Long Sword";
    weaponLabelName.setText(weapon);
    choice1.setText("Go west");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
  }

  public void west() {
    position = "west";
    // you can write orcHP here, but you can also do it in playerSetup()
    // orcHP = 20;
    mainTextArea.setText("You encounter an orc!");
    choice1.setText("Fight");
    choice2.setText("Run");
    choice3.setText("");
    choice4.setText("");
  }

  public void fight() {
    position = "fight";
    mainTextArea.setText("Orc HP: " + orcHP + "\n\nWhat will you do?");
    choice1.setText("Attack!");
    choice2.setText("Run");
    choice3.setText("");
    choice4.setText("");
  }

  public void playerAttack() {
    position = "playerAttack";

    // we have to create a variable here because there will be a fight
    int playerDamage = 0;

    // the below code helps decide damage if you have knife or long sword
    if (weapon.equals("Knife")) {
      // with the below code, a random number will be chosen between 0,1 and 2. NOT 3.
      playerDamage = new java.util.Random().nextInt(3);
    } else if (weapon.equals("Long Sword")) {
      playerDamage = new java.util.Random().nextInt(8);
    }

    mainTextArea.setText("You attacked the orc and gave " + playerDamage + " damage!");

    orcHP = orcHP - playerDamage;

    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
  }

  // the below code is for the orc's attack
  public void orcAttack() {
    position = "orcAttack";
    int orcDamage = 0;

    orcDamage = new java.util.Random().nextInt(6);

    mainTextArea.setText("The orc attacked you and gave " + orcDamage + " damage!");

    playerHP = playerHP - orcDamage;
    hpLabelNumber.setText("" + playerHP);
    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");

  }

  // the below code sorts out whether you win or lose (i.e. if your HP hits 0)
  public void win() {
    position = "win";

    mainTextArea
        .setText("You defeated the monster! \nThe monster dropped a silver ring! \n\n(You obtained a Silver Ring)");

    silverRing = 1;
    choice1.setText("Go east");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
  }

  public void lose() {
    position = "lose";
    mainTextArea.setText("You are dead! \n\n<GAME OVER!>");
    choice1.setText("");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
    choice1.setVisible(false);
    choice2.setVisible(false);
    choice3.setVisible(false);
    choice4.setVisible(false);
  }

  public void ending() {
    position = "ending";
    mainTextArea.setText(
        "Guard: Oh, you killed the Orc!? \nThank you so much! You are a true hero! \nWelcome to our town! \n\n<THE END>");
    choice1.setText("");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
    choice1.setVisible(false);
    choice2.setVisible(false);
    choice3.setVisible(false);
    choice4.setVisible(false);
  }

  // the below code handles the button clicks in terms of choices
  public class ChoiceHandler implements ActionListener {

    public void actionPerformed(ActionEvent event) {
      // The below line of code adds an action line of command for the choices you can
      // make. it can recognise what button is clicked by the user.
      String yourChoice = event.getActionCommand();
      // you could use if statements here, but it would require a lot of lines of
      // code. instead, switch is recommended. i have given an example for what would
      // happen if an if statement was used:
      // if (yourChoice.equals("c1")) {
      // talkGuard();
      // }
      // if (yourChoice.equals("c2")) {
      // talkGuard();
      // }

      // if (yourChoice.equals("c1") && position == "townGuard") {
      // townGate();
      // } else if (yourChoice.equals("c1") && position == "townGate") {
      // talkGuard();
      // }
      switch (position) {
        case "townGate":
          switch (yourChoice) {
            case "c1":
              if (silverRing == 1) {
                ending();
              } else {
                talkGuard();
              }
              break;
            case "c2":
              attackGuard();
              break;
            case "c3":
              crossRoad();
              break;
            // I had made a mistake below this, it took a while to fix it, i didnt know what
            // was wrong, turns out i missed a } and "break;"" below it. make sure you
            // double check your code.
          }
          break;
        case "talkGuard":
          switch (yourChoice) {
            case "c1":
              townGate();
              break;
          }
          break;
        case "attackGuard":
          switch (yourChoice) {
            case "c1":
              if (playerHP < 1) {
                lose();
              } else {
                townGate();
              }
              break;
          }
          break;
        case "crossRoad":
          switch (yourChoice) {
            case "c1":
              north();
              break;
            case "c2":
              east();
              break;
            case "c3":
              townGate();
              break;
            case "c4":
              west();
              break;
          }
          break;
        case "north":
          switch (yourChoice) {
            case "c1":
              crossRoad();
              break;
          }
          break;
        case "east":
          switch (yourChoice) {
            case "c1":
              crossRoad();
              break;
          }
          break;
        case "west":
          switch (yourChoice) {
            case "c1":
              fight();
              break;
            case "c2":
              crossRoad();
              break;
          }
          break;
        case "fight":
          switch (yourChoice) {
            case "c1":
              playerAttack();
              break;
            case "c2":
              crossRoad();
              break;
          }
          break;
        case "playerAttack":
          switch (yourChoice) {
            case "c1":
              if (orcHP < 1) {
                win();
              } else {
                orcAttack();
              }
              break;
          }
          break;
        case "orcAttack":
          switch (yourChoice) {
            case "c1":
              if (playerHP < 1) {
                lose();
              } else {
                fight();
              }

              break;
          }
          break;
        case "win":
          switch (yourChoice) {
            case "c1":
              crossRoad();
          }
          break;
      }
    }
  }
}