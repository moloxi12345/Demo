package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BianJiinterface {
    //组件
    JFrame jf = new JFrame("编辑你的信息");
    final int WIDTH = 500;
    final int HEIGHT = 400;

    //组装
    public void init() throws Exception {
        BackGroundPanel jp = new BackGroundPanel(ImageIO.read(new File("C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\images\\980.jpg")));
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;//获取当前屏幕的宽度
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;//获取当前屏幕的高度
        jf.setBounds((w - WIDTH) / 2, (h - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Box vbox = Box.createVerticalBox();
        //组装昵称
        Box ubox = Box.createHorizontalBox();
        JLabel name = new JLabel("昵称");
        JTextField namek = new JTextField(15);
        ubox.add(name);
        ubox.add(Box.createHorizontalStrut(20));
        ubox.add(namek);
        //组装年龄
        Box nbox = Box.createHorizontalBox();
        JLabel age = new JLabel("年龄");
        JTextField agek = new JTextField(15);
        nbox.add(age);
        nbox.add(Box.createHorizontalStrut(20));
        nbox.add(agek);
        //组装手机号
        Box pbox = Box.createHorizontalBox();
        JLabel phone = new JLabel("手机号");
        JTextField phonek = new JTextField(15);
        pbox.add(phone);
        pbox.add(Box.createHorizontalStrut(20));
        pbox.add(phonek);
        //组装性别
        Box xbox = Box.createHorizontalBox();
        JLabel sex = new JLabel("性别");
        JRadioButton male = new JRadioButton("男", false);
        JRadioButton female = new JRadioButton("女", false);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        xbox.add(sex);
        xbox.add(Box.createHorizontalStrut(20));
        xbox.add(male);
        xbox.add(female);
        xbox.add(Box.createHorizontalStrut(120));
        //返回主界面
        Box tbox = Box.createHorizontalBox();
        JButton baocun = new JButton("保存");
        JButton fanhui = new JButton("返回");

        fanhui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                try {
                    new yonghujiemian().init();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        baocun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sum ="";

                    BufferedWriter w = new BufferedWriter(new FileWriter("C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\proj\\resource\\xinxi.txt", false));
                    if (male.isSelected()) {
                        sum = namek.getText() + " " + agek.getText() + " " + phonek.getText() + " " + "男";//中间加了空格是为了确保后续登录与文件数据匹配的稳定性
                    } else if (female.isSelected()) {
                       sum = namek.getText() + " " + agek.getText() + " " + phonek.getText() + " " + "女";
                    }
                    w.write(sum);
                    w.newLine();
                    w.flush();
                    w.close();
                    jf.dispose();
                    new yonghujiemian().init();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        tbox.add(baocun);
        tbox.add(Box.createHorizontalStrut(100));
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


}
