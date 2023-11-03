import static org.junit.Assert.*;
import org.junit.*;

public class GradebookTester {
    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp(){
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        g1.addScore(100);
        g1.addScore(93);
        g2.addScore(78);
        g2.addScore(82);
    }
    
    @After
    public void tearDown(){
        g1 = null;
        g2 = null;
    }

    //testing addScore()
    @Test
    public void testAddScore(){
        assertTrue(g1.toString().equals("[100.0, 93.0, 0.0, 0.0, 0.0]"));
        assertTrue(g2.toString().equals("[78.0, 82.0, 0.0, 0.0, 0.0]"));
        assertEquals(2, g1.getScoreSize());
        assertEquals(2, g2.getScoreSize());
    }

    //testing sum()
    @Test
    public void testSum(){
        assertEquals(193.0, g1.sum(), 0.0001);
        assertEquals(160.0, g2.sum(), 0.0001);
    }

    //testing minimum()
    @Test
    public void testMinimum(){
        assertEquals(93.0, g1.minimum(), 0.001);
        assertEquals(78.0, g2.minimum(), 0.001);
    }

    //testing finalScore()
    @Test
    public void testFinalScore(){
        assertEquals(100.0, g1.finalScore(), 0.001);
        assertEquals(82.0, g2.finalScore(), 0.001);
    }
}
