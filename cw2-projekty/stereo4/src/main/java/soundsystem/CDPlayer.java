package soundsystem;

public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    public CDPlayer() {
    }

    public void play() {
        cd.play();
    }

    public CompactDisc getCompactDisc() {
        return cd;
    }

    public void setCompactDisc(SgtPeppers compactDisc) {
        this.cd = compactDisc;
    }
}
