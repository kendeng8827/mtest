package jun.yu.code.coverage.jacocotest;

import java.util.ArrayList;
import java.util.List;
    
import org.testng.Assert;
import org.testng.annotations.Test;
    
public class StudyGroupTest {
    @Test(groups={"function"})
    public void testStudyGroupClass() {
        // prepare the data for test
        final List<Student> testStudents = new ArrayList<Student>();
        testStudents.add(new Student(1, "Student No.1", 60, "address1"));
        testStudents.add(new Student(2, "Student No.2", 70,"address1"));
        testStudents.add(new Student(3, "Student No.2", 80,"address1"));
        
        // Start the unit test
        final StudyGroup testGroup = new StudyGroup();
        for(Student student: testStudents) {
            testGroup.addStudent(student);
        }
        Assert.assertEquals(testGroup.getGroupSize(), testStudents.size());
        
        Student testStudent = testStudents.get(0);
        Student returnedStudent = testGroup.getStudent(testStudent.getId());
        Assert.assertSame(returnedStudent, testStudent);
        Assert.assertEquals(returnedStudent.getId(), testStudent.getId());
        Assert.assertEquals(returnedStudent.getName(), testStudent.getName());
        Assert.assertEquals(returnedStudent.getScore(), testStudent.getScore());
        
        testGroup.removeStudent(testStudent.getId());
        Assert.assertEquals(testGroup.getGroupSize(), testStudents.size() - 1);
        
        testGroup.clear();
        Assert.assertEquals(testGroup.getGroupSize(), 0);
    }
}