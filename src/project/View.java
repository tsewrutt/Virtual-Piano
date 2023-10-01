package project;

import javafx.animation.*;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleListProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * AUTHOR: Toushal Sewruttun
 * This is the View of our MVC design
 */

public class View extends Pane {
    private Node currentCenter;
    private StackPane entireKeyStack;
    private StackPane keyMajorStack;
    private StackPane keyMinorStack;
    public MenuBar topMenuB;
    public Main.State state;
    public TextArea t_f;
    public String globalString;
    private boolean menuOpen;
    public BorderPane main_bp;
    private VBox leftPart;
    private AnchorPane piano;
    private AnchorPane centerNode;

    public Image img0;
    public Image img1;
    public Image img2;
    public Image img3;
    private Image img5;
    private Image img;
    private Image img4;

    /**
     * The View Constructor holds the default necessities
     * for what our UI need to run
     *
     */
    public View() {
        //1400 is the exact value to fit all white keys in
        keyMajorStack = new StackPane();
        keyMinorStack = new StackPane();
        entireKeyStack = new StackPane();
        globalString = "Select an instrument to start playing!!\n";
        centerNode = new AnchorPane();
        t_f = new TextArea();
        menuOpen = false;

        Main.model.addMajors();
        Main.model.addMinors();
        Main.model.setKeysForPiano();


        img0 = new Image(getClass().getClassLoader().getResourceAsStream("images/summer.gif"));
        img1 = new Image(getClass().getClassLoader().getResourceAsStream("images/fall1.GIF"));
        img2 = new Image(getClass().getClassLoader().getResourceAsStream("images/snow.gif"));
        img3 = new Image(getClass().getClassLoader().getResourceAsStream("images/spring1.gif"));

        img = new Image(getClass().getClassLoader().getResourceAsStream("images/me.jpeg"));
        img4 = new Image(getClass().getClassLoader().getResourceAsStream("images/roll.gif"));

        main_bp = new BorderPane();

        leftPart = leftSideToolPane();

        topMenuB = topMenuBar();
        piano = piano();

        pianoScene();
        //DEFAULT BCKGRD COLOUR
        main_bp.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));

        this.getChildren().add(main_bp);


    }

    /**
     * This function construct the Piano Keyboard
     * @return a StackPane which contains 2 other stackpanes for Majors and Minors
     */
    private AnchorPane piano() {
        keyMajorStack.getChildren().clear();
        keyMinorStack.getChildren().clear();
        entireKeyStack.getChildren().clear();

        drawBackground();


        //int i= 2; i < 8 // can only increment when a set is completed
        int iNote = 2;
        SimpleListProperty<Majorkey> newLMJ;
        SimpleListProperty<Minorkey> newLMI;

        String noteA = "A";
        String noteB = "B";
        String noteC = "C";
        String noteD = "D";
        String noteE = "E";
        String noteF = "F";
        String noteG = "G";

        int i = 0; // this is for total width adding
        int majorChecks;
        String updatedNote;

            while(iNote < 8  ){
                majorChecks = 2;
                newLMJ = Main.model.getMajorKeyListProperty();
                newLMI = Main.model.getMinorKeyListProperty();
                updatedNote = noteC + iNote + ".mp3";


                for(Majorkey mj: newLMJ){
                    if(mj.getAudioName().contentEquals(updatedNote) && (majorChecks == 2)){
                        System.out.println(mj.getAudioName());

                        mj.draw();
                        keyMajorStack.getChildren().add(mj);
                        mj.setPosition(i);
                        i = i + mj.getKeyWidth();

                        majorChecks++;
                        //NEED TO DO MINOR C#
                        updatedNote = noteC + "#" + iNote + ".mp3";
                        for(Minorkey mi: newLMI){
                         if(mi.getAudioName().contentEquals(updatedNote)){
                             System.out.println(mi.getAudioName());
                             mi.draw();
                             keyMinorStack.getChildren().add(mi);
                             mi.setPosition(i - (mi.getKeyWidth()/2));
                         }
                        }

                        //BEFORE MOVING TO DO D
                        updatedNote = noteD + iNote + ".mp3";
                    }else if (mj.getAudioName().contentEquals(updatedNote) && (majorChecks == 3)){
                        System.out.println(mj.getAudioName());

                        mj.draw();
                        keyMajorStack.getChildren().add(mj);
                        mj.setPosition(i);
                        i = i + mj.getKeyWidth();

                        //NEED TO DO MINOR D#
                        updatedNote = noteD + "#" + iNote + ".mp3";
                        for(Minorkey mi: newLMI){
                            if(mi.getAudioName().contentEquals(updatedNote)){
                                System.out.println(mi.getAudioName());
                                mi.draw();
                                keyMinorStack.getChildren().add(mi);
                                mi.setPosition(i - (mi.getKeyWidth()/2));
                            }
                        }

                        majorChecks++;

                        //BEFORE MOVING TO DO E
                        updatedNote = noteE + iNote + ".mp3";
                    }else if(mj.getAudioName().contentEquals(updatedNote) && (majorChecks == 4)){
                        System.out.println(mj.getAudioName());

                        mj.draw();
                        keyMajorStack.getChildren().add(mj);
                        mj.setPosition(i);
                        i = i + mj.getKeyWidth();

                        majorChecks++;
                        updatedNote = noteF + iNote + ".mp3";
                    }else if(mj.getAudioName().contentEquals(updatedNote) && (majorChecks == 5)){
                        System.out.println(mj.getAudioName());

                        mj.draw();
                        keyMajorStack.getChildren().add(mj);
                        mj.setPosition(i);
                        i = i + mj.getKeyWidth();

                        //NEED TO DO MINOR F#
                        updatedNote = noteF + "#" + iNote + ".mp3";
                        for(Minorkey mi: newLMI){
                            if(mi.getAudioName().contentEquals(updatedNote)){
                                System.out.println(mi.getAudioName());
                                mi.draw();
                                keyMinorStack.getChildren().add(mi);
                                mi.setPosition(i - (mi.getKeyWidth()/2));
                            }
                        }

                        majorChecks++;

                        //THEN WE MOVE TO G
                        updatedNote = noteG + iNote + ".mp3";
                    }else if(mj.getAudioName().contentEquals(updatedNote) && (majorChecks == 6)){
                        System.out.println(mj.getAudioName());

                        mj.draw();
                        keyMajorStack.getChildren().add(mj);
                        mj.setPosition(i);
                        i = i + mj.getKeyWidth();

                        //NEED TO DO MINOR G#
                        updatedNote = noteG + "#" + iNote + ".mp3";
                        for(Minorkey mi: newLMI){
                            if(mi.getAudioName().contentEquals(updatedNote)){
                                System.out.println(mi.getAudioName());
                                mi.draw();
                                keyMinorStack.getChildren().add(mi);
                                mi.setPosition(i - (mi.getKeyWidth()/2));
                            }
                        }


                        majorChecks++;
                        //BEFORE GOING TO A
                        updatedNote = noteA + iNote + ".mp3";

                        for(Majorkey mjAB: newLMJ){
                            if(mjAB.getAudioName().contentEquals(updatedNote) && (majorChecks == 7)){
                                System.out.println(mjAB.getAudioName());

                                mjAB.draw();
                                keyMajorStack.getChildren().add(mjAB);
                                mjAB.setPosition(i);
                                i = i + mjAB.getKeyWidth();

                                //NEED TO DO MINOR A#
                                updatedNote = noteA + "#" + iNote + ".mp3";
                                for(Minorkey mi: newLMI){
                                    if(mi.getAudioName().contentEquals(updatedNote)){
                                        System.out.println(mi.getAudioName());
                                        mi.draw();
                                        keyMinorStack.getChildren().add(mi);
                                        mi.setPosition(i - (mi.getKeyWidth()/2));
                                    }
                                }

                                majorChecks++;

                                //WE GO DO B
                                updatedNote = noteB + iNote + ".mp3";

                            }else if(mjAB.getAudioName().contentEquals(updatedNote) && (majorChecks == 8)){
                                System.out.println(mjAB.getAudioName());

                                mjAB.draw();
                                keyMajorStack.getChildren().add(mjAB);
                                mjAB.setPosition(i);
                                i = i + mjAB.getKeyWidth();

                                majorChecks++;

                            }
                        }
                    }


                }
                iNote++;

            }

        entireKeyStack.getChildren().addAll(keyMajorStack,keyMinorStack);
        AnchorPane acp = new AnchorPane();
        AnchorPane.setLeftAnchor( entireKeyStack, -200.0);
        AnchorPane.setTopAnchor( entireKeyStack, 120.0);
        entireKeyStack.setPadding(new Insets(10, 10, 10, 10));

        Rectangle r = new Rectangle( entireKeyStack.getWidth(), entireKeyStack.getHeight());
        r.setArcHeight(30);
        r.setArcWidth(30);
        entireKeyStack.setClip(r);

        entireKeyStack.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));

        acp.getChildren().add( entireKeyStack);

        Pane tKey = topCenterPart();
        acp.getChildren().add(tKey);
        AnchorPane.setLeftAnchor( tKey, 180.0);
        AnchorPane.setTopAnchor( tKey, 10.0);

        acp.setPrefHeight(420);



    return acp;
    }

    /**
     * This set a background of our pane
     */
    private void drawBackground() {

        this.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
    }

    /**
     * This function creates the left side bar which allows us to access other part of our scene
     * @return returns a VBox
     */
    private VBox leftSideToolPane() {
        VBox v_b = new VBox();

        v_b.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, new CornerRadii(20), null)));
        v_b.setBorder(new Border(new BorderStroke(Color.ROSYBROWN,BorderStrokeStyle.SOLID,new CornerRadii(10),new BorderWidths(5))));

        v_b.getChildren().add(new Text("\n\n"));

        Button b1 = new Button("Keyboard");
        Button b2 = new Button("Theme");
        Button b3 = new Button("About");
        Button b4 = new Button("Return");

        Button b5 = new Button("????");

        //BUTTON 1 STYLING
        b1.setPrefWidth(200);
        b1.setPrefHeight(40);
        b1.setTextFill(Color.BLACK);
        b1.setOnAction(event -> {
           state = Main.State.DEFAULT;
            slideTransition();

        });

        b1.setOnMouseEntered (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b1.setStyle(
                        "-fx-background-color: black;" +
                                "-fx-text-fill: white");

            }

        });

        b1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b1.setStyle(null);

            }
        });
        b1.setFont(new Font(15));

        //BUTTON 2 STYLING
        b2.setPrefWidth(200);
        b2.setPrefHeight(40);
        b2.setTextFill(Color.BLACK);
        b2.setOnAction(event -> {
            state = Main.State.THEME;
            slideTransition();

        });
        b2.setFont(new Font(15));
        b2.setOnMouseEntered (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b2.setStyle(
                        "-fx-background-color: black;" +
                                "-fx-text-fill: white");

            }

        });

        b2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b2.setStyle(null);

            }
        });


        //BUTTON 3 STYLING
        b3.setPrefWidth(200);
        b3.setPrefHeight(40);
        b3.setTextFill(Color.BLACK);
        b3.setOnAction(event -> {
            state = Main.State.ABOUT;
            slideTransition();  //sets left side menu back to initial state

        });
        b3.setFont(new Font(15));
        b3.setOnMouseEntered (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b3.setStyle(
                        "-fx-background-color: black;" +
                                "-fx-text-fill: white");

            }

        });

        b3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b3.setStyle(null);

            }
        });

        //BUTTON 4 STYLING
        b4.setPrefWidth(200);
        b4.setPrefHeight(40);
        b4.setTextFill(Color.BLACK);
        b4.setFont(new Font(15));
        b4.setOnAction(event -> slideTransition());
        b4.setOnMouseEntered (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b4.setStyle(
                        "-fx-background-color: black;" +
                                "-fx-text-fill: white");

            }

        });

        b4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b4.setStyle(null);

            }
        });

        //BUTTON 5 STYLING
        b5.setPrefWidth(200);
        b5.setPrefHeight(40);
        b5.setTextFill(Color.BLACK);
        b5.setFont(new Font(15));
        b5.setOnAction(event -> {
            rickRoll();
            slideTransition();
        });
        b5.setOnMouseEntered (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b5.setStyle(
                        "-fx-background-color: black;" +
                                "-fx-text-fill: white");

            }

        });

        b5.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                b5.setStyle(null);

            }
        });



        b1.setTooltip(new Tooltip("Go Play some more music..."));
        b2.setTooltip(new Tooltip("Change the theme"));
        b3.setTooltip(new Tooltip("You want to know more?"));
        b4.setTooltip(new Tooltip("Return"));
        b5.setTooltip(new Tooltip("Click me!"));


        v_b.getChildren().addAll(b1,new Text("\n"), b2,new Text("\n"), b3,new Text("\n"), b4, new Text("\n"),b5);

        v_b.setMinWidth(220);
        v_b.setMinHeight(300);
        v_b.setTranslateX(-220);
        v_b.setAlignment(Pos.TOP_RIGHT);

        v_b.setOpacity(.97);

        return v_b;
        //there controller will change some states of the whole app, then we'll have more states for the other stuff for piano
    }

    /**
     * This function creates the top menu bar of our pane
     * @return returns a MenuBar
     */
    public MenuBar topMenuBar() {
        MenuBar topMenu = new MenuBar();
        //instead of setting keyboard string set a keyboard png itself
        Menu space1 = new Menu("\t\t\t\t\t\t\t\t\t\t\t\t\t");
        Menu i_m = new Menu("Instruments");
        i_m.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");
        MenuItem piano = new MenuItem("Piano");
        i_m.getItems().add(piano);
        piano.setOnAction(event -> pianoScene());

        Menu h_m = new Menu("Help");
        h_m.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");

        MenuItem a_m = new MenuItem("About");
        h_m.getItems().add(a_m);
        a_m.setOnAction(event -> aboutScene());


        Menu space2 = new Menu("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

        space2.setDisable(true);
        space1.setDisable(true);

        Menu l_m = new Menu("Other");
        MenuItem left = new MenuItem(" More Options");
        l_m.getItems().add(left);
        left.setOnAction(event -> {
            slideTransition();});
        l_m.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");

        Menu t_m = new Menu("Theme");
        t_m.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");

        MenuItem t1 = new MenuItem("Fall");
        MenuItem t2 = new MenuItem("Spring");
        MenuItem t3 = new MenuItem("Summer");
        MenuItem t4 = new MenuItem("Winter");

        t1.setOnAction(event -> themeSelector(t1.getText()));
        t2.setOnAction(event -> themeSelector(t2.getText()));
        t3.setOnAction(event -> themeSelector(t3.getText()));
        t4.setOnAction(event -> themeSelector(t4.getText()));


        t_m.getItems().addAll(t1, t2, t3, t4);

        topMenu.getMenus().addAll(space1, i_m, h_m, t_m, space2, l_m);
        topMenu.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
        topMenu.setPrefWidth(1500);
        topMenu.setPrefHeight(25);

        return topMenu;
    }

    /**
     * This function is used to update the theme background of our pane
     *
     * @param text takes a string as parameter for what Theme has been selected in our menubar
     */
    private void themeSelector(String text) {
        if(text.equals("Fall")){

            main_bp.setBackground(new Background(new BackgroundImage(  Main.view.img1 ,BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,null,null)));
           // leftPart.setBackground(new Background(new BackgroundImage(  Main.view.img1 ,BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,null,null)));
          //  topMenuB.setBackground(new Background(new BackgroundImage(  Main.view.img1 ,BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,null,null)));

        //FOR UPDATING LEFTPART AND TOPMENUB WE NEED TO MAKE CUSTOM COLOUR CHANGES

        }else if(text.equals("Winter")){
       //     leftPart.setBackground(new Background(new BackgroundImage(  Main.view.img2 ,BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,null,null)));
           main_bp.setBackground(new Background(new BackgroundImage(  Main.view.img2 ,BackgroundRepeat.ROUND,BackgroundRepeat.NO_REPEAT,null,null)));
        //   topMenuB.setBackground(new Background(new BackgroundImage(  Main.view.img2 ,BackgroundRepeat.ROUND,BackgroundRepeat.NO_REPEAT,null,null)));

        }else if(text.equals("Spring")){

            main_bp.setBackground(new Background(new BackgroundImage(  Main.view.img3 ,BackgroundRepeat.ROUND,BackgroundRepeat.NO_REPEAT,null,null)));

        }else if(text.equals("Summer")){

            main_bp.setBackground(new Background(new BackgroundImage(  Main.view.img0 ,BackgroundRepeat.ROUND,BackgroundRepeat.NO_REPEAT,null,null)));

        }

    }

    /**
     * This function runs our piano scene/default scene
     */
    public void pianoScene() {
        state = Main.State.DEFAULT;
        if(main_bp.getCenter() != null){
            //RESET ENTIRE BORDERPANE

            main_bp.getChildren().clear();
            main_bp.setTop(topMenuB);
            main_bp.setLeft(leftPart);

        }else{
           // main_bp.getChildren().clear();
            main_bp.setTop(topMenuB);
            main_bp.setLeft(leftPart);
        }


        System.out.println("Now Piano scene");


        main_bp.setCenter(piano());

    }

    /**
     * This function runs our about scene,
     * This scene goes about explaining the mechanics of our pane
     */
    private void aboutScene() {
        img5 = Main.icon;
        if(main_bp.getCenter() != null){
            //RESET ENTIRE BORDERPANE

            main_bp.getChildren().clear();
            main_bp.setTop(topMenuB);
            main_bp.setLeft(leftPart);

        }

        main_bp.setCenter(null);
        state = Main.State.ABOUT;


        AnchorPane cp = new AnchorPane();


        //IMAGE OF ME
        Pane p = new Pane();
        ImageView img_view = new ImageView();


        img_view.setImage(img);

        img_view.setFitWidth(450);
        img_view.setFitHeight(300);

        p.getChildren().add(img_view);

        Rectangle r = new Rectangle(img_view.getFitWidth() ,img_view.getFitHeight() );
        r.setArcHeight(30);
        r.setArcWidth(30);

        p.setBorder(new Border(new BorderStroke(Color.CYAN,BorderStrokeStyle.SOLID,new CornerRadii(30),new BorderWidths(10))));
        //p.setB

        img_view.setClip(r);





        cp.getChildren().add(p);
        AnchorPane.setTopAnchor(p,50.0);


        //TITLE
        Pane p_head_t = new Pane();
        Text t_head  = new Text("Virtual Piano");

        t_head.setFont(Font.font("Times New Roman", 20));

        p_head_t.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(20), null )));
        p_head_t.setPrefWidth(150);
        t_head.setY(20);
        t_head.setX(22);
        p_head_t.getChildren().add(t_head);
        cp.getChildren().add(p_head_t);

        AnchorPane.setLeftAnchor(p_head_t,500.0);
        AnchorPane.setTopAnchor(p_head_t,10.0);

        //RIGHT PART
        Pane p_exp = new Pane();
        ImageView img_view5 = new ImageView();


        img_view5.setImage(img5);

        img_view5.setFitWidth(450);
        img_view5.setFitHeight(300);

        p_exp.getChildren().add(img_view5);

        //img_view1.setY(20);
        Rectangle r1 = new Rectangle(img_view5.getFitWidth() ,img_view5.getFitHeight() );
        r1.setArcHeight(30);
        r1.setArcWidth(30);

        p_exp.setBorder(new Border(new BorderStroke(Color.CYAN,BorderStrokeStyle.DASHED,new CornerRadii(30),new BorderWidths(10))));

        img_view5.setClip(r1);

        cp.getChildren().add(p_exp);
        AnchorPane.setLeftAnchor(p_exp,700.0);
        AnchorPane.setTopAnchor(p_exp,50.0);

        //TEXT EXPLAINATION
        Pane p_exp_t = new Pane();
        Text t_exp0 = new Text("Virtual Piano allows you to play a piano.\n This application allows " +
                "you to change the theme of the application \n and will permit you to extend onto playing other instruments \n" +
                "in its full-release. For now, only the Piano Instrument is available...");
        Text t_exp1 = new Text("Controls:");
        Text t_exp2 = new Text("Use your keys to be creative!\n[press SHIFT for minors]");

        t_exp0.setFill(Color.WHITE);
        t_exp0.setFont(Font.font("Agency FB", 20));
        t_exp0.setTextAlignment(TextAlignment.CENTER);
        t_exp0.setY(-20);
        t_exp0.setX(10);


        t_exp1.setFill(Color.WHITE);
        t_exp1.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        t_exp1.setTextAlignment(TextAlignment.CENTER);
        t_exp1.setY(170);
        t_exp1.setX(12);

        t_exp2.setFill(Color.WHITE);
        t_exp2.setFont(Font.font("Agency FB", 20));
        t_exp2.setTextAlignment(TextAlignment.CENTER);
        t_exp2.setY(210);
        t_exp2.setX(12);

        p_exp_t.getChildren().addAll(t_exp0,t_exp1,t_exp2);

        cp.getChildren().add(p_exp_t);
        AnchorPane.setLeftAnchor(p_exp_t,700.0);
        AnchorPane.setTopAnchor(p_exp_t,100.0);




        //ANOTHER TEXT FOR BOTTOM CREATION PART
        Pane p_btm_text = new Pane();

        Text t_b = new Text("Created by: Toushal Sewruttun");
        t_b.setFont(Font.font("Agency FB", 20));


        p_btm_text.getChildren().add(t_b);
        cp.getChildren().add(p_btm_text);
        AnchorPane.setLeftAnchor(p_btm_text,450.0);
        AnchorPane.setTopAnchor(p_btm_text,390.0);
        t_b.setY(20);
        t_b.setX(30);
        p_btm_text.setPrefWidth(250);
        p_btm_text.setPrefHeight(50);
        p_btm_text.setBackground(new Background(new BackgroundFill(Color.BEIGE, new CornerRadii(20), null )));


        System.out.println("Now ABout scene");
     //   main_bp.setBackground(new Background(new BackgroundFill(Color.ROSYBROWN, null, null)));

        cp.setPrefHeight(420);
        main_bp.setCenter(cp);
    }


    /**
     * This function holds the container for our text field element
     * @return returns a VBox
     */
    private VBox topCenterPart(){
        VBox upperVB = new VBox();
        HBox upperHB = new HBox();


        upperHB.getChildren().add(t_f);

        //t_f.setAlignment(Pos.TOP_LEFT);
        t_f.setWrapText(true);

        StringBinding sB = new StringBinding() {
            @Override
            protected String computeValue() {
                return globalString;
            }
        };

        t_f.textProperty().bind(sB);


        t_f.setStyle("-fx-control-inner-background: rgba(0, 100, 100, 0.5); -fx-text-fill: #000000;");
       //-fx-background-radius: 15;  -fx-border-radius: 25 "
        t_f.setFont(Font.font("Times",15));
        t_f.setPrefSize(700,90);

        //CHANGE DISABLED COLOUR SCHEME< ITS TOO PALE
        t_f.setDisable(true);
        t_f.setOpacity(.8);


        upperVB.setAlignment(Pos.CENTER);

        Button b_clear  = new Button("clear");
        b_clear.setPrefSize(70,40);
        b_clear.setOnAction(event -> {
            globalString ="";
            t_f.clear();
            pianoScene();
        });

        upperHB.getChildren().add(new Text("\t"));
        upperHB.getChildren().add(b_clear);
        upperHB.setAlignment(Pos.CENTER);

        upperVB.getChildren().add(upperHB);
        return upperVB;

    }

    /**
     * This function runs our theme scene
     * This function can only be accessed using the left side tool bar
     */
    private void themeScene() {
        state = Main.State.THEME;

        if(main_bp.getCenter() != null){
            //RESET ENTIRE BORDERPANE
            System.out.println("clear first");
            main_bp.getChildren().clear();
            main_bp.setTop(topMenuB);
            main_bp.setLeft(leftPart);

        }

        AnchorPane cp = new AnchorPane();

        //SUMMER GRID
        Pane pS = new Pane();
        pS.setPrefSize(209,400);
        ImageView img_view0 = new ImageView();
        img_view0.setImage(img0);

        img_view0.setFitWidth(400);
        img_view0.setFitHeight(400);

        pS.getChildren().add(img_view0);

        Rectangle r = new Rectangle(img_view0.getFitWidth() - 200 ,img_view0.getFitHeight() );
        r.setArcHeight(30);
        r.setArcWidth(30);


        pS.setId("summerPane");


        img_view0.setClip(r);
        pS.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(20),new BorderWidths(10))));
        cp.getChildren().add(pS);
        AnchorPane.setLeftAnchor(pS,25.0);
        AnchorPane.setTopAnchor(pS,10.0);


        //FALL GRID
        Pane pF = new Pane();
        pF.setPrefSize(209,400);
        ImageView img_view1 = new ImageView();
        img_view1.setImage(img1);

        img_view1.setFitWidth(400);
        img_view1.setFitHeight(400);

        pF.getChildren().add(img_view1);

        Rectangle r1 = new Rectangle(img_view1.getFitWidth() - 200 ,img_view1.getFitHeight() );
        r1.setArcHeight(30);
        r1.setArcWidth(30);

        img_view1.setClip(r1);

        pF.setId("fallPane");
        pF.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(20),new BorderWidths(10))));
        cp.getChildren().add(pF);

        AnchorPane.setLeftAnchor(pF,275.0);
        AnchorPane.setTopAnchor(pF,10.0);

