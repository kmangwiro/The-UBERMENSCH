package org.fordsworth.StudentManagement.Controller;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.resteasy.reactive.jackson.SecureField;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fordsworth.StudentManagement.Entity.Student;
import org.fordsworth.StudentManagement.Resources.StudentService;

import java.net.URI;

@Path("/students")
public class StudentResource {

  @Inject
  StudentService studentService;

  // Field names must match template names (without .html)
  @Inject Template students;         // maps to templates/students.html
  @Inject Template addStudent;       // maps to templates/addStudent.html
  @Inject Template studentDetails;   // maps to templates/studentDetails.html



  // List all students
  @GET
  @Produces(MediaType.TEXT_HTML)
  public TemplateInstance renderStudents() {
    return students.data("students", studentService.getAllStudents());
  }

  // Render add-student form
  @GET
  @Path("/add")
  @Produces(MediaType.TEXT_HTML)
  public TemplateInstance renderAddStudent() {
    return addStudent.instance();
  }

  // Handle add-student form submission
  @POST
  @Path("/add")
  @Transactional
  public Response addStudentForm(@FormParam("name") String name,
                                 @FormParam("age") int age) {
    Student student = new Student();
    student.setName(name);
    student.setAge(age);
    studentService.addStudent(student);
    return Response.seeOther(URI.create("/students")).build();
  }

  // View single student
  @GET
  @Path("/{id}")
  @Produces(MediaType.TEXT_HTML)
  public TemplateInstance viewStudent(@PathParam("id") long id) {
    Student student = studentService.findStudentById(id);
    return studentDetails.data("student", student);
  }

  // Delete student
  @GET
  @Path("/delete/{id}")
  @Transactional
  public Response deleteStudent(@PathParam("id") Long id) {
    studentService.deleteStudentById(id);
    return Response.seeOther(URI.create("/students")).build();
  }
}
