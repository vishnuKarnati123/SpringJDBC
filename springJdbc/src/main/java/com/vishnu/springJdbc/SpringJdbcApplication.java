package com.vishnu.springJdbc;

import com.vishnu.springJdbc.model.Student;
import com.vishnu.springJdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		System.out.println("Inside main method");
		Student s = context.getBean(Student.class);
		s.setRollno(104);
		s.setName("Bishnu");
		s.setMarks(70);


		StudentService studentService = context.getBean(StudentService.class);
		studentService.addStudent(s);
		System.out.println(studentService.getStudents());

	}

}
