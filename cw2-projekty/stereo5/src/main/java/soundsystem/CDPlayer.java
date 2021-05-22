package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;


public class CDPlayer implements MediaPlayer {
    @Autowired
    private CompactDisc cd;

    public CDPlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }

}
