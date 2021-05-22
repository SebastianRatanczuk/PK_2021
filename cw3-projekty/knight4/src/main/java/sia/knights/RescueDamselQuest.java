package sia.knights;

import java.io.PrintStream;

public class RescueDamselQuest implements Quest {

    private PrintStream stream;

    public RescueDamselQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark(Horse horse) {
        if (horse != null)
            System.out.print("Wsiadam na konia i ");
        System.out.println("podejmuję misję ratowania niewiasty.");
    }

}
