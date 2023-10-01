package project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.Locale;

public class Majorkey extends Pane {
    private int width = 40,height = 250;
    private Canvas cv;
    private MediaPlayer m_p;
    private String audioName;
    private KeyCode assignedKey;

    public Majorkey(MediaPlayer m_p, String audioName){
        cv = new Canvas(width,height);
        this.m_p = m_p;
        this.audioName = audioName;

        this.getChildren().add(cv);
    }


    public void assignKey(KeyCode k){
        assignedKey = k;
        //LABEL WILL HELP FOR KEY PRESS//
        //THIS WILL BE HARD CODED

    }

    public KeyCode getAssignedKey(){return assignedKey;}

    public void playAudio(){
        m_p.stop();
        m_p.play();

        Timeline t = new Timeline();
        t.setCycleCount(Timeline.INDEFINITE);
        t.getKeyFrames().add(
                //FOR EACH KEYFRAME OF 1 SECOND
                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    int timer = 3;

                    @Override
                    public void handle(ActionEvent event) {
                       if(timer == 0){
                           t.stop();
                           m_p.stop();
                       }
                    }
                }));
                t.playFromStart();
    }

    public MediaPlayer getMediaPlayer(){
        return m_p;
    }

    public String getAudioName(){
        return audioName;
    }

    public void draw(){
        GraphicsContext gc = cv.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,width,height);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeRect(0,0,width,height+5);
        gc.setLineWidth(1);
        gc.setFont(Font.font("Arial",20));

        gc.setFill(Color.BLACK);
        if(assignedKey == KeyCode.DIGIT1){
            gc.fillText("1",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT2){
            gc.fillText("2",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT3){
            gc.fillText("3",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT4){
            gc.fillText("4",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT5){
            gc.fillText("5",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT6){
            gc.fillText("6",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT7){
            gc.fillText("7",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT8){
            gc.fillText("8",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT9){
            gc.fillText("9",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT0){
            gc.fillText("0",width/2 - 5,height - 50);
        }else{
            gc.fillText(assignedKey.toString().toLowerCase(Locale.ROOT),width/2 - 5,height - 50);
        }

    }

    public void setPosition(double pos){
        cv.setLayoutX(pos);
        //pos is only for horizontal orientation needed, the height is automatically scalable
    }

    public Canvas getCanvas(){ return cv;}


    public int getKeyWidth(){
        return width;
    }

    public int getKeyHeight(){
        return height;
    }

    public void drawPress() {
        GraphicsContext gc = cv.getGraphicsContext2D();
        Stop[] stops;
        stops = new Stop[]{new Stop(0,Color.WHITE), new Stop(1,Color.BLACK)};

        LinearGradient gradient = new LinearGradient(0,0,2,2,true, CycleMethod.NO_CYCLE,stops);
        gc.setFill(gradient);
        gc.fillRect(0,0,width,height);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeRect(0,0,width,height+5);
        gc.setLineWidth(1);
        gc.setFont(Font.font("Arial",20));

        gc.setFill(Color.WHITE);
        if(assignedKey == KeyCode.DIGIT1){
            gc.fillText("1",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT2){
            gc.fillText("2",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT3){
            gc.fillText("3",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT4){
            gc.fillText("4",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT5){
            gc.fillText("5",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT6){
            gc.fillText("6",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT7){
            gc.fillText("7",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT8){
            gc.fillText("8",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT9){
            gc.fillText("9",width/2 - 5,height - 50);
        }else if(assignedKey == KeyCode.DIGIT0){
            gc.fillText("0",width/2 - 5,height - 50);
        }else{
            gc.fillText(assignedKey.toString().toLowerCase(Locale.ROOT),width/2 - 5,height - 50);
        }

    }
}
