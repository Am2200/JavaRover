package netcracker.intensive.rover.stats;

import netcracker.intensive.rover.Point;

import java.util.Collection;
import java.util.HashSet;

public class SimpleRoverStatsModule implements RoverStatsModule {

    private HashSet<Point> set = null;

    public SimpleRoverStatsModule() {
        set = new HashSet<>();
    }

    public void registerPosition(Point position) {
        set.add(position);
    }

    public boolean isVisited(Point point) {
        if(set.contains(point)) return true;
        else return false;
    }

    public Collection<Point> getVisitedPoints() {
        return set;
    }
}
