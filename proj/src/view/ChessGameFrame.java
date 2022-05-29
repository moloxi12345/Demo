package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;
    private static Image chess;

//
//    //重写paint()，背景图片
//    public void paint(Graphics g) {
//        ImageIcon i = new ImageIcon(photo);
//        i.setImage(photo.getScaledInstance(this.getWidth(), this.getHeight(),
//                Image.SCALE_AREA_AVERAGING));            //此处是重点，通过this获取窗体大小来设置图片
//        g.drawImage(i.getImage(), 0, 0, null);
//    }


    public ChessGameFrame(int width, int height) {
        setTitle("2022 CS102A Project Demo"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);

        addLabel();
        addHelloButton();
        addLoadButton();
        addzhuceButton();
        addzhutiButton();
        //addlable();
        addbeijing();

    }


    //在游戏面板中添加背景图片
    private void addbeijing() {
        JLabel bei = new JLabel();
        bei.setSize(1000, 726);
        bei.setLocation(0, 0);
        bei.setIcon(new ImageIcon("C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\images\\po.png"));
        add(bei);
    }


    /**
     * 在游戏面板中添加棋盘
     */
//    private void addlable() {
//        JLabel jo = new JLabel();
//        jo.setSize(729, 729);
//        jo.setLocation(0, 0);
//        jo.setIcon(new ImageIcon("C:\\Users\\86198\\IdeaProjects\\Demo\\images\\chan.png"));
//        add(jo);
//    }

    /**
     * 在游戏面板中添加标签
     */
    private void addLabel() {
        JLabel statusLabel = new JLabel("国际象棋");
        statusLabel.setLocation(HEIGTH / 2 - 50, HEIGTH / 11);
        statusLabel.setSize(2000, 100);
        statusLabel.setFont(new Font("楷体", Font.BOLD, 90));
        statusLabel.setForeground(Color.WHITE);
        add(statusLabel);
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("开始新游戏");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    youxi1 youxiF = new youxi1(1000, 760);
                    youxiF.setVisible(true);
                });
                dispose();
            }
        });
        button.setLocation(HEIGTH / 2, HEIGTH / 10 + 130);
        button.setSize(200, 60);
        button.setFont(new Font("仿宋", Font.BOLD, 20));
        add(button);
    }

    private void addLoadButton() {
        JButton button = new JButton("读档");
        button.setLocation(HEIGTH / 2, HEIGTH / 10 + 250);
        button.setSize(200, 60);
        button.setFont(new Font("仿宋", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this, "Input Path here");
        });
    }

    private void addzhuceButton() {
        JButton button = new JButton("用户信息");
        button.setLocation(HEIGTH / 2, HEIGTH / 10 + 370);
        button.setSize(200, 60);
        button.setFont(new Font("仿宋", Font.BOLD, 20));
        add(button);
       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   new yonghujiemian().init();
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
       });
    }

    private void addzhutiButton() {
        JButton button = new JButton("主题风格");
        button.setLocation(HEIGTH / 2, HEIGTH / 10 + 490);
        button.setSize(200, 60);
        button.setFont(new Font("仿宋", Font.BOLD, 20));
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new zhuti().init();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
