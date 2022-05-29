package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class yonghujiemian {

        JFrame jf = new JFrame("你的信息");
        final int WIDTH = 500;
        final int HEIGHT = 400;

        //组装
        public void init() throws Exception {
            BackGroundPanel jp = new BackGroundPanel(ImageIO.read(new File("C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\images\\980.jpg")));
            int w = Toolkit.getDefaultToolkit().getScreenSize().width;//获取当前屏幕的宽度
            int h = Toolkit.getDefaultToolkit().getScreenSize().height;//获取当前屏幕的高度
            jf.setBounds((w - WIDTH) / 2, (h - HEIGHT) / 2, WIDTH, HEIGHT);
            jf.setResizable(false);
            BufferedReader r=new BufferedReader(new FileReader("C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\proj\\resource\\xinxi.txt"));
            String s=r.readLine();
            String[] arr1=s.split(" ");
            Box vbox = Box.createVerticalBox();
            jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //组装昵称
            Box ubox = Box.createHorizontalBox();
            JLabel name = new JLabel("昵称:");
            JLabel namek=new JLabel(arr1[0]);
            ubox.add(name);
            ubox.add(Box.createHorizontalStrut(20));
            ubox.add(namek);
            //组装年龄
            Box nbox = Box.createHorizontalBox();
            JLabel age = new JLabel("年龄:");
            JLabel agek=new JLabel(arr1[1]);
            nbox.add(age);
            nbox.add(Box.createHorizontalStrut(20));
            nbox.add(agek);
            //组装手机号
            Box pbox = Box.createHorizontalBox();
            JLabel phone = new JLabel("手机号");
            JLabel phonek = new JLabel(arr1[2]);
            pbox.add(phone);
            pbox.add(Box.createHorizontalStrut(20));
            pbox.add(phonek);
            //组装性别
            Box xbox = Box.createHorizontalBox();
            JLabel sex = new JLabel("性别");
            JLabel sexk=new JLabel(arr1[3]);

            xbox.add(sex);
            xbox.add(Box.createHorizontalStrut(20));
            xbox.add(sexk);
            //返回主界面
            Box tbox = Box.createHorizontalBox();
            JButton xiugai = new JButton("修改");
            JButton fanhui = new JButton("返回");
            xiugai.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        new view.BianJiinterface().init();
                        jf.dispose();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            fanhui.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jf.dispose();
                }
            });

            tbox.add(xiugai);
            tbox.add(Box.createHorizontalStrut(80));
            tbox.add(fanhui);
            //组装竖直box
            vbox.add(Box.createVerticalStrut(50));
            vbox.add(ubox);
            vbox.add(Box.createVerticalStrut(20));
            vbox.add(nbox);
            vbox.add(Box.createVerticalStrut(20));
            vbox.add(pbox);
            vbox.add(Box.createVerticalStrut(20));
            vbox.add(xbox);
            vbox.add(Box.createVerticalStrut(20));
            vbox.add(tbox);
            //
            jp.add(vbox);
            jf.add(jp);
            //
            jf.setVisible(true);

        }

        public static void main(String[] args) throws Exception {
            new view.yonghujiemian().init();
            String file="C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\images\\吉森信 - ゆるやかな畦道で.mp3";
            Play0 play = new Play0(file);
            // 开启
            play.start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("stop!");


        }

    }


