package Text;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public Login(){
        this.setBounds(350,50,1300,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        JTextField jtf=new JTextField();
        jtf.setBounds(550,350,250,30);
        this.add(jtf);
        JPasswordField jpf = new JPasswordField();
        jpf.setBounds(550,390,250,30);
        this.add(jpf);
        JLabel j1=new JLabel("账号：");
        j1.setBounds(500,350,50,30);
        this.add(j1);
        JLabel j2=new JLabel("密码：");
        j2.setBounds(500,390,50,30);
        this.add(j2);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
