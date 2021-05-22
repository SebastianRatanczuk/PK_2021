package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer implements MediaPlayer {

    @Autowired
    private CompactDisc cd;

    public CDPlayer() {
    }

    public void play() {
        cd.play();
    }
}

