package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {
    private Ground ground = null;

    public GroundVisor(Ground ground) {
        this.ground = ground;
    }

    /**
     * Есть ли препятствие в клетке point
     * @param point
     * @return false/true
     */
    public boolean hasObstacles(Point point) throws OutOfGroundException {
        int x = point.getX();
        int y = point.getY();
        if(ground.getCell(y,x).getState() == CellState.FREE) {
            return true;
        }
        else return false;
    }

    public Ground getGround() {
        return ground;
    }
}
