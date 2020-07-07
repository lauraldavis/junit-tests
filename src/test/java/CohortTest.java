import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CohortTest {

    Cohort ganymede;
    Cohort hyperion;
    Cohort io;

    @Before
    public void setUp() {
        io = new Cohort(); //empty

        hyperion = new Cohort(); // one
        Student s1 = new Student(1L, "Somebody");
        s1.addGrade(93);
        hyperion.addStudent(s1);

        ganymede = new Cohort(); // many
        Student s2 = new Student(2L, "Somebody Else");
        s2.addGrade(90);
        ganymede.addStudent(s2);
        Student s3 = new Student(3L, "Someone New");
        s3.addGrade(85);
        s3.addGrade(95);
        ganymede.addStudent(s3);
    }

    // A Cohort instance can add a Student to the List of students
    @Test
    public void testAddStudent() {
        assertEquals(2, ganymede.getStudents().size());
        Student s4 = new Student(4L, "Someone Else New");
        ganymede.addStudent(s4);
        assertEquals(3, ganymede.getStudents().size());
    }

    // A Cohort instance can get the current List of students
    @Test
    public void testGetStudents() {
        assertTrue(io.getStudents().isEmpty());
        // s1
        assertEquals(1, hyperion.getStudents().size());
        assertEquals("Somebody", hyperion.getStudents().get(0).getName());
        // s2
        assertEquals(2, ganymede.getStudents().size());
        assertEquals("Somebody Else", ganymede.getStudents().get(0).getName());
    }

    @Test
    public void testAddStudentToCohort() {
        assertEquals(2, ganymede.getStudents().size());
        Student s4 = new Student(4L, "Someone Else New");
        s4.addGrade(85);
        s4.addGrade(95);
        ganymede.addStudent(s4);
        assertEquals(3, ganymede.getStudents().size());
    }

    // A Cohort instance can get the average, and it's being calculated correctly
    @Test
    public void testGetCohortAverage() {
        assertEquals(93, hyperion.getCohortAverage(), 0);
        // 90, {85, 95}
        assertEquals(90, ganymede.getCohortAverage(), 0);

        Student s4 = new Student(4L, "Someone Else New");
        ganymede.addStudent(s4);
        s4.addGrade(0);
        // 90, {85, 95}, 0
        assertEquals(60, ganymede.getCohortAverage(), 1);
    }

    @Test
    public void testFindStudentById(){
        assertSame(hyperion.getStudents().get(0), hyperion.findStudentById(1L));
        assertSame(ganymede.findStudentById(2L), ganymede.getStudents().get(0));
        assertSame(ganymede.findStudentById(3L), ganymede.getStudents().get(1));
    }
}
