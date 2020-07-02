import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {

    // Have to initialize using the empty constructor outside your test methods
    Student s;
    Student s2;

    // any reference of the this keyword refers to the class (StudentTest) not the object (Student) so it's redundant to s (in this case)
    //    Student class - constructor sets name and id property, initializes grades property as an empty ArrayList.
    @Before
    public void setUp() {
        s = new Student();
//        s = new Student (1, "Test Student"); // uses constructor so initializes grades
        // By setting id and name separately, grades is not initialized. Changed addGrade() to initialize it if null
        s.setId(1);
        s.setName("Test Student");
        s.addGrade(80);
        s.addGrade(90);
        s2 = new Student(2, "Another Test");
    }

//    // Student class - methods:
//    // returns the student's id
//    public long getId();
    @Test
    public void testGetStudentId() {
        assertEquals(1, s.getId(), 0);
        assertEquals(2, s2.getId(), 0);
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

//    // returns the average of the students grades
//    public double getGradeAverage();
    @Test
    public void testAddGetAndGetGradeAverage() {
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
        s.addGrade(0);
        assertEquals(0, s.getGrades().get(2), 0);
        s.updateGrade(2, 85);
        assertEquals(85, s.getGrades().get(2), 0);
        assertEquals(3, s.getGrades().size(), 0);
        s.updateGrade(3, 90);
        assertEquals(4, s.getGrades().size(), 0);
    }

    // Delete grade
    @Test
    public void testDeleteGrade() {
        // s already has 0 : 80, 1 : 90
        s.addGrade(0);
        assertEquals(0, s.getGrades().get(2), 0);
        s.deleteGrade(2);
        assertEquals(2, s.getGrades().size(), 0);
        s.deleteGrade(1);
        assertEquals(1, s.getGrades().size(), 0);
    }

}
