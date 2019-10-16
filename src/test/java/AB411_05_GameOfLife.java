import java.util.Arrays;
import java.util.Random;

public class AB411_05_GameOfLife {
    // Global definierte Konstanten für die beiden Dimensionen
    private final static int DIM1 = 30;
    private final static int DIM2 = 30;

    public static void main(String[] args) {
        // Liefert eine zufällig initialisierte Welt
        // und zeigeWelt auch gleichzeitig
        // TODO
        Boolean[][] initWelt = new Boolean[DIM1][DIM2];
        for (int row = 0; row < DIM1; row++) {
            Arrays.fill(initWelt[row], false);
        }
        initWelt[9][10] = true;
        initWelt[10][11] = true;
        initWelt[11][9] = true;
        initWelt[11][10] = true;
        initWelt[11][11] = true;
        Random random = new Random();
        for (int row = 0; row < DIM1; row++) {
            for (int col = 0; col < DIM2; col++) {
                initWelt[row][col] = random.nextBoolean();
            }
        }
        StdDraw.setCanvasSize(DIM2, DIM1);
        StdDraw.setYscale(0, DIM1);
        StdDraw.setXscale(0, DIM2);
        StdDraw.setPenRadius(0);
        StdDraw.setPenColor(StdDraw.BLACK);
        while (true) {
            initWelt = wendeRegelnAn(initWelt, DIM1, DIM2);
            StdDraw.clear();
            for (int row = 0; row < DIM1; row++) {
                for (int col = 0; col < DIM2; col++) {
                    if (initWelt[row][col] == true) {
                        StdDraw.point(col, row);
                    }
                }
            }
        }
    }

    // Wendet die 4 Regeln an und gibt die Folgegeneration wieder zurück
    private static Boolean[][] wendeRegelnAn(Boolean[][] initWelt, int rowsNum, int colsNum) {
        // TODO
        Boolean[][] nextGen = new Boolean[rowsNum][];
        for (int row = 0; row < rowsNum; row++) {
            for (int col = 0; col < colsNum; col++) {
                // Liefert Anzahl Nachbarn einer Zelle
                int numOfNeighbours = countCellNeighbours(initWelt, rowsNum, colsNum);
                if ((numOfNeighbours < 2) || (numOfNeighbours > 3)) {
                    nextGen[row][col] = false;
                }
                if (numOfNeighbours == 2) {
                    nextGen[row][col] = initWelt[row][col];
                }
                if (numOfNeighbours == 3) {
                    nextGen[row][col] = true;
                }
            }
        }
        return nextGen;
    }
    public static int countCellNeighbours(final Boolean[][] initWelt, int row, int col) {
        int numOfNeighbours = 0;
        if ((row - 1 >= 0) && (col - 1 >= 0)) {
            numOfNeighbours = initWelt[row - 1][col - 1] ? numOfNeighbours + 1 : numOfNeighbours;
        }
        if ((row >= 0) && (col - 1 >= 0)) {
            numOfNeighbours = initWelt[row][col - 1] ? numOfNeighbours + 1 : numOfNeighbours;
        }
        if ((row + 1 < initWelt.length) && (col - 1 >= 0)) {
            numOfNeighbours = initWelt[row + 1][col - 1] ? numOfNeighbours + 1 : numOfNeighbours;
        }
        if ((row + 1 < initWelt.length) && (col < initWelt[0].length)) {
            numOfNeighbours = initWelt[row + 1][col] ? numOfNeighbours + 1 : numOfNeighbours;
        }
        if ((row + 1 < initWelt.length) && (col + 1 < initWelt[0].length)) {
            numOfNeighbours = initWelt[row + 1][col + 1] ? numOfNeighbours + 1 : numOfNeighbours;
        }
        if ((row < initWelt.length) && (col + 1 < initWelt[0].length)) {
            numOfNeighbours = initWelt[row][col + 1] ? numOfNeighbours + 1 : numOfNeighbours;
        }
        if ((row - 1 >= 0) && (col + 1 < initWelt[0].length)) {
            numOfNeighbours = initWelt[row - 1][col + 1] ? numOfNeighbours + 1 : numOfNeighbours;
        }
        if ((row - 1 >= 0) && (col < initWelt[0].length)) {
            numOfNeighbours = initWelt[row - 1][col] ? numOfNeighbours + 1 : numOfNeighbours;
        }
        return numOfNeighbours;
    }
}
