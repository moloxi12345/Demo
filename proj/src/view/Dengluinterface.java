package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dengluinterface {
    //组件
    JFrame jf = new JFrame("国际象棋");
    final int WIDTH = 500;
    final int HEIGHT = 300;
    JTextField namek;
    JTextField passwordk;

    //组装
    public void init() throws Exception {
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;//获取当前屏幕的宽度
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;//获取当前屏幕的高度
        jf.setBounds((w - WIDTH) / 2, (h - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //JPanel bg=new JPanel();
        BackGroundPanel bg = new BackGroundPanel(ImageIO.read(new File("C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\images\\88.jpg")));
        Box vbox = Box.createVerticalBox();
        //用户名
        Box ubox = Box.createHorizontalBox();
        JLabel name = new JLabel("用户名：");
         namek = new JTextField(15);
        ubox.add(name);
        ubox.add(Box.createHorizontalStrut(20));
        ubox.add(namek);
        //密码
        Box tbox = Box.createHorizontalBox();
        JLabel password = new JLabel("密码：");
         passwordk = new JTextField(15);
        tbox.add(password);
        tbox.add(Box.createHorizontalStrut(20));
        tbox.add(passwordk);
        //button
        Box hbox = Box.createHorizontalBox();
        JButton denglu = new JButton("登录");
        JButton zhuce = new JButton("注册");
        denglu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (namek.getText().isEmpty() || passwordk.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请补全！", "消息提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    String sum=namek.getText()+" "+passwordk.getText();//中间加了空格是为了确保与文件数据匹配的稳定性
                    //对用户名和密码进行匹配
                    boolean cot=false;
                    String s;
                    try {
                        BufferedReader r=new BufferedReader(new FileReader("C:\\Users\\86198\\OneDrive - 南方科技大学\\文档\\GitHub\\Demo\\proj\\resource\\yonghu.txt"));
                        while((s=r.readLine())!=null) {
                            if(s.equals(sum)) {
                                cot=true;//如果符合其中一条数据，就为登录成功
                            }
                        }
                        //对按登录按钮做出的回应
                        if(cot) {
                            JOptionPane.showMessageDialog(null, "登录成功！");
                            SwingUtilities.invokeLater(() -> {
                                ChessGameFrame mainF = new ChessGameFrame(1000, 760);
                                mainF.setVisible(true);
                            });
                            jf.dispose();
                        }else {
                            JOptionPane.showMessageDialog(null, "用户名或者密码错误，登录失败！");
                            clear();
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
        zhuce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new zhuceinterface().init();
                    jf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        hbox.add(zhuce);
        hbox.add(Box.createHorizontalStrut(100));
        hbox.add(denglu);


        vbox.add(Box.createVerticalStrut(40));
        vbox.add(ubox);
        vbox.add(Box.createVerticalStrut(20));
        vbox.add(tbox);
        vbox.add(Box.createVerticalStrut(50));
        vbox.add(hbox);

        bg.add(vbox);
        jf.add(bg);

        jf.setResizable(false);
        jf.setVisible(true);
    }

    //清空账号和密码框
    private void clear() {
        namek.setText("");    //设置为空
        passwordk.setText("");

    }



}

