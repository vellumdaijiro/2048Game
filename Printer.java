public class Printer implements View {

    private int[][] grid;
    private int point;
    private DataModel data;

    public Printer(DataModel dataModel) {
        this.data = dataModel;
        this.grid = data.getGrid();
        this.point = data.getPoint();
    }

    @Override
    public void printGrid() {
        for (int line = 0; line < grid.length; line++) {
            for (int row = 0; row < grid[line].length; row++) {
                String temp = "      ";
                int num = grid[line][row];
                int length = (""+num).length();
                temp = temp.substring(0, temp.length()-length);
                if (num == 0) {
                    System.out.print("."+temp);
                }else {
                    System.out.print(num+temp);

                }
            }
            System.out.println("\n");
        }
    }
    @Override
    public void printPoint() {
        System.out.println("您的分数为:"+data.getPoint());
    }

    public String getEventLog() {
        return "";
    }
    public static void main(String[] args) {
//        Printer p1 = new Printer(new DataController());
//
//        p1.printGrid();
    }
}
