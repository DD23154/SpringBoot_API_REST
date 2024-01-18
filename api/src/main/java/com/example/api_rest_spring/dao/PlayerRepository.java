package com.example.api_rest_spring.dao;

import com.example.api_rest_spring.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
