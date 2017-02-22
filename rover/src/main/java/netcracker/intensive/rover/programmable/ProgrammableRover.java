package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover {

    private GroundVisor visor = null;
    private SimpleRoverStatsModule statsModule = null;

    public ProgrammableRover(GroundVisor visor, SimpleRoverStatsModule statsModule) {
        this.visor = visor;
        this.statsModule = statsModule;
    }

    public void executeProgramFile(String file) {

    }

    public Point getCurrentPosition() {
        return null;
    }

}
