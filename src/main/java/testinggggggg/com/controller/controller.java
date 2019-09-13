package testinggggggg.com.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testinggggggg.com.exception.ResourceNotFound;
import testinggggggg.com.model.Student;
import testinggggggg.com.service.ServInterface;

@RestController
@RequestMapping("/home")
public class controller {

	@Autowired
	ServInterface sf;

	Student st;
	
	

	  @RequestMapping("/user")
	  public Principal user(Principal principal) {
	    return principal;
	  }

	  
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .antMatcher("/**")
	      .authorizeRequests()
	        .antMatchers("/", "/login**", "/webjars/**", "/error**")
	        .permitAll()
	      .anyRequest()
	        .authenticated();
	  }
	  
	  
	  
	@PostMapping
	public @ResponseBody Student create(@RequestBody Student stu) {

		return sf.add(stu);

	}

	@GetMapping
	public @ResponseBody List<Student> getDetails() {

		return sf.getAllDetails();
	}

	@GetMapping("/{id}")
	public @ResponseBody Student getDetailsById(@RequestBody @PathVariable(value = "id") int id) {

		return sf.getStudentById(id).orElseThrow(() -> new ResourceNotFound("Student", "id", id));

	}

	@PutMapping("/update/{id}")
	public Student updateStudentById( @PathVariable(value = "id") int id,@RequestBody Student stu) {

		Student st = sf.getStudentById(id).orElseThrow(() -> new ResourceNotFound("Student", "id", id));

		st.setCity(stu.getCity());
		st.setRollNo(stu.getRollNo());
		st.setSname(stu.getSname());
		Student st1 = sf.add(st);

		return st1;

	}
}
