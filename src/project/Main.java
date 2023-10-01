package project;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * AUTHOR: Toushal Sewruttun
 */
public class Main extends Application {

    public static final int keyHeight = 50;
    public static final int keyWidth = 10;
    public static final Model model = new Model(keyWidth,keyHeight);
    public static final View view = new View();
    public static final Controller controller = new Controller();
    public static boolean startLoading = false;
    public static Image icon;

    public enum State{DEFAULT,ABOUT,THEME};
    private MediaPlayer m;

    public static Stage mainAppStage;
    private Timeline tl;
    private Rectangle fillr;
    public static Pane root;
    int timer;
    public static Scene sc2;

    /**
     * This class is our main class,
     * It calls loadingScreen function which contains the splash screen
     * @param primaryStage our temporary main stage
     */
    @Override
    public void start(Stage primaryStage) {

        timer = 12; // Should be changed later back to 12
        fillr = new Rectangle(0,0,10,20);
        fillr.setFill(Color.CYAN);
        fillr.setStroke(Color.BLACK);
        icon = new Image(getClass().getClassLoader().getResourceAsStream("images/piano.jpg"));
        String source = getClass().getClassLoader().getResource("audio/ThemeSong.mp3").toString();
        m = new MediaPlayer( new Media(source));
        m.play();

       // root = new AnchorPane();
        root = new Pane();
        primaryStage.initStyle(StageStyle.TRANSPARENT);


        if(!startLoading){
            loadStartScreen(primaryStage);

            tl = new Timeline();
            tl.setCycleCount(Timeline.INDEFINITE);


            tl.getKeyFrames().add(
                    //FOR EACH KEYFRAME OF 1 SECOND
                    new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            timer --;
                            System.out.println(timer);
                            if(timer == 0){
                                tl.stop();

                                //VIEW CREATES THE PIANO KEY LAYOUT
                                mainAppStage = new Stage();
                                root.getChildren().add(view);
                                sc2 = new Scene(root,1500,450);


                                mainAppStage.setTitle("Virtual Piano");
                                mainAppStage.setX(Screen.getPrimary().getVisualBounds().getWidth()/2 - (1500/2));
                                mainAppStage.setY(Screen.getPrimary().getVisualBounds().getHeight()/2 - 300);
                                mainAppStage.setScene(sc2);
                                mainAppStage.setResizable(false);
                                Main.mainAppStage.getIcons().add(icon);
                                Main.mainAppStage.getScene().addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
                                            @Override
                                            public void handle(KeyEvent e) {

                                                    controller.setKeyEvent(e);


                                            }
                                        });


                                        mainAppStage.show();
                                m.stop();
                                primaryStage.hide();
                            }
                        }
                    })
            );


            tl.playFromStart();
        }

       primaryStage.show();
    }

    /**
     * This function loads the splash screen
     * @param primaryStage our loading stage
     */
    private void loadStartScreen(Stage primaryStage){
        StackPane stp = new StackPane();

        try{
            ImageView img_view = new ImageView();
            Image img6 = new Image(getClass().getClassLoader().getResourceAsStream("images/loadAnim.gif"));
            img_view.setImage(img6);
            //HAve a rectangle to increase in widthVolume for Main timer

            stp.getChildren().add(img_view);

            //TEXT STUFF
            Text t = new Text("created by Toushal Sewruttun");
            t.setFont(Font.font("Agency FB",18));
            t.setFill(Color.BLACK);

            Pane txtHolder = new Pane();
            txtHolder.setMinSize(30,10);

            txtHolder.getChildren().add(t);
            txtHolder.setTranslateX(img6.getWidth()/2 - 100);
            txtHolder.setTranslateY(img6.getHeight()/2 + 185);
            stp.getChildren().add(txtHolder);


            //RECTANGLE FILLING
            Rectangle fill =  new Rectangle(img6.getWidth(),7);
            fill.setFill(Color.ORANGE);
            fill.setArcHeight(10);
            fill.setArcWidth(10);

            fill.setTranslateY(221); //221 right number
            KeyValue wdValue = new KeyValue(fill.widthProperty(),0);
            KeyFrame frame = new KeyFrame(Duration.seconds(12), wdValue);
            Timeline tFill = new Timeline(frame);
            tFill.play();


            stp.getChildren().add(fill);

            //STP BACKGROUNG STUFF
            stp.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
            stp.setPadding(new Insets(20,20,20,20));
            Rectangle r = new Rectangle(img6.getWidth() ,img6.getHeight() );
            r.setArcHeight(30);
            r.setArcWidth(30);

            stp.setClip(r);


            Scene sc = new Scene(stp, img6.getWidth(),img6.getHeight());

            sc.setFill(Color.TRANSPARENT);
            primaryStage.setScene(sc);

            //FADEIN STUFF
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), stp);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            fadeIn.play();

            //FADEOUT STUFF

            //FOR AUDIO
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(2),
                            new KeyValue(m.volumeProperty(), 0)));




            //FOR SCENE
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(10), stp);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            Timeline tl2 = new Timeline();
            tl2.setCycleCount(Timeline.INDEFINITE);
            tl2.getKeyFrames().add(
                    //FOR EACH KEYFRAME OF 1 SECOND
                    new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                        int timer2 = 10;

                        @Override
                        public void handle(ActionEvent event) {
                            timer2 --;

                            if(timer2 == 0){
                                tl2.stop();
                                fadeOut.play();
                                timeline.play();
                            }
                        }
                    })
            );
            tl2.playFromStart();



            fadeOut.setOnFinished(event -> {

                Main.startLoading = true;
            });


        } catch (Exception ex){
            System.err.println(ex);
        }






    }

    public Pane getRoot(){
        return root;
    }




    public static void main(String[] args) {
        launch(args);
    }
}
