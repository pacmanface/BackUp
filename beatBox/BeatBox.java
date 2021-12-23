import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.midi.*;

public class BeatBox {
    JFrame frame;
    JPanel panel;
    ArrayList<JCheckBox> cList;
    Sequence seq;
    Sequencer sequencer;
    Track track;

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
                                "Hand Clap", "High Tom", "High Bongo", "Maracas", "Whistle", "Low Conga",
                                "Cowbell", "Vibraslap", "Low-mid Tom", "Hi Agogo", "Open Hi Conga"};
    
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    void buildGUI(){
        
    }
}
