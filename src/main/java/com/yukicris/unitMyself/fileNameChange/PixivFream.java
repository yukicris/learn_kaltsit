package com.yukicris.unitMyself.fileNameChange;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class PixivFream extends JFrame {
    //作者名
    private String posterName;
    //作品名
    private String artistName;

    //文本输入框
    private JTextField jTextField;
    //标签
    private JLabel jLabel;

    private String url;    //网络图片地址
    private String name;   //保存的文件名
    private String savePath; //保存文件路径

    //构造函数初始化相关组件
    public PixivFream() {
        jTextField = new JTextField();
        jLabel = new JLabel("请输入");

        //设置面板布局
        this.setLayout(new BorderLayout());

        //组合布局,使文本框在左侧
        this.add(jTextField,BorderLayout.NORTH);

        //标签放在中部
        this.add(jLabel,BorderLayout.CENTER);

        //把自定义面板放在南部
        this.add(new SouthPanel(),BorderLayout.SOUTH);

        //设立框架基本属性
        this.setSize(500,120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体关闭
        this.setLocationRelativeTo(null);//窗体居中
        this.setVisible(true);//可显示
    }


    //实现按钮监听事件
    public class SouthPanel extends JPanel implements ActionListener{
        //开始爬取按钮
        private JButton fetch;

        public SouthPanel() {
            fetch = new JButton("开始爬取");
            //创建布局
            this.setLayout(new GridLayout(1,3));
            //把按钮添加到Pannel中
            this.add(fetch);

            //设置按钮监听事件
            fetch.addActionListener(this);
        }



        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton)e.getSource();

            if(btn == fetch){
                //执行爬取图片指令
                JOptionPane.showMessageDialog(null,"这是一个弹窗提示"+jTextField.getText(),"提示",JOptionPane.WARNING_MESSAGE);
                String pixiv_Url = "https://www.pixiv.net";
                /*try {
                //获取文本框数据
                //jTextField.getText()
                URL url1 = new URL(pixiv_Url);
                //模拟真实请求
                URLConnection connection = null;

                    connection = url1.openConnection();
                    connection.getContent();


                connection.setRequestProperty("User-Agent", "Mozilla/5.0");

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }*/
            }
        }
        //
    }

    public static void main(String[] args) {
        PixivFream pixivFream= new PixivFream();
    }
}
