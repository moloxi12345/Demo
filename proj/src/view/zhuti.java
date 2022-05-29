package view;

import controller.ClickController;
import model.ChessColor;
import model.ChessComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class zhuti  {
    JFrame jf = new JFrame("棋盘风格");
    final int WIDTH = 300;
    final int HEIGHT = 300;



    public void init() throws Exception {
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;//获取当前屏幕的宽度
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;//获取当前屏幕的高度

        BackGroundPanel bg=new BackGroundPanel(ImageIO.read(new File("C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\images\\980.jpg")));
        jf.setBounds((w - WIDTH) / 2, (h - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setVisible(true);
        Box vbox = Box.createVerticalBox();

        jf.setVisible(true);
        JLabel hu = new JLabel("棋盘色");
        JButton hb = new JButton("黑白");
        JButton hub = new JButton("黄白");
        hb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        hub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


        vbox.add(Box.createVerticalStrut(50));
        vbox.add(hu);
        vbox.add(Box.createVerticalStrut(30));
        vbox.add(hb);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(hub);

        bg.add(vbox);
        jf.add(bg);
        jf.setResizable(false);
    }

}
