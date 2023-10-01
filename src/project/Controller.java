package project;

import javafx.beans.binding.StringBinding;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.StackPane;

/**
 * AUTHOR: Toushal Sewruttun
 * This is the controller of our MVC design
 */
public class Controller {
    private Main.State state;

    /**
     * Controller Constructor controls any mouse event happening in our view
     * It controls the different scene component
     * There is 3 states to handle: DEFAULT, ABOUT, THEME
     * For ABOUT, I don't need a controller since it does not require any controls from the user
     */
    public Controller() {
        // which is playing piano
        //refreshDefault();
        Main.view.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double eventX = event.getX();
                double eventY = event.getY();
                Majorkey currMjK;
                Minorkey currMiK;
                int check = 0;
                //THAT MEANS WE ARE INSIDE PIANO SCENE
                                //PIANO STATE DONE
                state = Main.view.state;
              //  System.out.println(state);
                if(state == Main.State.DEFAULT){



                    if(event.getEventType() == MouseEvent.MOUSE_PRESSED){
                        StackPane n = (StackPane) event.getPickResult().getIntersectedNode().getParent().getParent();
                        StackPane mjPane = (StackPane)n.getChildren().get(0);
                        StackPane miPane = (StackPane)n.getChildren().get(1);


                        //FOR MINOR PANE
                            //WE GIVE PRIORITY MINOR PANE TO HANDLE THE KEY PRESSES FIRST BECAUSE IT OVERLAPS MAJOR ON TOP VIEW
                        boolean minorCheck = false;
                            for(Node node: miPane.getChildren()){
                                Minorkey temp = (Minorkey) node;

                                Bounds bb = temp.getCanvas().getBoundsInParent();
                                if(   (bb.getMinX() <= (event.getX() - 25)) &&  ((event.getX()-25) <= bb.getMaxX()) && (bb.getMinY() <= (event.getY()-160)) && ((event.getY()-160) <= bb.getMaxY())  ){
                                    currMiK = temp;

                                    currMiK.playAudio();
                                    currMiK.drawPress();
                                    minorCheck = true;

                                }

                            }


                            //FOR MAJOR PANE
                        if(!minorCheck){
                            for(Node node: mjPane.getChildren()){

                                Majorkey temp = (Majorkey) node;

                                Bounds bb = temp.getCanvas().getBoundsInParent();
                                if(   (bb.getMinX() <= (event.getX() - 40)) &&  ((event.getX()-40) <= bb.getMaxX()) && (bb.getMinY() <= (event.getY()-250)) && ((event.getY()-250) <= bb.getMaxY())  ){
                                    currMjK = temp;
                                    currMjK.playAudio();
                                    currMjK.drawPress();

                                }

                            }
                        }


                    }else
                    if(event.getEventType() == MouseEvent.MOUSE_RELEASED){
                        StackPane n = (StackPane) event.getPickResult().getIntersectedNode().getParent().getParent();
                        StackPane mjPane = (StackPane)n.getChildren().get(0);
                        StackPane miPane = (StackPane)n.getChildren().get(1);

                        //FOR MINOR REDRAW
                        boolean minorCheck = false;
                        for(Node node: miPane.getChildren()){
                            Minorkey temp = (Minorkey) node;

                            Bounds bb = temp.getCanvas().getBoundsInParent();
                            if(   (bb.getMinX() <= (event.getX() - 25)) &&  ((event.getX()-25) <= bb.getMaxX()) && (bb.getMinY() <= (event.getY()-160)) && ((event.getY()-160) <= bb.getMaxY())  ){
                                currMiK = temp;
                                currMiK.draw();

                                //REMOVING .MP3 FROM audio name
                                String ns = getNote(currMiK.getAudioName());
                                Main.view.globalString = Main.view.globalString +" " +  ns;
                                check = 1;
                                minorCheck = true;
                            }

                        }


                        //FOR MAJOR PANE
                        if(!minorCheck){
                            for(Node node: mjPane.getChildren()){

                                Majorkey temp = (Majorkey) node;

                                Bounds bb = temp.getCanvas().getBoundsInParent();
                                if(   (bb.getMinX() <= (event.getX() - 40)) &&  ((event.getX()-40) <= bb.getMaxX()) && (bb.getMinY() <= (event.getY()-250)) && ((event.getY()-250) <= bb.getMaxY())  ){
                                    currMjK = temp;
                                    currMjK.draw();

                                    //REMOVING .MP3 FROM audio name
                                    String ns = getNote(currMjK.getAudioName());
                                    Main.view.globalString = Main.view.globalString +" " +  ns;
                                    check = 1;
                                }

                            }
                        }



                    }
                    if(check == 1){
                        refreshDefault();
                    }

                } //END OF DEFAULT
                else if(state == Main.State.THEME ){

                    if(event.getEventType() == MouseEvent.MOUSE_PRESSED){
                      // System.out.println( event.getPickResult().getIntersectedNode().getParent().getParent());
                       Node n  = event.getPickResult().getIntersectedNode().getParent();
                       if(n.getId() == "summerPane"){

                           Main.view.main_bp.setBackground(new Background(new BackgroundImage(  Main.view.img0 ,BackgroundRepeat.ROUND,BackgroundRepeat.NO_REPEAT,null,null)));

                       }else if (n.getId() == "fallPane"){

                           Main.view.main_bp.setBackground(new Background(new BackgroundImage(  Main.view.img1 ,BackgroundRepeat.ROUND,BackgroundRepeat.ROUND,null,null)));

                       }else if (n.getId() == "winterPane"){

                           Main.view.main_bp.setBackground(new Background(new BackgroundImage(  Main.view.img2 ,BackgroundRepeat.ROUND,BackgroundRepeat.NO_REPEAT,null,null)));

                       }else if (n.getId() == "springPane"){

                           Main.view.main_bp.setBackground(new Background(new BackgroundImage(  Main.view.img3 ,BackgroundRepeat.ROUND,BackgroundRepeat.NO_REPEAT,null,null)));

                       }

                    }

                } //END OF THEME STATE
            }// END OF HANDLER FUNCTION
        }); //END OF EVENT HANDLER


        //GOTTA MAKE A HANDLER FOR THEME STUFF
    }

    /**
     * This function controls the Key Events happening in our View
     *  and make the necessary changes to our keys
     * @param e key presses
     */
    public void setKeyEvent(KeyEvent e) {
        int check = 0;

        if(state == Main.State.DEFAULT && e!=null) {
            //this is bad conditions , need to fix them again
            //check press for minors , if press then drawpress if relesed draw
            if(e.isShiftDown()){
                for(Minorkey mi: Main.model.getMinorKeyListProperty()){
                    if(e.getCode().equals(mi.getAssignedKey())){

                        if(e.getEventType() == KeyEvent.KEY_PRESSED){
                            mi.playAudio();
                            mi.drawPress();



                        } else if(e.getEventType() == KeyEvent.KEY_RELEASED){
                            mi.draw();
                            //REMOVING .MP3 FROM audio name
                            String ns = getNote(mi.getAudioName());
                            Main.view.globalString = Main.view.globalString +" " +  ns;
                            refreshDefault();

                        } // END OF KEY PRESS/KEY RELEASE
                    } //END OF FINDING THE MINOR
                }// END OF MINOR LOOP

            }else{

                for(Majorkey mj: Main.model.getMajorKeyListProperty()){
                    if(e.getCode().equals(mj.getAssignedKey()) && (e.getEventType() == KeyEvent.KEY_PRESSED) ){
                        mj.playAudio();
                        mj.drawPress();



                    }else if(e.getCode().equals(mj.getAssignedKey()) && (e.getEventType() == KeyEvent.KEY_RELEASED)){
                        String ns = getNote(mj.getAudioName());
                        Main.view.globalString = Main.view.globalString +" " +  ns;
                        mj.draw();
                        check = 1;
                    }
                }

            }




        }
        if(check == 1){
            refreshDefault();
        }


    }

    /**
     * This is to grab the Note part from the file name
     * @param audioName
     * @return
     */
    private String getNote(String audioName){
        String s = "";
        for(char c : audioName.toCharArray()){
            if(c == '.'){
               break;
            }else{
                s = s + c;
            }
        }

        return s;
    }

    /**
     * This function allows our scene to reloaded when a key note is press
     */
    private void  refreshDefault(){

        StringBinding sB = new StringBinding() {
            @Override
            protected String computeValue() {
                return Main.view.globalString;
            }
        };

        Main.view.t_f.textProperty().bind(sB);
    }



}
