package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

import java.util.ArrayList;

public class Ground {

    private int iSize = 0;
    private int jSize = 0;

    private GroundCell[][] ground = null;

    Ground(int i, int j) {
        ground = new GroundCell[i][j];
        iSize = i;
        jSize = j;
    }

    public void view() {
        for (int i = 0; i < ground[0].length; ++i) {
            for (int j = 0; j < ground.length; ++j) {
                System.out.println("[" + i + "]" + "[" + j + "]" + " = " + ground[i][j].getState());
            }
        }
    }

    /**
     * Всё плохо
     *
     * @param args - ячейки
     */
    public void initialize(GroundCell... args) {
        if (args.length != 0) {
            if (iSize * jSize > args.length) throw new IllegalArgumentException("Error");   //Ошибка не правильно вызывается
            int tmp = 0;
            for (int i = 0; i < iSize; ++i) {
                for (int j = 0; j < jSize; ++j) {
                    ground[j][i] = args[tmp];
                    if (tmp + 1 == args.length) return;
                    else
                        ++tmp;
                }
            }
        }
    }

    public GroundCell getCell(int i, int j) throws OutOfGroundException {
        if (i < 0 || j < 0 || i > iSize || j > jSize)
            throw new OutOfGroundException("Error");
        else
            return ground[i][j];
    }
}
