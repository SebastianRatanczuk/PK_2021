package soundsystem;

public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    public CDPlayer() {
    }

    public void play() {
        cd.play();
    }

    public CompactDisc getDisc() {
        return cd;
    }

    public void setDisc(CompactDisc disc) {
        this.cd = disc;
    }
}
