package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover {
    private Rover rover = null;
    private SimpleRoverStatsModule statsModule = null;
    private StringBuilder builder = null;
    private RoverCommandParser parser = null;
    private HashMap<String, Integer> map = null;


    public ProgrammableRover(GroundVisor visor, SimpleRoverStatsModule statsModule) {
        this.rover = new Rover(visor);
        this.statsModule = statsModule;
        this.builder = new StringBuilder();
        this.parser = new RoverCommandParser();
        this.map = new HashMap<>();
    }

    /**
     * Функция для считывания и выполнения файла
     * @param path
     */
    public void executeProgramFile(String path) {
        parser.executeFile(path);
        builder = parser.getBuilder();
        parseStringBuilder(builder);
        executeMap();
    }

    public Point getCurrentPosition() {
        return rover.getCurrentPosition();
    }

    /**
     * Что ему нужно?!
     */
    public RoverCommandParser getSettings() {
        return this.parser;
    }

    private File getFile(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        } else return file;

    }

    /**
     * Добавляем в мапу команду и кол-во аргументов
     * @param builder
     */
    private void parseStringBuilder(StringBuilder builder) {
        String[] s = builder.toString().split("\n");
        int tmp = 0;
        for (int i = 0; i < s.length; ++i) {
            for(char elem: s[i].toCharArray()) {
                if(elem == ' ') tmp += 1;
            }
            map.put(s[i], tmp);
            tmp = 0;
        }
    }

    /**
     * Выполняем команды в нашей мапе
     */
    private void executeMap() {
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println("Command: " + entry.getKey() + " Param: " + entry.getValue());
            if (entry.getValue() > 0) {
                executeCommand(entry.getKey(), entry.getValue());
            }
            else executeCommand(entry.getKey());
        }
    }

    private void executeCommand(String s) {
        switch (s) {
            case "move":
                rover.move();
                break;
            case "lift":
                rover.lift();
                break;
            case "===":
                //nothing
                break;
            default:
                //some code...
        }
    }


    private void executeCommand(String s, int param) {
        String[] str = s.split(" ");
        switch(str[0]) {
            case "log":
                if(str[1].equals("off")) {
                    System.out.println("LOG OFF");
                } else System.out.println("LOG ON");
                break;
            case "stats":
                if(str[1].equals("off")) {
                    System.out.println("STATS OFF");
                } else System.out.println("STATS ON");
                break;
            case "turn":
                turnTo(str[1]);
                System.out.println(rover.getDirection());
                break;
            case "land":
                switch (str[3]) {
                    case "north":
                        rover.land(new Point(Integer.parseInt(str[1]), Integer.parseInt(str[2])),Direction.NORTH);
                        break;
                    case "east":
                        rover.land(new Point(Integer.parseInt(str[1]), Integer.parseInt(str[2])),Direction.EAST);
                        break;
                    case "west":
                        System.out.println(str[0] + " " + str[1] + " " + str[2] + " " + str[3]);
                        rover.land(new Point(Integer.parseInt(str[1]), Integer.parseInt(str[2])),Direction.WEST);
                        break;
                    case "south":
                        rover.land(new Point(Integer.parseInt(str[1]), Integer.parseInt(str[2])),Direction.SOUTH);
                        break;
                    default:
                        rover.land(new Point(Integer.parseInt(str[2]), Integer.parseInt(str[3])),Direction.SOUTH);
                        break;
                }
                break;
            default:
                //some code...
        }
    }

    private void turnTo(String str) {
        switch (str) {
            case "north":
                rover.turnTo(Direction.NORTH);
                break;
            case "east":
                rover.turnTo(Direction.EAST);
                break;
            case "west":
                rover.turnTo(Direction.WEST);
                break;
            case "south":
                rover.turnTo(Direction.SOUTH);
                break;
            default:
                System.out.println("UNKNOWN DIRECTION");
                break;
        }
    }

}
