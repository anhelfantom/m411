import java.util.Arrays;
import java.util.Random;

public class Tester {
    // Global definierte Konstanten für die beiden Dimensionen
    public final static int DIM1 = 12;
    public final static int DIM2 = 12;

    // Liefert eine zufällig initialisierte Welt
    // TODO
    public boolean[][] initWelt() {
        boolean[][] initWelt = new boolean[DIM1][DIM2];
        for (int row = 0; row < DIM1; row++) {
            Arrays.fill(initWelt[row], false);
        }
        Random random = new Random();
        for (int row = 0; row < DIM1; row++) {
            for (int col = 0; col < DIM2; col++) {
                initWelt[row][col] = random.nextBoolean();
            }
        }
        return initWelt;
    }
    // Gibt die aktuelle Welt aus
    private void zeigeWelt(boolean[][] initWelt) {
        // TODO
        for (int i = 0; i < DIM1; i++) {
            for (int j = 0; j < DIM2; j++) {
                if (!initWelt()[i][j])
                    System.out.print(". ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
    // Wendet die 4 Regeln an und gibt die Folgegeneration wieder zurück
    public static boolean[][] wendeRegelnAn(boolean[][] welt){
        boolean[][] nextGen = new boolean[DIM1][DIM2];
        for (int row = 0; row < DIM1; row++){
            for (int col = 0; col < DIM2; col++){
                // Liefert Anzahl Nachbarn einer Zelle
                int numOfNeighbours = anzahlNachbarn(welt, DIM1, DIM2);
                if ((numOfNeighbours < 2) || (numOfNeighbours > 3)) {
                    nextGen[row][col] = false;
                }
                if (numOfNeighbours == 2) {
                    nextGen[row][col] = welt[row][col];
                }
                if (numOfNeighbours == 3) {
                    nextGen[row][col] = true;
                }
            }
        }
        return nextGen;
    }
        // Liefert Anzahl Nachbarn einer Zelle
        private static int anzahlNachbarn(boolean[][] welt, int x, int y){
            int returnValue = 0;
            for (int i = x - 1; i <= x + 1; ++i)
                for (int j = y - 1; j <= y + 1; ++j)
                    if (welt[i][j])
                        returnValue += 1;
            // einen Nachbarn zuviel mitgezählt?
            if (welt[x][y])
                returnValue -= 1;
            return returnValue;
        }
        public static void main (String[]args){

            Tester game = new Tester();
            // Welt initialisieren
            boolean[][] welt = game.initWelt();

            System.out.println("Startkonstellation");
            game.zeigeWelt(welt);

            for (int i = 1; i <= 10; i++) {
                welt = game.wendeRegelnAn(welt);
                System.out.println("Generation " + i);
                game.zeigeWelt(welt);
            }
        }
}
