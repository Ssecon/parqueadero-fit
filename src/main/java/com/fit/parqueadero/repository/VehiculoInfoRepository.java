package com.fit.parqueadero.repository;

import com.fit.parqueadero.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoInfoRepository extends JpaRepository<VehiculoEntity, Integer> {
}
