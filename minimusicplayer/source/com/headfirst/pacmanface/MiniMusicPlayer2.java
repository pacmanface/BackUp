import javax.sound.midi.*;

public class MiniMusicPlayer2 implements ControllerEventListener {
    public static void main(String[] args) {
        MiniMusicPlayer2 mPlayer2 = new MiniMusicPlayer2();
        mPlayer2.go();
    }

    void go(){

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventIWant = {127};
            sequencer.addControllerEventListener(this, eventIWant);
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

                for (int i = 5; i <61; i+=4) {
                    track.add(makeEvent(144,1,i,100,i));
                    track.add(makeEvent(176,1,127,0,i));
                    track.add(makeEvent(128,1,i,100,i+2));    
                }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("la-la-la");
    }

    static MidiEvent makeEvent(int... cmds){
        
        MidiEvent event = null;
        
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(cmds[0], cmds[1], cmds[2], cmds[3]);
            event = new MidiEvent(message, cmds[4]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
    
}
