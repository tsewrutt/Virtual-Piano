package project;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

/**
 * AUTHOR: Toushal Sewruttun
 * This is the Model of our MVC design
 */

public class Model {
    private SimpleListProperty<Majorkey> majorKeyListProperty ;
    private SimpleListProperty<Minorkey> minorKeyListProperty ;
    private int keyWidth;
    private int keyHeight;

    /**
     * The Model Contructor holds onto the creation of our instruments
     * Here we construct the:-
     * Piano: The piano has 2 components:
     *        -Minor Keys
     *        -Major Keys
     * @param keyWidth
     * @param keyHeight
     */
    public Model(int keyWidth, int keyHeight) {

        ArrayList<Majorkey> keysArrayList = new ArrayList<>();
        ObservableList<Majorkey> observableList = FXCollections.observableArrayList(keysArrayList);
        majorKeyListProperty = new SimpleListProperty<Majorkey>(observableList);


        ArrayList<Minorkey> keysArrayList2 = new ArrayList<>();
        ObservableList<Minorkey> observableList2 = FXCollections.observableArrayList(keysArrayList2);
        minorKeyListProperty = new SimpleListProperty<Minorkey>(observableList2);



        this.keyHeight = keyHeight;
        this.keyWidth = keyWidth;

    }


    public SimpleListProperty<Majorkey> getMajorKeyListProperty() {
        return majorKeyListProperty;
    }

    public SimpleListProperty<Minorkey> getMinorKeyListProperty() {
        return minorKeyListProperty;
    }

    /**
     * This method gets all major keys from our file
     * and adds it to our MajorKey List
     */
    public void addMajors()  {
        String flPath = "audio/Majors/";
        URL re = getClass().getClassLoader().getResource(flPath);


           File[] f = new File(re.getPath()).listFiles();

              MediaPlayer m;
              for(File file: f){
                 // System.out.println("file:" + file.getName() + "  " + file.getPath());
                   m = new MediaPlayer(new Media(file.toURI().toString()));

                  majorKeyListProperty.add(new Majorkey(m, file.getName()));
              }


    }
    /**
     * This method gets all minor keys from our file
     * and adds it to our MinorKey List
     */
    public void addMinors()  {
        String flPath = "audio/Minors/";
        URL re = getClass().getClassLoader().getResource(flPath);

        File[] f = new File(re.getPath()).listFiles();

        MediaPlayer m;
        for(File file: f){
            m = new MediaPlayer(new Media(file.toURI().toString()));

            minorKeyListProperty.add(new Minorkey(m, file.getName()));

        }

    }

