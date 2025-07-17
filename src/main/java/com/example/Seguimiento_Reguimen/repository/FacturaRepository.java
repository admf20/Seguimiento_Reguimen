package com.example.Seguimiento_Reguimen.repository;

import com.example.Seguimiento_Reguimen.model.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaEntity, Long> {}
