import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DataController implements DataModel {
    private int grid[][];
    private int point;

    private int getRandomNumber(int Max, int Min) {
        return (int) Math.floor(Min+Math.random()*Max);
    }

    public DataController() {
        grid = new int[4][4];
    }

    public void createNumber() {
        int line = getRandomNumber(4,0);
        int row = getRandomNumber(4,0);
        if (grid[line][row] == 0) {
            grid[line][row] = Math.random()>0.5?2:4;
        }else {
            createNumber();
        }
    }

    private int[] computedArray(int[] array, String directron) {
        ArrayList temp = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (array[i]>0) {
                temp.add(array[i]);
                array[i] = 0;
            }
        }
        if (directron == "unreverse") {
            for (int i = 0; i < temp.size(); i++) {
                if (i+1 < temp.size()) {
                    if (temp.get(i).equals(temp.get(i+1))) {
                        int num = (int)temp.get(i)*2;
                        temp.set(i, num);
                        temp.remove(i+1);
                    }
                }
            }
            for (int i = 0; i < temp.size(); i++) {
                array[i] = (int) temp.get(i);
            }
        }else if (directron == "reverse") {
            Collections.reverse(temp);
            for (int i = 0; i < temp.size(); i++) {
                if (i+1 < temp.size()) {
                    if (temp.get(i).equals(temp.get(i+1))) {
                        int num = (int)temp.get(i)*2;
                        temp.set(i, num);
                        temp.remove(i+1);
                    }
                }
            }
            Collections.reverse(temp);
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (i >= array.length - temp.size()) {
                    array[i] = (int) temp.get(j);
                    j++;
                }
            }
        }
        return array;
    }
    private int[] getRow(int row) {
        int[] temp = {0, 0, 0, 0};
        int j = row;
        for (int i = 0; i < grid.length; i++) {
            temp[i] = grid[i][j];
        }
        return temp;
    }
    private int[] setRow(int row, int[] arr) {
        int[] temp = arr;
        int j = row;
        for (int i = 0; i < arr.length; i++) {
            grid[i][j] = temp[i];
        }
        return temp;
    }

    public void gridUp() {
        for (int row = 0; row < grid.length; row++) {
            setRow(row, computedArray(getRow(row), "unreverse"));
        }
    }
    public void gridDown() {
        for (int row = 0; row < grid.length; row++) {
            setRow(row, computedArray(getRow(row), "reverse"));
        }
    }
    public void gridLeft() {
        for (int i = 0; i < grid.length; i++) {
            grid[i] = computedArray(grid[i], "unreverse");
        }
    }
    public void gridright() {
        for (int i = 0; i < grid.length; i++) {
            grid[i] = computedArray(grid[i], "reverse");
        }
    }
    public void restart() {
        System.out.println("restart");
    }

    @Override
    public int[][] getGrid() {
        return grid;
    }

    @Override
    public int getPoint() {
        point = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                point += grid[i][j];
            }
        }
        return point;
    }
}
