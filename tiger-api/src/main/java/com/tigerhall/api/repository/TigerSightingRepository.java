package com.tigerhall.api.repository;

import com.tigerhall.api.model.TigerSighting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TigerSightingRepository extends JpaRepository<TigerSighting, Long> {

    List<TigerSighting> findAllByTigerIdOrderBySeenDesc(Long tigerId);
}
