package sia.knights;

public class SlayDragonQuest implements Quest {

    public SlayDragonQuest() {
    }

    @Override
    public void embark(Horse horse) {
        if (horse != null) System.out.print("Wsiadam na konia i ");
        System.out.println("podejmuję misję pokonania smoka!");
    }

}
