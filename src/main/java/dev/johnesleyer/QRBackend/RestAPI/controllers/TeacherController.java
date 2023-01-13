package dev.johnesleyer.QRBackend.RestAPI.controllers;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.johnesleyer.QRBackend.RestAPI.models.Teacher;
import dev.johnesleyer.QRBackend.RestAPI.repositories.TeacherRepository;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
	@Autowired
	private TeacherRepository teacherRepository;
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Teacher createTeacher(@RequestBody Teacher teacher) {
		//Hash password before storing
		String hashedPassword = BCrypt.hashpw(teacher.getPassword(), BCrypt.gensalt());
		teacher.setPassword(hashedPassword);
		return teacherRepository.save(teacher);
	}
	
	@GetMapping("/all")
	public List<Teacher> getAllTeachers(){
		return teacherRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Teacher getTeacher(@PathVariable int id) {
		return teacherRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("Invalid teacher id: "+id));
	}
}
