package netcracker.intensive.rover;

public class Point {
    //не забудьте реализовать equals, hashCode, toString!
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX()
    {
        return this.x;
    }

    int getY()
    {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
       Point point = (Point) obj;
       if (this.x == point.x && this.y == point.y) {
           return true;
       }
       else return false;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}