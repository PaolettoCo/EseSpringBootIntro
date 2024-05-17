package com.example.demorepositories.car.repositories;

import com.example.demorepositories.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface Repository extends JpaRepository<Car, UUID> {
}
