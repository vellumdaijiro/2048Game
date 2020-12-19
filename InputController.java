import java.util.HashMap;
import java.util.Scanner;

public class InputController implements Input {
    private Scanner inputer;
    private String event;
    private HashMap comparsionTable;

    public String translationEvent() {
        return (String) comparsionTable.get(event);
    }

    public void readUserInput() {
        event = inputer.nextLine();
    }


    public InputController() {
        inputer = new Scanner(System.in);
        comparsionTable = new HashMap();
        comparsionTable.put("a", "left");
        comparsionTable.put("d", "right");
        comparsionTable.put("w", "up");
        comparsionTable.put("s", "down");
        comparsionTable.put("r", "restart");
        comparsionTable.put("e", "exit");
    }

    @Override
    public String getEvent() {
        return translationEvent();
    }
    public static void main(String[] args) {
        InputController inputer = new InputController();
        inputer.readUserInput();
        inputer.translationEvent();
        System.out.println(inputer.getEvent());
    }
}
