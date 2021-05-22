package sia.knights;

import org.springframework.beans.factory.annotation.Autowired;

public class BraveKnight implements Knight {
    private Quest quest;

    @Autowired
    private Horse horse;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark(horse);
    }
}
