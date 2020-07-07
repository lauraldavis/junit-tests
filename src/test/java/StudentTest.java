import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class StudentTest {

    // To use @Before, declare object variable outside test methods to call them in the test methods
    Student s;
    Student s2;

    // any reference of the this keyword refers to the class (StudentTest) not the object (Student) so it's redundant to s (in this case)
    //    Student class - constructor sets name and id property, initializes grades property as an empty ArrayList.
    @Before
    public void setUp() {
        s = new Student(1L, "Test Student");
//        s = new Student (1, "Test Student"); // uses constructor so initializes grades
        // Removed ability to use an empty constructor
        s.addGrade(80);
        s.addGrade(90);
        s2 = new Student(2L, "Another Test");
    }

    // The Student class should have a constructor that sets both the name and id property, it initializes the grades property as an empty ArrayList
    @Test
    public void testInitialProperties() {
        Student student = new Student(3L, "John");
        assertEquals(3L, student.getId());
        assertEquals("John", student.getName());
        assertTrue(student.getGrades().isEmpty());
    }

//    // Student class - methods:
//    // returns the student's id
//    public long getId();
    @Test
    public void testGetStudentId() {
        assertEquals(1L, s.getId(), 0);
        assertEquals(2L, s2.getId(), 0);
    }

//    // returns the student's name
//    public String getName();
    @Test
    public void testGetName() {
        assertSame("Test Student", s.getName());
        assertSame("Another Test", s2.getName());
    }

//    // adds the given grade to the grades list
//    public void addGrade(int grade);
    @Test
    public void testAddGrade() {
        Student student = new Student(1L, "John");
        assertEquals(0, student.getGrades().size());
        student.addGrade(100);
        assertEquals(1, student.getGrades().size());
        assertEquals(100, student.getGrades().get(0), 0);
    }

//    // returns the average of the students grades
//    public double getGradeAverage();
    @Test
    public void testGetGradeAverage() {
        s2.addGrade(65);
        s2.addGrade(75);
        s2.addGrade(0);
        assertEquals(0, s2.getGrades().get(2), 0);
        assertEquals(46.66, s2.getGradeAverage(), 0.02);

        assertEquals(80, s.getGrades().get(0), 0);
        assertEquals(90, s.getGrades().get(1), 0);
        assertEquals(85.0, s.getGradeAverage(), 0);
    }

    // Update name
    @Test
    public void testSetName() {
        s.setName("First Student");
        s2.setName("Second Student");
        assertSame("First Student", s.getName());
        assertSame("Second Student", s2.getName());
    }

    // Update grade
    @Test
    public void testUpdateGrade() {
        // s already has 0 : 80, 1 : 90
        assertEquals(2, s.getGrades().size(), 0);
        s.addGrade(0);
        assertEquals(0, s.getGrades().get(2), 0);
        s.updateGrade(2, 85);
        assertEquals(85, s.getGrades().get(2), 0);
        assertEquals(3, s.getGrades().size(), 0);
//        s.updateGrade(3, 90); // if not existing, add it
//        assertEquals(4, s.getGrades().size(), 0);
    }

    // Delete grade
    @Test
    public void testDeleteGrade() {
        // s already has 0 : 80, 1 : 90
        assertEquals(2, s.getGrades().size(), 0);
        s.addGrade(0);
        assertEquals(0, s.getGrades().get(2), 0);
        s.deleteGrade(2);
        assertEquals(2, s.getGrades().size(), 0);
        s.deleteGrade(1);
        assertEquals(1, s.getGrades().size(), 0);
    }

}
