public class Game {
    private InputController inputer;
    private DataController dataController;
    private Printer printer;

    public Game() {
        this.inputer = new InputController();
        this.dataController = new DataController();
        this.printer = new Printer(dataController);
    }
    public void startup() throws StackOverflowError {
        dataController.createNumber();
        dataController.createNumber();
        while (true) {
            printer.printGrid();
            printer.printPoint();
            inputer.readUserInput();
            if (inputer.getEvent() == "left") {
                dataController.gridLeft();
                dataController.createNumber();
            }else if(inputer.getEvent() == "right") {
                dataController.gridright();
                dataController.createNumber();
            }else if(inputer.getEvent() == "up") {
                dataController.gridUp();
                dataController.createNumber();
            }else if(inputer.getEvent() == "down") {
                dataController.gridDown();
                dataController.createNumber();
            }else if(inputer.getEvent() == "restart") {
                dataController.restart();
            }else if(inputer.getEvent() == "exit") {
                return;
            }else {
                System.out.println("输入不正确");
            }
        }
    }
    public static void main(String[] args) {
        try {
            new Game().startup();
        }catch (StackOverflowError e) {
            System.out.println("GameOver");
        }
    }
}