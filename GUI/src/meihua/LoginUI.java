package meihua;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginUI extends JFrame {
    int uiwidth = 1300;
    int uiheight = 800;

    //Image image1 = new ImageIcon("pic/LoginPicture.jpg").getImage();

    public LoginUI() throws Exception {
        this.setTitle("五子棋登录界面");
        this.setBounds(350, 50, uiwidth, uiheight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        JTextField jtf = new JTextField();
        jtf.setBounds(550, 350, 250, 30);
        this.add(jtf);
        JPasswordField jpf = new JPasswordField();
        jpf.setBounds(550, 390, 250, 30);
        this.add(jpf);
        JLabel j1 = new JLabel("账号：");
        //j1.setFont(new Font("华文彩云",Font.BOLD,10));
        j1.setBounds(500, 350, 50, 30);
        this.add(j1);
        JLabel j2 = new JLabel("密码：");
        j2.setBounds(500, 390, 50, 30);
        this.add(j2);
        JButton jButton = new JButton("进入游戏"/*, new ImageIcon("pic/进入游戏.png")*/);
        jButton.setBounds(650, 450, 100, 30);
        jButton.addActionListener(new MyListener(jtf,jpf,this));
        jButton.setContentAreaFilled(false);
        this.add(jButton);
        JButton jButton1=new JButton("注册账号");
        jButton1.setBounds(500,450,100,30);
        jButton1.addActionListener(new MyListener(jtf,jpf,this));
        jButton1.setContentAreaFilled(false);
        this.add(jButton1);
        JButton jButton2 = new JButton("找回密码");
        jButton2.setBounds(800,450,100,30);
        jButton2.addActionListener(new MyListener(jtf,jpf,this));
        jButton2.setContentAreaFilled(false);
        this.add(jButton2);
        this.setVisible(true);
    }


   /* public void paint(Graphics g) {
        g.drawImage(image1, 0, 0, this.getWidth(), this.getHeight(), this);
    }*/
    public boolean findUser(String username,String passwold) throws Exception {
        String sql="select * FROM USER "+"where username=? "+"and passworld=?";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.105:3306/test", "root", "root");
        PreparedStatement prestmt=connection.prepareStatement(sql);
        prestmt.setString(1,username);
        prestmt.setString(2,passwold);
        ResultSet rs=prestmt.executeQuery();
        try {
            if(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                rs.close();
            }
            if(prestmt!=null){
                prestmt.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        new LoginUI();
    }
}
class MyListener implements ActionListener {
    String username;
    String password;
    JTextField jtf;
    JPasswordField jpf;
    LoginUI loginUI;
    public MyListener(JTextField jtf,JPasswordField jpf,LoginUI loginUI){
        this.jtf=jtf;
        this.jpf=jpf;
        this.loginUI=loginUI;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        username = jtf.getText();
        password = String.valueOf(jpf.getPassword());
        boolean b = false;
        try {
            b = loginUI.findUser(username, password);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (b) {
            new Wuziqi();
            loginUI.dispose();
            JOptionPane.showMessageDialog(loginUI, "请先选择游戏模式（默认人人对战）");
        }
        else if (e.getActionCommand().equals("找回密码")) {
            loginUI.dispose();
            new zhaohui();
        }
            else if (e.getActionCommand().equals("注册账号")) {
            loginUI.dispose();
            new CreateUI();
        }
        else JOptionPane.showMessageDialog(loginUI,"账号或密码错误！");

    }
}
class CreateUI extends JFrame{
    int uiwidth = 1300;
    int uiheight = 800;

    //Image image1 = new ImageIcon("pic/LoginPicture.jpg").getImage();

    public CreateUI () {
        this.setTitle("五子棋注册界面");
        this.setBounds(350, 50, uiwidth, uiheight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        JTextField jtf = new JTextField();
        jtf.setBounds(550, 350, 250, 30);
        this.add(jtf);
        JPasswordField jpf1 = new JPasswordField();
        jpf1.setBounds(550, 390, 250, 30);
        this.add(jpf1);
        JPasswordField jpf2 = new JPasswordField();
        jpf2.setBounds(550,430,250,30);
        this.add(jpf2);
        JLabel j1 = new JLabel("新账号：");
        //j1.setFont(new Font("华文彩云",Font.BOLD,10));
        j1.setBounds(500, 350, 60, 30);
        this.add(j1);
        JLabel j2 = new JLabel("新密码：");
        j2.setBounds(500, 390, 60, 30);
        this.add(j2);
        JLabel j3=new JLabel("确认新密码：");
        j3.setBounds(470, 430, 80, 30);
        this.add(j3);
        JButton jButton=new JButton("提交");
        jButton.setBounds(670, 470, 120, 30);
        jButton.addActionListener(new tijiaoListener(jtf,jpf1,this,jpf2));
        jButton.setContentAreaFilled(false);
        this.add(jButton);
        this.setVisible(true);
    }
    public boolean findUser(String username) throws Exception {
        String sql="select * FROM USER "+"where username=?; ";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.105:3306/test", "root", "root");
        PreparedStatement prestmt=connection.prepareStatement(sql);
        prestmt.setString(1,username);
        ResultSet rs=prestmt.executeQuery();
        try {
            if(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                rs.close();
            }
            if(prestmt!=null){
                prestmt.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return false;
    }
}
class tijiaoListener implements ActionListener{

    String username;
    String password;
    JTextField jtf;
    JPasswordField jpf1;
    JPasswordField jpf2;
    CreateUI createUI;
    public tijiaoListener(JTextField jtf,JPasswordField jpf,CreateUI createUI,JPasswordField jpf2){
        this.jtf=jtf;
        this.jpf1 =jpf;
        this.createUI=createUI;
        this.jpf2=jpf2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username=jtf.getText();
        String password= String.valueOf(jpf1.getPassword());
        String password1 = String.valueOf(jpf2.getPassword());
        if (e.getActionCommand().equals("提交")) {
            System.out.println(username);
            System.out.println(password);
            System.out.println(password1);
            //这里null不行，因为null!=""
            if (username.equals("")|| password .equals("")) {
                JOptionPane.showMessageDialog(createUI,"您输入为空！");
            }
            else {
                boolean b=false;
                try {
                    b = createUI.findUser(username);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if(b){
                    JOptionPane.showMessageDialog(createUI,"账户名已存在！");
                }
                else {
                    if (!(password.equals(password1))) {
                        JOptionPane.showMessageDialog(createUI, "两次密码不一致");
                    } else {
                        int result = JOptionPane.showConfirmDialog(createUI, "确认提交？");
                        if (result == 0) {
                            try {
                                createuser(username, password);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            createUI.dispose();
                            try {
                                new LoginUI();
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }

        }
    }
    public void createuser(String username,String passwold) throws Exception {
        String sql="INSERT INTO test.user values (?,?); ";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.105:3306/test", "root", "root");
        PreparedStatement prestmt=connection.prepareStatement(sql);
        prestmt.setString(1,username);
        prestmt.setString(2,passwold);
        prestmt.executeUpdate();
        prestmt.close();
        connection.close();
    }
}
class zhaohui extends JFrame{
    int uiwidth = 1300;
    int uiheight = 800;

    //Image image1 = new ImageIcon("pic/LoginPicture.jpg").getImage();

    public zhaohui () {
        this.setTitle("找回密码");
        this.setBounds(350, 50, uiwidth, uiheight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        JTextField jtf = new JTextField();
        jtf.setBounds(550, 350, 250, 30);
        this.add(jtf);
        JLabel j1 = new JLabel("要找回的账号：");
        j1.setBounds(450, 350, 100, 30);
        this.add(j1);
        JButton jButton=new JButton("确认");
        jButton.setBounds(670, 470, 120, 30);
        jButton.addActionListener(new querenListener(jtf,this));
        jButton.setContentAreaFilled(false);
        this.add(jButton);
        this.setVisible(true);
    }
}
class querenListener implements ActionListener{
    JTextField jtf;
    zhaohui zhaohui;
    public querenListener(JTextField jtf,zhaohui zhaohui){
        this.jtf=jtf;
        this.zhaohui=zhaohui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username=jtf.getText();
        String password=null;
        try {
            password = findPassword(username);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (password != null) {
            JOptionPane.showMessageDialog(zhaohui,"您的密码为："+password);
            zhaohui.dispose();
            try {
                new LoginUI();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            int result = JOptionPane.showConfirmDialog(zhaohui, "您的账号不存在,是否创建一个账号？");
            if (result == 0) {
                zhaohui.dispose();
                new CreateUI();
            }
            else{
                try {
                    new LoginUI();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
    public String findPassword(String username) throws Exception {
        String sql="select passworld FROM USER "+"where username=?; ";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.105:3306/test", "root", "root");
        PreparedStatement prestmt=connection.prepareStatement(sql);
        prestmt.setString(1,username);
        ResultSet rs=prestmt.executeQuery();
        try {
            if(rs.next()){
                String password = rs.getString("passworld");
                return password;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                rs.close();
            }
            if(prestmt!=null){
                prestmt.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return null;
    }
}



