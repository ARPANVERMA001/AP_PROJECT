package stickhero.stickhero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Stick {
    public int counter = 0;
    public Rectangle stick;
    private double stickLength = 0.0;
    private boolean isStickRotated = false;
    public double initialX;
    public double initialY;
    public double height;
    private Timeline gameTimeline;

    private Timeline rotatetimeline;
    public Stick(Rectangle stick) {
        this.stick = stick;
        System.out.println("hOlalla");
        System.out.println(stick.getX());
        this.initialX=stick.getX();
        System.out.println("Saving X:");
        System.out.println(this.initialX);
        this.initialY=stick.getY();
        System.out.println("Saving Y:");
        System.out.println(this.initialY);
        this.height=stick.getHeight();
        initializeTimeline();
    }
    public void callme()
    {
        if (counter == 0) {
            System.out.println("in start");
            startGame();
//            counter=1;
        }
        if (counter==1) {
            stopGame();
        }
    }
    public void stopthegame()
    {
        stopGame();
    }
    private void initializeTimeline() {
        Duration duration = Duration.millis(50);

        KeyFrame incrementLengthFrame = new KeyFrame(duration, e -> {
            incrementLength();
        });

        gameTimeline = new Timeline(incrementLengthFrame);

        gameTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void startrotate()
    {
        KeyFrame rotateFrame = new KeyFrame(Duration.millis(10), e ->
        {
            rotate();
        });
        rotatetimeline=new Timeline(rotateFrame);
        rotatetimeline.setCycleCount(Timeline.INDEFINITE);
        rotatetimeline.play();
    }
    public void startGame() {
        gameTimeline.play();
    }

    public void stopGame() {
        gameTimeline.stop();
    }

    public boolean isGameRunning() {
        return gameTimeline.getStatus() == Animation.Status.RUNNING;
    }

    void incrementLength() {
//        stickLength += 10.0;
        stick.setHeight(stick.getHeight()+10);
        stick.setY(stick.getY()-10);
//        stick.setTranslateY(stickLength);

        if (stickLength >= 100000.0 && !isStickRotated) {
            rotate();
        }
    }

    int flag_rotate_count=0;
    private void rotate() {
        if(flag_rotate_count==90){
            rotatetimeline.stop();
            GamePlayController.background_move=1;
            //Call the change background Code here!
            flag_rotate_count=0;
            Background.background_shift();
            return;
        }
        flag_rotate_count+=1;
//        System.out.println(flag_rotate_count);
        isStickRotated = true;
        double pivotX = stick.getX() + stick.getWidth() / 2.0; // X-coordinate of the center of the stick
        double pivotY = stick.getY() + stick.getHeight();      // Y-coordinate at the bottom of the stick

        Rotate rotation = new Rotate(1, pivotX, pivotY);
//        Timeline t=new Timeline(new KeyFrame(Duration.))
        stick.getTransforms().add(rotation);
    }
}
