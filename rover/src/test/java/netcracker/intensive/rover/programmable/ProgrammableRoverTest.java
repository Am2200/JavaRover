package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.AbstractRoverTest;
import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class ProgrammableRoverTest extends AbstractRoverTest {

    private ProgrammableRover testedInstance;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testedInstance = new ProgrammableRover(new GroundVisor(GROUND_3x3), new SimpleRoverStatsModule());
    }

    @Test
    public void testExecuteProgramFile() {
        String file = "C:\\Users\\sc7985\\Desktop\\jar\\jar\\java-nc-intensive\\rover\\src\\test\\resources\\netcracker\\intensive\\rover\\programmable\\program.txt";

        testedInstance.executeProgramFile(file);

        assertEquals(new Point(1, 0), testedInstance.getCurrentPosition());
    }

    @Test
    public void testExecuteProgramFileFillsStatsSettings() {
        String file = "C:\\Users\\sc7985\\Desktop\\jar\\jar\\java-nc-intensive\\rover\\src\\test\\resources\\netcracker\\intensive\\rover\\programmable\\program_with_stats.txt";

        testedInstance.executeProgramFile(file);

        assertEquals(true, testedInstance.getSettings().get(RoverProgram.STATS));
    }

    @Test
    public void testExecuteProgramFileFillsLoggingSettings() {
        String file = "C:\\Users\\sc7985\\Desktop\\jar\\jar\\java-nc-intensive\\rover\\src\\test\\resources\\netcracker\\intensive\\rover\\programmable\\program_with_log.txt";

        testedInstance.executeProgramFile(file);

        assertEquals(true, testedInstance.getSettings().get(RoverProgram.LOG));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetSettingsReturnsImmutableObject() {
        String file = "C:\\Users\\sc7985\\Desktop\\jar\\jar\\java-nc-intensive\\rover\\src\\test\\resources\\netcracker\\intensive\\rover\\programmable\\program_with_log.txt";

        testedInstance.executeProgramFile(file);

      //  testedInstance.getSettings().put("test", "value");
    }
}
