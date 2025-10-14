import java.util.*;

interface LightAction {
    void execute();
}

public class smartLight {
    public static void main(String[] args) {
        LightAction motion = () -> System.out.println("Lights ON (motion detected)");
        LightAction evening = () -> System.out.println("Lights dimmed for evening");
        LightAction voice = () -> System.out.println("Lights OFF (voice command)");

        List<LightAction> triggers = Arrays.asList(motion, evening, voice);
        triggers.forEach(LightAction::execute);
    }
}