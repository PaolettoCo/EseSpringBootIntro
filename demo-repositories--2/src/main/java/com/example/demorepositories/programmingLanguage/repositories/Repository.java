package com.example.demorepositories.programmingLanguage.repositories;

import com.example.demorepositories.programmingLanguage.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;
@CrossOrigin(origins = {"http://localhost:5050", "http://localhost:8080"})
@RepositoryRestResource
public interface Repository extends JpaRepository<ProgrammingLanguage, UUID> {
}
