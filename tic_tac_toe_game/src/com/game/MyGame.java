package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyGame extends JFrame implements ActionListener {

    JLabel heading,clockLabel;
    Font font = new Font("",Font.BOLD,20);
    JPanel mainPanel;
    JButton []btns =new JButton[9];

//    game instance variable
    int gameChances[] = {2,2,2,2,2,2,2,2,2};
    int activePlayer = 0 ;

//      winning positions array
    int wps[][] = {
        {0,1,2},
        {3,4,5},
        {6,7,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {0,4,8},
        {2,4,6}
};

    int winner = 2;
    boolean gameOver = false;

    MyGame(){
        System.out.println("creating instamce of game..");
        setTitle("Tic Tac Toe");
        setSize(500,500);
        ImageIcon icon = new ImageIcon("src/img/tic_tac_toe.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        setVisible(true);
    }

    private void createGUI(){
        this.getContentPane().setBackground(Color.decode("#ADD8E6"));
        this.setLayout(new BorderLayout());

        heading = new JLabel("");
        heading.setFont(font);
        heading.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(heading,BorderLayout.NORTH);


//panel section
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,3));

        for (int i = 1; i <= 9 ; i++) {
            JButton btn = new JButton();
            btn.setBackground(Color.BLACK);
            btn.setFont(font);
            mainPanel.add(btn);
            btns[i-1] = btn;
            btn.addActionListener(this);
            btn.setName(String.valueOf(i-1));
        }

        this.add(mainPanel,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      JButton currentButton = (JButton) e.getSource();
      String nameStr = currentButton.getName();

      int name = Integer.parseInt(nameStr.trim());

      if (gameOver){
          JOptionPane.showMessageDialog(this,"Game Over!");
          return;
      }

      if(gameChances[name] == 2){
          if(activePlayer == 1){
              currentButton.setIcon(new ImageIcon("src/img/cross.png"));

              gameChances[name] = activePlayer;
              activePlayer =0;
          }else{
              currentButton.setIcon(new ImageIcon("src/img/zero.png"));

              gameChances[name] = activePlayer;
              activePlayer =1;
          }

//          find the winner
          for (int []temp:wps) {
              if((gameChances[temp[0]] == gameChances[temp[1]]) && (gameChances[temp[1]] == gameChances[temp[2]]) && gameChances[temp[2]] != 2){
                  winner = gameChances[temp[0]];
                  gameOver = true;
                  JOptionPane.showMessageDialog(null,"Player " + winner + " has won the game.");
                  int i = JOptionPane.showConfirmDialog(this,"do you want to continue playing?");
                 if (i==0){
                     this.setVisible(false);
                     new MyGame();
                 }
                 else if(i==1){
                     System.exit(0);
                 }
                 else{

                 }
                  break;
              }
          }

//          draw logic
          int c = 0;
          for (int x:gameChances) {
              if(x==2){
                  c++;
                  break;
              }
          }

          if(c==0 && !gameOver){
              JOptionPane.showMessageDialog(null,"It's Draw!");
              int i = JOptionPane.showConfirmDialog(this,"Continue Play?");
              if (i==0){
                  this.setVisible(false);
                  new MyGame();
              }
              else if(i==1){
                  System.exit(0);
              }
              else{

              }

              gameOver = true;
          }

      }else{
          JOptionPane.showMessageDialog(this,"Position already occupied!!");
      }
    }
}
