package students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import students.model.Student;
import students.services.StudentService;

import java.util.List;

    @Controller
    @RequestMapping("/students")
    class StudentsController {
        private StudentService studentsService;

        @Autowired
        public StudentsController(StudentService studentsService) {
            this.studentsService = studentsService;
        }

        @GetMapping
        public String showAllStudents(Model model) {
            List<Student> students = studentsService.getAllStudents();
            model.addAttribute("students", students);
            return "all_students";
        }

        @GetMapping("/add")
        public String showAddForm() {
            return "add_student_form";
        }

        @PostMapping("/add")
        public String saveNewStudent(@ModelAttribute Student newStudent) {
            studentsService.saveOrUpdateStudent(newStudent);
            return "redirect:/students/";
        }

        @GetMapping("/edit/{id}")
        public String showEditForm(@PathVariable int id, Model model) {
            model.addAttribute("student", studentsService.findById(id));
            return "edit_student_form";
        }

        @PostMapping("/edit")
        public String modifyStudent(@ModelAttribute Student modifiedStudent) {
            studentsService.saveOrUpdateStudent(modifiedStudent);
            return "redirect:/students/";
        }

        @GetMapping("/json/{id}")
        @ResponseBody
        public Student showJsonStundent(@PathVariable int id) {
            return studentsService.findById(id);
        }
}
