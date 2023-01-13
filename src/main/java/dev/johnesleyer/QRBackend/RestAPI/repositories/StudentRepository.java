package dev.johnesleyer.QRBackend.RestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.johnesleyer.QRBackend.RestAPI.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
