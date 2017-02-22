package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

/**
 * Класс, в котором хранится информация о том, свободна ячейка или нет
 */
public class GroundCell {
    private CellState state;

    GroundCell() {

    }

    GroundCell(CellState e) {
        state = e;
    }

    void setState(CellState x) {
        this.state = x;
    }


    public CellState getState() {
        return state;
    }
}
