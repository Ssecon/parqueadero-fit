package com.fit.parqueadero.repository;

import com.fit.parqueadero.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoInfoRepository extends JpaRepository<VehiculoEntity, Long> {


    boolean existsByPatente(String patente);

    @Query(nativeQuery = true,value = "SELECT * FROM vehiculos.vehiculo_info vi where vi.PATENTE = :patente")
    Optional<VehiculoEntity> findByPatente(@Param("patente") String patente);


}
