import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * MiniMusicCmdLine
 */
public class MiniMusicCmdLine {

    public static void main(String[] args) {
        MiniMusicCmdLine mCmdLine = new MiniMusicCmdLine();
        if (args.length<2){
            System.out.print("Put arguments in the command line!");
        }else{
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mCmdLine.play(instrument,note);
        }
    }

    void play(int instrument, int note){

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            //MidiEvent mEvent = null;
            
            ShortMessage aMessage = new ShortMessage();
            aMessage.setMessage(192, 1, instrument, 0);
            MidiEvent changeEvent = new MidiEvent(aMessage, 1);
            track.add(changeEvent);
            
            ShortMessage bMessage = new ShortMessage();
            bMessage.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(bMessage,1);
            track.add(noteOn);

            ShortMessage cMessage = new ShortMessage();
            cMessage.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(aMessage, 5);
            track.add(noteOff);

            sequencer.setSequence(seq);
            sequencer.start();
            //Thread.sleep(5000);
            sequencer.stop();

 
        } catch (Exception e) {
            e.printStackTrace();
        }
           
    }
}