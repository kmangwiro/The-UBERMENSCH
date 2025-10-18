package org.fordsworth.StudentManagement.Entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class StudentRepository implements PanacheRepository<Student> {

  public void addStudents(List<Student> studentList) {
    if (!studentList.isEmpty())
      for (Student student : studentList)
        this.persist(student);
  }

  public void addStudent(Student student) {
    persist(student);
    System.out.println("Student has been added : " + student);
  }

  public List<Student> listAllStudents() {
    return listAll();
  }

  public Student getStudentById(long id) {
    return findById(id);
  }

  public void deleteStudentById(long id) {
    System.out.println("Student has been deleted : " + id);
    deleteById(id);
  }
}
