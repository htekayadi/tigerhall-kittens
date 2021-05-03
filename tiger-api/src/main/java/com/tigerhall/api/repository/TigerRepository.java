package com.tigerhall.api.repository;

import com.tigerhall.api.model.Tiger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TigerRepository extends JpaRepository<Tiger, Long> {

    List<Tiger> findByNameIgnoreCase(String authorName);

}