    /**
     * This method sets the key binds for each of our Major and Minor Keys
     */
    public void setKeysForPiano(){
        for(Majorkey mj: majorKeyListProperty){

            //2nd Coloumn
            if(mj.getAudioName().contentEquals("C2.mp3")){
                KeyCode s = KeyCode.DIGIT1;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("D2.mp3")){
                KeyCode s = KeyCode.DIGIT2;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("E2.mp3")){
                KeyCode s = KeyCode.DIGIT3;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("F2.mp3")){
                KeyCode s = KeyCode.DIGIT4;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("G2.mp3")){
                KeyCode s = KeyCode.DIGIT5;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("A2.mp3")){
                KeyCode s = KeyCode.DIGIT6;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("B2.mp3")){
                KeyCode s = KeyCode.DIGIT7;
                mj.assignKey(s);

            }

            //3rd Coloumn
            if(mj.getAudioName().contentEquals("C3.mp3")){
                KeyCode s = KeyCode.DIGIT8;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("D3.mp3")){
                KeyCode s = KeyCode.DIGIT9;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("E3.mp3")){
                KeyCode s = KeyCode.DIGIT0;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("F3.mp3")){
                KeyCode s = KeyCode.Q;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("G3.mp3")){
                KeyCode s = KeyCode.W;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("A3.mp3")){
                KeyCode s = KeyCode.E;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("B3.mp3")){
                KeyCode s = KeyCode.R;
                mj.assignKey(s);

            }


            //4th Coloumn
            if(mj.getAudioName().contentEquals("C4.mp3")){
                KeyCode s = KeyCode.T;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("D4.mp3")){
                KeyCode s = KeyCode.Y;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("E4.mp3")){
                KeyCode s = KeyCode.U;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("F4.mp3")){
                KeyCode s = KeyCode.I;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("G4.mp3")){
                KeyCode s = KeyCode.O;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("A4.mp3")){
                KeyCode s = KeyCode.P;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("B4.mp3")){
                KeyCode s = KeyCode.A;
                mj.assignKey(s);

            }


            //5th Coloumn
            if(mj.getAudioName().contentEquals("C5.mp3")){
                KeyCode s = KeyCode.S;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("D5.mp3")){
                KeyCode s = KeyCode.D;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("E5.mp3")){
                KeyCode s = KeyCode.F;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("F5.mp3")){
                KeyCode s = KeyCode.G;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("G5.mp3")){
                KeyCode s = KeyCode.H;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("A5.mp3")){
                KeyCode s = KeyCode.J;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("B5.mp3")){
                KeyCode s = KeyCode.K;
                mj.assignKey(s);

            }

            //6th Coloumn
            if(mj.getAudioName().contentEquals("C6.mp3")){
                KeyCode s = KeyCode.L;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("D6.mp3")){
                KeyCode s = KeyCode.Z;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("E6.mp3")){
                KeyCode s = KeyCode.X;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("F6.mp3")){
                KeyCode s = KeyCode.C;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("G6.mp3")){
                KeyCode s = KeyCode.V;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("A6.mp3")){
                KeyCode s = KeyCode.B;
                mj.assignKey(s);

            }
            if(mj.getAudioName().contentEquals("B6.mp3")){
                KeyCode s = KeyCode.N;
                mj.assignKey(s);

            }


            //LAST KEY
            if(mj.getAudioName().contentEquals("C7.mp3")){
                KeyCode s = KeyCode.M;
                mj.assignKey(s);

            }



        }


        for(Minorkey mi: getMinorKeyListProperty()){
            //2nd Coloumn
            if(mi.getAudioName().contentEquals("C#2.mp3")){
                KeyCode s = KeyCode.DIGIT1;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("D#2.mp3")){
                KeyCode s = KeyCode.DIGIT2;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("F#2.mp3")){
                KeyCode s = KeyCode.DIGIT4;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("G#2.mp3")){
                KeyCode s = KeyCode.DIGIT5;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("A#2.mp3")){
                KeyCode s = KeyCode.DIGIT6;
                mi.assignKey(s);

            }

            //3rd Coloumn
            if(mi.getAudioName().contentEquals("C#3.mp3")){
                KeyCode s = KeyCode.DIGIT8;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("D#3.mp3")){
                KeyCode s = KeyCode.DIGIT9;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("F#3.mp3")){
                KeyCode s = KeyCode.Q;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("G#3.mp3")){
                KeyCode s = KeyCode.W;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("A#3.mp3")){
                KeyCode s = KeyCode.E;
                mi.assignKey(s);

            }

            //4th coloumn
            if(mi.getAudioName().contentEquals("C#4.mp3")){
                KeyCode s = KeyCode.T;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("D#4.mp3")){
                KeyCode s = KeyCode.Y;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("F#4.mp3")){
                KeyCode s = KeyCode.I;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("G#4.mp3")){
                KeyCode s = KeyCode.O;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("A#4.mp3")){
                KeyCode s = KeyCode.P;
                mi.assignKey(s);

            }

            //5th Coloumn
            if(mi.getAudioName().contentEquals("C#5.mp3")){
                KeyCode s = KeyCode.S;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("D#5.mp3")){
                KeyCode s = KeyCode.D;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("F#5.mp3")){
                KeyCode s = KeyCode.G;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("G#5.mp3")){
                KeyCode s = KeyCode.H;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("A#5.mp3")){
                KeyCode s = KeyCode.J;
                mi.assignKey(s);

            }

            //6th Coloumn
            if(mi.getAudioName().contentEquals("C#6.mp3")){
                KeyCode s = KeyCode.L;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("D#6.mp3")){
                KeyCode s = KeyCode.Z;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("F#6.mp3")){
                KeyCode s = KeyCode.C;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("G#6.mp3")){
                KeyCode s = KeyCode.V;
                mi.assignKey(s);

            }
            if(mi.getAudioName().contentEquals("A#6.mp3")){
                KeyCode s = KeyCode.B;
                mi.assignKey(s);

            }


        }
    }
}
