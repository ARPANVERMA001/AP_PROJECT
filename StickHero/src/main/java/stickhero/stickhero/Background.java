package stickhero.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.Random;

public class Background {

    private static ImageView platform1;
    private static ImageView platform2;
    private static ImageView cherry_image;
    private static Rectangle stick;
    private static ImageView hero;
    private static Double hero_maxX;
    private static Timeline platform1timeline;
    private static Timeline platform2timeline;
    private static Timeline stick_shifttimeline;
    private static Timeline new_platformtimeline;
    private static Timeline cherrytimeline;

    public Background(){

    }

    static void platform1_shift(){
        platform1.setTranslateX(platform1.getTranslateX() - 1.0);
        double platform1_maxX = platform1.getBoundsInParent().getMaxX();
//        System.out.println(platform1_maxX);
        if(platform1_maxX==0){
            System.out.println("Platform-1 has been stopped!!");
            platform1timeline.stop();
            Image platform2Image = platform2.getImage();
//
            platform1.setImage(platform2Image);
//            platform1.setScaleX(platform2.getScaleX());
        }
    }

    static void platform2_shift(){
        platform2.setTranslateX(platform2.getTranslateX() - 1.0);
        double platform2_maxX = platform2.getBoundsInParent().getMaxX();
//        System.out.println(platform2_maxX);
        if(Math.floor(platform2_maxX)==hero_maxX){
            System.out.println("Platform2 has been stopped!!");
            platform2timeline.stop();
            cherrytimeline.stop();
            stick_shifttimeline.stop();
            platform1.setTranslateX(platform1.getTranslateX()+hero_maxX);
            create_newplatform();
        }
    }

    static void cherry_shift(){
        cherry_image.setTranslateX(cherry_image.getTranslateX() - 1.0);
    }
    static void stick_shift(){
        stick.setTranslateX(stick.getTranslateX() - 1.0);
    }

    static void create_newplatform(){
        int platformpositionX= new Random().nextInt((650-350)+1)+350;
//        platform2
//        System.out.println(platform2.getTranslateY());
        platform2.setTranslateY(platform2.getTranslateY()+405);
        platform2.setTranslateX(platform2.getTranslateX()+platformpositionX);
        double platformScaleX = 0.5 + new Random().nextDouble() * (1.25 - 0.5);
        platform2.setScaleX(platformScaleX);
        bring_back_stick();
        new_platformtimeline.play();
    }
//    static void bring_back_stick(){
//        System.out.println(stick.getY());
//        stick.setHeight(GamePlayController.get_stick_initial_height());
//        System.out.println(hero_maxX);
//        System.out.println("++++++++++++++++");
//        System.out.println( stick.getBoundsInParent().getMaxY());
//        System.out.println( stick.getBoundsInParent().getMinY());
//        System.out.println(stick.getY());
//        double offset = hero_maxX-stick.getY();
////        stick.setY(stick.getY()-offset);
////        stick.setX();
//
//        stick.setY(-515);
//        System.out.println("-------------");
//        System.out.println(stick.getY());
//        double pivotX = stick.getX() + stick.getWidth() / 2.0; // X-coordinate of the center of the stick
//        double pivotY = stick.getY() + stick.getHeight();      // Y-coordinate at the bottom of the stick
//        Rotate rotation = new Rotate(270, pivotX, pivotY);
//        stick.getTransforms().add(rotation);
//    }
    static void bring_back_stick(){
        stick.setHeight(GamePlayController.get_stick_initial_height());
        double pivotX = stick.getX() + stick.getWidth() / 2.0; // X-coordinate of the center of the stick
        double pivotY = stick.getY() + stick.getHeight();      // Y-coordinate at the bottom of the stick
        Rotate rotation = new Rotate(270, pivotX, pivotY);
        stick.getTransforms().add(rotation);
//        System.out.println("-----------");
//        System.out.println(stick.getX());

//        stick.setX(0);
//        stick.setTranslateX(stick.getTranslateX()+hero_maxX);




//        double offset= Math.abs(Math.abs(stick.getX())-hero_maxX);
//        System.out.println(offset);
//        stick.setTranslateX(stick.getTranslateX()+offset);
//        stick.setX(GamePlayController.get_stick_initialX()+hero_maxX);
//        stick.setX(stick.getX()+offset);
//
//        System.out.println(stick.getY());
//
//        System.out.println(hero_maxX);
//        System.out.println("++++++++++++++++");
//        System.out.println( stick.getBoundsInParent().getMaxY());
//        System.out.println( stick.getBoundsInParent().getMinY());
//        System.out.println(stick.getY());
//        double offset = hero_maxX-stick.getY();
////        stick.setY(stick.getY()-offset);
////        stick.setX();
//
//        stick.setY(-515);
//        System.out.println("-------------");
//        System.out.println(stick.getY());
    }

    static void emerge_newplatform(){
        platform2.setTranslateY(platform2.getTranslateY()-3);
//        System.out.println(platform2.getTranslateY());
        if(platform2.getTranslateY()==0){
            new_platformtimeline.stop();
            GamePlayController.background_move=0;
        }
    }

    public static void background_shift(){
        platform1=GamePlayController.get_platform1().platform;
        platform2=GamePlayController.get_platform2().platform;
        stick=GamePlayController.get_stick().stick;
        hero=GamePlayController.get_hero().hero;
        cherry_image=GamePlayController.get_cherry().cherry_image;
        hero_maxX=Math.floor(hero.getBoundsInParent().getMaxX());

        System.out.println("Hero MAX: ");
//        System.out.println(hero_maxX);

        KeyFrame platform1Frame = new KeyFrame(Duration.millis(10), e ->
        {
            platform1_shift();
        });

        platform1timeline=new Timeline(platform1Frame);
        platform1timeline.setCycleCount(Timeline.INDEFINITE);
        platform1timeline.play();

        KeyFrame platform2Frame = new KeyFrame(Duration.millis(10), e ->
        {
            platform2_shift();
        });

        platform2timeline=new Timeline(platform2Frame);
        platform2timeline.setCycleCount(Timeline.INDEFINITE);
        platform2timeline.play();

        KeyFrame stick_shiftFrame = new KeyFrame(Duration.millis(10), e ->
        {
            stick_shift();
        });

        stick_shifttimeline=new Timeline(stick_shiftFrame);
        stick_shifttimeline.setCycleCount(Timeline.INDEFINITE);
        stick_shifttimeline.play();

        KeyFrame new_platformFrame = new KeyFrame(Duration.millis(10), e ->
        {
            emerge_newplatform();
        });

        new_platformtimeline=new Timeline(new_platformFrame);
        new_platformtimeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame cherryFrame = new KeyFrame(Duration.millis(10), e ->
        {
            cherry_shift();
        });

        cherrytimeline = new Timeline(cherryFrame);
        cherrytimeline.setCycleCount(Timeline.INDEFINITE);
        cherrytimeline.play();
    }
}