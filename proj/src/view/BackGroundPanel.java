package view;

import javax.swing.*;
import java.awt.*;

public class BackGroundPanel extends JPanel {

    //声明图片
    private Image back;
    public BackGroundPanel(Image back){
        this.back=back;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //绘制背景
        g.drawImage(back,0,0,this.getWidth(),this.getHeight(),null);

    }
}
