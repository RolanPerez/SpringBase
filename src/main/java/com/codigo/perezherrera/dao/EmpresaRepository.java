package com.codigo.perezherrera.dao;

import com.codigo.perezherrera.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

}
