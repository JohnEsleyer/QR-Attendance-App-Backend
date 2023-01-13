package dev.johnesleyer.QRBackend.RestAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.johnesleyer.QRBackend.RestAPI.models.Subject;
import dev.johnesleyer.QRBackend.RestAPI.repositories.SubjectRepository;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
	@Autowired
	private SubjectRepository subjectRepository;
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Subject createStudent(@RequestBody Subject subject) {
		
		return subjectRepository.save(subject);
		
	}
	
	@GetMapping("/all")
	public List<Subject> getAllSubjects(){
		return subjectRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Subject getSubjectById(@PathVariable("id") Integer id) {
		return subjectRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Invalid student id: "+id));
	}
	
}
