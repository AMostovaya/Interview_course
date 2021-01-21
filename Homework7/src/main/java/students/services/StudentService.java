package students.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import students.model.Student;
import students.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository.StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentRepository.StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Student saveOrUpdateStudent(Student student) {
        return studentsRepository.saveOrUpdateStudent(student);
    }

    public Student findById(int id) {
        return studentsRepository.findById(id);
    }
}

