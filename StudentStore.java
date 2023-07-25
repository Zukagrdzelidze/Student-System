import java.util.ArrayList;
import java.util.List;

public class StudentStore {
    private List<Student> students;

    public StudentStore(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

}
