package org.fordsworth.StudentManagement.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import org.fordsworth.StudentManagement.Entity.Student;
import org.fordsworth.StudentManagement.Entity.StudentRepository;

/*
  All the business logic is done here and it @inject the repository
 */

@ApplicationScoped
public class StudentService {
  @Inject public StudentRepository studentRepository;

  public void addStudent(Student student) {
    this.studentRepository.persist(student);
  }

  public void allStudents(List<Student> allStudents) {
    if (!allStudents.isEmpty())
      for (Student student : allStudents)
        this.studentRepository.persist(student);
  }

  public List<Student> getAllStudents() {
    return studentRepository.listAllStudents();
  }

  public Student findStudentById(Long id) {
    return studentRepository.getStudentById(id);
  }

  public boolean deleteStudentById(Long id) {
    Student student = studentRepository.findById(id);
    if (student != null) {
      studentRepository.deleteStudentById(id);
      return true;
    }
    return false;
  }

}
