package dev.johnesleyer.QRBackend.RestAPI;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Student createStudent(@RequestBody Student student) {
		
		//Hash password before storing
		String hashedPassword = BCrypt.hashpw(student.getPassword(), BCrypt.gensalt());
		student.setPassword(hashedPassword);
		return studentRepository.save(student);
		
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
}
