package soundsystem;

import org.springframework.beans.factory.annotation.Value;

public class SgtPeppers implements CompactDisc {

    @Value("${album.Title}")
    private String title;
    @Value("${album.Artist}")
    private String artist;

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
