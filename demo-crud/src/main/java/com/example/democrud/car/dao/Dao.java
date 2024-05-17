package com.example.democrud.car.dao;

import com.example.democrud.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface Dao extends JpaRepository<Car, UUID> {


}
