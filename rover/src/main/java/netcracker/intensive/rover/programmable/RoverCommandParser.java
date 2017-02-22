package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.RoverCommand;

import java.io.*;
import java.util.HashMap;

/**
 * Класс в котором считывается файл
 */
public class RoverCommandParser {
    private ProgrammableRover rover = null;
    private String path = null;
    private StringBuilder builder = null;

    RoverCommandParser() {
        builder = new StringBuilder();
    }

    RoverCommandParser(ProgrammableRover rover, String path) {
        builder = new StringBuilder();
        this.rover = rover;
        this.path = path;
    }


    public void executeFile(String path) {
        try {
            File file = getFile(path);
            BufferedReader in = new BufferedReader(new FileReader(file));
            try {
                String s;
                while((s = in.readLine()) != null) {
                    builder.append(s);
                    builder.append("\n");
                }
            }
            finally {
                in.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND!" + e);
        }
        catch (IOException e) {
            System.out.println("IOException!" + e);
        }
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    public boolean get(String s) {
        return false;
    }

    private File getFile(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        } else return file;
    }
}
