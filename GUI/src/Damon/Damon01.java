package Damon;

import javax.swing.*;
import java.awt.*;

public class Damon01 extends JFrame {
    MyPanel mp;
    Container ct;
    public Damon01(){
        ct=this.getContentPane();
        this.setLayout(null);
        mp=new MyPanel(new ImageIcon("图片\\background.jpg").getImage());
        int screenwidth=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int screenheight=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setBounds(0,0,screenwidth,screenheight);
        this.add(mp);
        /*JButton jb=new JButton("测试按钮");
        jb.setBounds(60,60,150,40);
        this.add(jb);*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Damon01();
    }

}
class MyPanel extends JPanel{
    Image im;
    public  MyPanel(Image im){
        this.im=im;
        this.setOpaque(true);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(im,0,0,400,300,this);
    }
}