package com.example.api_rest_spring.dao;

import com.example.api_rest_spring.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
