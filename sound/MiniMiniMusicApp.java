import javax.sound.midi.*;

public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mApp = new MiniMiniMusicApp();
        mApp.play();
    }
    
    void play(){
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ,4);

            Track track = seq.createTrack();

            ShortMessage aMessage = new ShortMessage();
            aMessage.setMessage(144, 1, 44, 100);
            MidiEvent onEvent = new MidiEvent(aMessage, 1);
            track.add(onEvent);

            ShortMessage bMessage = new ShortMessage();
            bMessage.setMessage(128, 1, 44, 100);
            MidiEvent offEvent = new MidiEvent(bMessage,16);
            track.add(offEvent);

            sequencer.setSequence(seq);
            sequencer.start();

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }
}
