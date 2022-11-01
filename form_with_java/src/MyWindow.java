import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    private JLabel heading;
    Font font = new Font("",Font.ITALIC,25);

    private  JPanel mainPanel;
    private  JLabel nameLable,passwordLable;
    private JTextField nameTextField;
    private JPasswordField passwordField;
    private  JButton button1,button2;

    public MyWindow(){
        super.setTitle("My Form with Java");
        super.setSize(500,500);
        super.setLocation(200,200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createGUI();

        super.setVisible(true);
        System.out.println("this is my window const.");
    }

    public void createGUI(){
        this.setLayout(new BorderLayout());

        heading = new JLabel("My Form");
        heading.setFont(font);
        heading.setHorizontalAlignment(JLabel.CENTER);

        this.add(heading,BorderLayout.NORTH);

//        form creation

          mainPanel = new JPanel();
          mainPanel.setLayout(new GridLayout(3,2));

          nameLable = new JLabel("Enter name :");
          nameLable.setFont(font);

          passwordLable = new JLabel("Password :");
          passwordLable.setFont(font);

          nameTextField = new JTextField();
          nameTextField.setFont(font);

          passwordField = new JPasswordField();
          passwordField.setFont(font);


          button1 = new JButton("submit");
          button1.setFont(font);

          button2 = new JButton("cancel");
          button2.setFont(font);

          mainPanel.add(nameLable);
          mainPanel.add(nameTextField);
          mainPanel.add(passwordLable);
          mainPanel.add(passwordField);
          mainPanel.add(button1);
          mainPanel.add(button2);


          this.add(mainPanel,BorderLayout.CENTER);
    }
}
