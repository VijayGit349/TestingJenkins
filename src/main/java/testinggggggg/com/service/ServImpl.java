
package testinggggggg.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testinggggggg.com.model.Student;
import testinggggggg.com.repo.repo;


@Service(value="studentService")
public class ServImpl implements ServInterface {
	@Autowired
	repo ro;

	@Override
	public Student add(Student stu) {
		// TODO Auto-generated method stub
		return ro.save(stu);
	}

	@Override
	public List<Student> getAllDetails() {
		// TODO Auto-generated method stub
		return ro.findAll();
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		// TODO Auto-generated method stub
		return ro.findById(id);
	}

	@Override
	public Student updateStudentById(int id, Student std) {
		// TODO Auto-generated method stub
		return ro.save(std);
	}

	
}
