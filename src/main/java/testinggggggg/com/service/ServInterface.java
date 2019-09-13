
package testinggggggg.com.service;

import java.util.List;
import java.util.Optional;

import testinggggggg.com.model.Student;



public interface ServInterface {

	public Student add(Student stu);

	public List<Student> getAllDetails();


	Optional<Student> getStudentById(int id);

	Student updateStudentById(int id, Student stu);

}
