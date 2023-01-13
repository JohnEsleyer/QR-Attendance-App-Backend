package dev.johnesleyer.QRBackend.RestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import dev.johnesleyer.QRBackend.RestAPI.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
