package students.repository;

import org.springframework.stereotype.Component;
import students.model.Student;

import java.util.Collections;
import java.util.List;

public class StudentRepository {

    @Component
    public class StudentsRepository {
        private List<Student> students;
        private int maxId;

        public List<Student> findAll() {
            return Collections.unmodifiableList(students);
        }

        public Student saveOrUpdateStudent(Student student) {
            if (student.getId() == 0) {
                maxId++;
                student.setId(maxId);
                students.add(student);
                return student;
            } else {
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getId() == (student.getId())) {
                        students.set(i, student);
                        return student;
                    }
                }
            }

            return student;
        }

        public Student findById(int id) {
            for (Student s : students) {
                if (s.getId() == (id)) {
                    return s;
                }
            }
            throw new RuntimeException("Student not found");
        }
    }

}
