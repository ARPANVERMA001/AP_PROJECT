package stickhero.stickhero;

import javafx.scene.image.ImageView;

public class Hero {
    public ImageView hero;
    public static final int HEROHEIGHT=47;
    public static final int STICKWIDTH=7;

    private static int flip_counter=0;
    Hero(ImageView hero){
        this.hero=hero;
    }
    public static void flip_hero(Hero hero_){
        hero_.hero.setRotate(hero_.hero.getRotate()+180);
//        System.out.println(hero_.hero.getRotate());
        if(flip_counter%2==0){
            hero_.hero.setY(hero_.hero.getY()+HEROHEIGHT+STICKWIDTH);
            GamePlayController.inverse_flag=1;
        }
        else{
            hero_.hero.setY(hero_.hero.getY()-HEROHEIGHT-STICKWIDTH);
            GamePlayController.inverse_flag=0;
        }
        flip_counter+=1;
//        System.out.println("rotated!");
        hero_.hero.setScaleX(hero_.hero.getScaleX()*(-1));
    }
}