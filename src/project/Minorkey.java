package project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.Locale;

public class Minorkey extends Pane {
    private int width = 30,height = 160;
    private Canvas cv;
    private Color keyColor = Color.DARKCYAN;
    private MediaPlayer m_p;
    private String audioName;
    private KeyCode assignedKey;

    public Minorkey(MediaPlayer m_p, String audioName){
        cv = new Canvas(width,height);
        this.m_p = m_p;
        this.audioName = audioName;


        this.getChildren().add(cv);
    }


    public void assignKey(KeyCode k){
        assignedKey = k;
    }

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
    public Canvas getCanvas(){ return cv;}
    public MediaPlayer getMediaPlayer(){
        return m_p;
    }

    public void drawPress(){
        GraphicsContext gc = cv.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,width,height);
        gc.setStroke(Color.FLORALWHITE);
        gc.strokeRect(5,5,width-10,height - 8);

        gc.setFont(Font.font("Arial",15));
        gc.setFill(Color.WHITE);
        if(assignedKey == KeyCode.DIGIT1){
            gc.fillText("!",width/2 - 2,height/2);
        }else if(assignedKey == KeyCode.DIGIT2){
            gc.setFont(Font.font("Arial",13));
            gc.fillText("@",width/2 - 6,height/2);
            gc.setFont(Font.font("Arial",15));
        }else if(assignedKey == KeyCode.DIGIT4){
            gc.fillText("$",width/2 - 4,height/2);
        }else if(assignedKey == KeyCode.DIGIT5){
            gc.fillText("%",width/2 - 6,height/2);
        }else if(assignedKey == KeyCode.DIGIT6){
            gc.fillText("^",width/2 - 4,height/2);
        }else if(assignedKey == KeyCode.DIGIT8){
            gc.fillText("*",width/2 - 4,height/2);
        }else if(assignedKey == KeyCode.DIGIT9){
            gc.fillText("(",width/2 - 4,height/2);
        }else {
            gc.fillText(assignedKey.toString(),width/2 - 6,height/2);
        }
    }

    public void draw(){
        GraphicsContext gc = cv.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,width,height);
        gc.setStroke(Color.FLORALWHITE);
        gc.strokeRect(5,-1,width-10,height-7);

        gc.setFont(Font.font("Arial",15));
        gc.setFill(Color.WHITE);
        if(assignedKey == KeyCode.DIGIT1){
            gc.fillText("!",width/2 - 2,height/2);
        }else if(assignedKey == KeyCode.DIGIT2){
            gc.setFont(Font.font("Arial",13));
            gc.fillText("@",width/2 - 6,height/2);
            gc.setFont(Font.font("Arial",15));
        }else if(assignedKey == KeyCode.DIGIT4){
            gc.fillText("$",width/2 - 4,height/2);
        }else if(assignedKey == KeyCode.DIGIT5){
            gc.fillText("%",width/2 - 6,height/2);
        }else if(assignedKey == KeyCode.DIGIT6){
            gc.fillText("^",width/2 - 4,height/2);
        }else if(assignedKey == KeyCode.DIGIT8){
            gc.fillText("*",width/2 - 4,height/2);
        }else if(assignedKey == KeyCode.DIGIT9){
            gc.fillText("(",width/2 - 4,height/2);
        }else {
            gc.fillText(assignedKey.toString(),width/2 - 6,height/2);
        }
    }

    public String getAudioName(){
        return audioName;
    }

    public void setPosition(double pos){
        cv.setLayoutX(pos);
        //pos is only for horizontal orientation needed, the height is automatically scalable
    }

    public int getKeyWidth(){
        return width;
    }

    public int getKeyHeight(){
        return height;
    }

    public KeyCode getAssignedKey() {
        return assignedKey;
    }
}
