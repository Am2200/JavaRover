package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;
import netcracker.intensive.rover.constants.Direction;

public class Rover implements Moveable, Turnable, Liftable, Landable {

    private Point coordinates = null;
    private Direction direction = null;
    private GroundVisor visor = null;
    private boolean liftable = false;

    public Rover() {

    }

    public Rover(GroundVisor visor) {
        coordinates = new Point(0,0);
        direction = Direction.SOUTH;
        this.visor = visor;
    }

    /**
     * Двигаемся в нужном направлении
     */
    public void move() {
        if (coordinates != null && direction != null) {
            try {
                switch (direction) {
                    case NORTH:
                        if (checkNextPosition(coordinates.getX(),coordinates.getY()-1))
                        coordinates.setPoint(coordinates.getX(),coordinates.getY()-1);
                        break;
                    case EAST:
                        if (checkNextPosition(coordinates.getX()+1,coordinates.getY()))
                        coordinates.setPoint(coordinates.getX()+1,coordinates.getY());
                        break;
                    case WEST:
                        if (checkNextPosition(coordinates.getX()-1,coordinates.getY()))
                        coordinates.setPoint(coordinates.getX()-1,coordinates.getY());
                        break;
                    case SOUTH:
                        if (checkNextPosition(coordinates.getX(),coordinates.getY()+1))
                        coordinates.setPoint(coordinates.getX(),coordinates.getY()+1);
                        break;
                }
                visor.hasObstacles(coordinates);
            }
            catch (OutOfGroundException e) {
                System.out.println(e);
                lift();
            }
        }
    }



    /**
     * Повернуть в любую сторону
     * @param direction
     */
    public void turnTo(Direction direction) {
        this.direction = direction;
    }

    /**
     * Взлететь
     */
    public void lift() {
        if (!liftable) {
            liftable = true;
            coordinates = null;
            direction = null;
        }
    }

    /**
     * Опуститься на заданную клетку, если она свободна
     * @param position
     * @param direction
     */
    public void land(Point position, Direction direction) {
        try {
            if(visor.getGround().getCell(position.getX(), position.getY()).getState() == CellState.FREE) {
                liftable = false;

                this.coordinates = position;
                this.direction = direction;
            }
        }
        catch (OutOfGroundException e) {
            liftable = true;
            System.out.println(e);
        }



    }

    /**
     * Возвращает координаты ровера(в данный момент)
     * @return object Point
     */
    public Point getCurrentPosition() {
        return coordinates;
    }

    /**
     * Летит ли наш ровер или нет
     * @return false/true
     */
    public boolean isAirborne() {
        return liftable;
    }

    /**
     * Возвращает направление ровера
     * @return enum Direction
     */
    public Direction getDirection() {
        return direction;
    }


    private boolean checkNextPosition(int x, int y) throws OutOfGroundException {
        if (visor.getGround().getCell(x,y).getState() == CellState.FREE)
            return true;
        else return false;
    }

}
