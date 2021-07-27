package com.aiguigu.project.firstgame;

import javax.swing.*;
import java.awt.*;

public class BallGame extends JFrame {
    //加载照片
    Image ball = Toolkit.getDefaultToolkit().getImage("images/eye.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

    //小球（眼睛最开始的坐标，(x，y）=（200，200）   桌子的范围为(856，501）  所以小球初始位置在桌子的左边
    double x = 200 ;
    double y = 200 ;

    double degree = 3.14/3 ; //弧度，Π = 180°      除三 = 60°

//    //控制小球的水平位移方向  ; 桌子的范围为e(856，501）  所以小球初始位置在桌子的左边
//    boolean right = true ;
//    //控制小球的垂直位移方向  ; 桌子的范围为(856，501）  所以小球初始位置在桌子的中间位置偏上
//    boolean height = true ;

    //绘制窗口的类
    public void paint(Graphics g){
        System.out.println("画了一次窗口");
        g.drawImage(desk,0,0,null) ;
        g.drawImage(ball,(int)x,(int)y,null); //double强转为int--->那我为什么不直接int x y
//        /*
//         *    小球的移动，必须要在桌子里面，所以有以下的判断   (小球所在的坐标系  为第四象限  注意 y为正
//         *      x ：小球所在位置的横坐标
//         *      y ：小球所在位置的纵坐标
//         *   //每次调用一次之后，（x,y)就会改变
//         *
//         */
//        //横坐标的改变
//        // 当小球在左边时，小球的x + 5
//        if(right){
//            x = x + 5 ;
//        }else { //当小球到达极限值 （x=856时，x-5
//            x = x - 5 ;
//        }
//        if( x > 856 ){ //当小球超出856即desk的横坐标最大值时，right = fales
//            right = false ;
//        }else if( x< 0 ){ //当小球小于零即desk的横坐标最大值时，right = true
//            right = true ;
//        }
//
//        //纵坐标的改变
//        // 当小球在上边时，小球的 y + 5
//        if(height){
//            y = y + 5 ;
//        }else { //当小球到达纵坐标极限值 （ y = 501 时，y-5
//            y = y - 5 ;
//        }
//        if( x > 501 ){ //当小球超出501即desk的纵坐标最大值时，height= fales
//            height = false ;
//        }else if( y < 0 ){ //当小球小于零即desk的纵坐标最大值时，height = true
//            height = true ;
//        }
//
//
//
//
////        y = y + 2 ;

        //每次碰撞完的改变
        x = x + 10*Math.cos(degree) ;
        y = y + 10*Math.sin(degree) ;

        //碰撞到上下边界
        if(y > (501 -40-30) || y < ( 0+40+40)){
            degree =- degree ;
        }
        //碰撞到左右边界
        if(x > (+856-40-30) || x < ( 0+40+40)){
            degree = 3.14 - degree ;
        }

    }


    //创建窗口的类
    void launchFrame(){
        setSize(856,501); //桌子的坐标系 即宽856，高501
        setLocation(100,100);
        setVisible(true);

        //动画的实现，每秒绘制窗口25次
        while (true){
            repaint();
            try {

                Thread.sleep(40); //线程休眠,

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }    }



    public static void main(String[] args) {
        System.out.println("游戏开始");

        BallGame game = new BallGame() ;
        game.launchFrame();

    }
}
