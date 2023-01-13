package dev.johnesleyer.QRBackend.RestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.johnesleyer.QRBackend.RestAPI.models.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
}