//        //WINTER GRID
        Pane pW = new Pane();
        pW.setPrefSize(209,400);
        ImageView img_view2 = new ImageView();
        img_view2.setImage(img2);

        img_view2.setFitWidth(400);
        img_view2.setFitHeight(400);

        pW.getChildren().add(img_view2);

        Rectangle r2 = new Rectangle(img_view2.getFitWidth() - 200 ,img_view2.getFitHeight() );
        r2.setArcHeight(30);
        r2.setArcWidth(30);

        img_view2.setClip(r2);
        pW.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(20),new BorderWidths(10))));
        pW.setId("winterPane");
        cp.getChildren().add(pW);

        AnchorPane.setLeftAnchor(pW,525.0);
        AnchorPane.setTopAnchor(pW,10.0);

        //SPRING GRID
        Pane pSg = new Pane();
        pSg.setPrefSize(209,400);
        ImageView img_view3 = new ImageView();
        img_view3.setImage(img3);

        img_view3.setFitWidth(400);
        img_view3.setFitHeight(400);

        pSg.getChildren().add(img_view3);
        pSg.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(20),new BorderWidths(10))));
        pSg.setId("springPane");

        Rectangle r3 = new Rectangle(img_view3.getFitWidth() - 200 ,img_view3.getFitHeight() );
        r3.setArcHeight(30);
        r3.setArcWidth(30);

        img_view3.setClip(r3);
        cp.getChildren().add(pSg);

        AnchorPane.setLeftAnchor(pSg,775.0);
        AnchorPane.setTopAnchor(pSg,10.0);

        //END//

        //TEXT LABELS
        Text tS = new Text("Summer");
        Text tW = new Text("Winter");
        Text tSp = new Text("Spring");
        Text tF = new Text("Fall");

        tS.setFill(Color.WHITE);
        tS.setFont(Font.font("Freestyle Script",FontWeight.BOLD,40));
        cp.getChildren().add(tS);
        AnchorPane.setLeftAnchor(tS,90.0);
        AnchorPane.setTopAnchor(tS,40.0);


        tW.setFill(Color.WHITE);
        tW.setFont(Font.font("Freestyle Script",FontWeight.BOLD,40));
        cp.getChildren().add(tW);
        AnchorPane.setLeftAnchor(tW,600.0);
        AnchorPane.setTopAnchor(tW,40.0);


        tSp.setFill(Color.WHITE);
        tSp.setFont(Font.font("Freestyle Script",FontWeight.BOLD,40));
        cp.getChildren().add(tSp);
        AnchorPane.setLeftAnchor(tSp,850.0);
        AnchorPane.setTopAnchor(tSp,40.0);

        tF.setFill(Color.WHITE);
        tF.setFont(Font.font("Freestyle Script",FontWeight.BOLD,40));
        cp.getChildren().add(tF);
        AnchorPane.setLeftAnchor(tF,350.0);
        AnchorPane.setTopAnchor(tF,40.0);


       // main_bp.setBackground(new Background(new BackgroundFill(Color.GOLDENROD, null, null)));
        cp.setPrefHeight(420);
        main_bp.setCenter(cp);



    }

    /**
     * This function controls the animation for the sliding trnasition of our
     * left side tool bar
     */
    public void slideTransition() {
        System.out.println("Slides");

        if (!menuOpen) {
//            main_bp.setLeft(leftPart);
            leftPart.setVisible(true);
            if(main_bp.getCenter() != null){
              // System.out.println(main_bp.getCenter() +"  "+ main_bp.getCenter().getLayoutBounds());

                leftPart.toFront();
                currentCenter = main_bp.getCenter();

            }
            System.out.println("Menu Open");

            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(leftPart);
            slide.setToX(-20.0);
            System.out.println("should slide now");
            leftPart.setTranslateX(-200);
            slide.setOnFinished((ActionEvent e) -> {

                menuOpen = true;
            });
            slide.play();

        } else {
            System.out.println("Menu Deleted");

            TranslateTransition slide2 = new TranslateTransition();
            slide2.setDuration(Duration.seconds(0.4));
            slide2.setNode(leftPart);

            slide2.setToX(-200);

            System.out.println("should slide back to 0 now");
            leftPart.setTranslateX(-20.0);

            slide2.setOnFinished((ActionEvent e) -> {

                leftPart.setVisible(false);

                    leftPart.toBack();
                    //WE CAN HAVE THE DIFFERENT STATES RUN TO TAKE OVER
                    if(state == Main.State.DEFAULT){
                        pianoScene();
                    }else if(state == Main.State.THEME){

                        themeScene();
                    }else if(state == Main.State.ABOUT){
                        aboutScene();
                    }
                menuOpen = false;
            });
            slide2.play();

            //Pane dummyp = new Pane();

        }

    }

    /**
     * This function is for the hidden button
     * It can only be access using the left side tool bar
     * It creates a new stage then closes it when the time runs out
     */
    public void rickRoll(){
        MediaPlayer m;
       //Stage c =  Main.mainAppStage;

       Stage n = new Stage();
       //THIS IS FOR FULLY TRANSAPARENT
       n.initStyle(StageStyle.TRANSPARENT);

        n.setX(Screen.getPrimary().getVisualBounds().getWidth()/2 - 250);
        n.setY(Screen.getPrimary().getVisualBounds().getHeight()/2 - 200);

        String source = getClass().getClassLoader().getResource("audio/rickroll.mp3").toString();
        m = new MediaPlayer( new Media(source));
        double volume = m.getVolume();
        m.setVolume(0.0);



       StackPane otherroot = new StackPane();

        ImageView img_view = new ImageView();



        img_view.setImage(img4);
        img_view.setFitHeight(320);
        img_view.setFitWidth(450);

        otherroot.getChildren().add(img_view);

        otherroot.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
        otherroot.setPadding(new Insets(20,20,20,20));
        Rectangle r = new Rectangle(img_view.getFitWidth() ,img_view.getFitHeight() );
        r.setArcHeight(30);
        r.setArcWidth(30);

        otherroot.setClip(r);
        Scene sc = new Scene(otherroot,img_view.getFitWidth(),img_view.getFitHeight());


        //SETS PICTURE SO AUDIO FADES IN THEN WINDOW FADES IN THEN FADES OUT AND CLOSES WINDOW WHEN
        //SONG IS DONE

        //FADEIN STUFF
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), otherroot);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);


        //FADEOUT STUFF
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), otherroot);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        //FOR AUDIO

       // FADEIN STUFF
        Timeline audioFIn = new Timeline(
                new KeyFrame(Duration.seconds(3),
                        new KeyValue(m.volumeProperty(), volume )));
        ;

        //FADEOUT STUFF
        Timeline audioFout = new Timeline(
                new KeyFrame(Duration.seconds(3),
                        new KeyValue(m.volumeProperty(), 0)));

        //TIMELINE SCENE THE CHAIN ACTION

        Timeline t1 = new Timeline();
        t1.setCycleCount(Timeline.INDEFINITE);
        t1.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    int timer = 23;
                    @Override
                    public void handle(ActionEvent event) {
                        if(timer == 23){
                            fadeIn.play();
                            audioFIn.play();
                            m.play();
                            n.show();

                        }
                        if(timer == 3){
                            fadeOut.play();
                            audioFout.play();
                        }
                        if(timer == 0){
                            t1.stop();
                        }
                        timer--;
                    }
                })
        );
        t1.playFromStart();



        fadeOut.setOnFinished(event -> {
            n.close();
        });




        sc.setFill(Color.TRANSPARENT);




       n.setScene(sc);

    }
}
