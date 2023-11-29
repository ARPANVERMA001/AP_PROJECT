package stickhero.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GamePlayController implements Initializable {

    public static int background_move=0;//Zero when the background is clickable and active for increasing the stick length and angle of the stick!
    public static int score=0;
    public static int inverse_flag=0;

    @FXML
    private ImageView cherry;

    @FXML
    private ImageView hero;

    @FXML
    private  Rectangle stick;

    @FXML
    private  ImageView platform1;

    @FXML
    private  ImageView platform2;

    private Background background;

    private static Stick sticks;
    private static Platform platform_1;
    private static Platform platform_2;
    private static Hero hero_;
    private static Cherry cherry_;
    private int clicked=0;

    public static Platform get_platform1(){
        return platform_1;
    }

    public static Platform get_platform2(){
        return platform_2;
    }

    public static Stick get_stick(){
        return sticks;
//        return null;
    }
    public static double get_stick_initialX(){
        System.out.println("InitialX:");
        System.out.println(sticks.initialX);
        return sticks.initialX;
    }
    public static double get_stick_initialY(){
        System.out.println("InitialY:");
        System.out.println(sticks.initialY);
        return sticks.initialY;
    }
    public static double get_stick_initial_height(){
        System.out.println("InitialHeight:");
        System.out.println(sticks.height);
        return sticks.height;
    }
    public static Hero get_hero(){
        return hero_;
    }
    public static Cherry get_cherry(){
        return cherry_;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sticks = new Stick(stick);
        platform_1=new Platform(platform1);
        platform_2=new Platform(platform2);
        hero_=new Hero(hero);
        cherry_=new Cherry(cherry);
//        background= new Background();
    }

    @FXML
    private void background_start() {
        if(background_move==0) {
            if (clicked == 0) {
                System.out.println(sticks.counter);
                sticks.callme();
                clicked++;
            } else {
                sticks.stopthegame();
                sticks.startrotate();
                clicked = 0;
            }
        }
        else{
//            System.out.println("Calling Flip Hero Function!");
            Hero.flip_hero(hero_);
        }
    }
}