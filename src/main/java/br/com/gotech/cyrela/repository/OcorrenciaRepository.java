package br.com.gotech.cyrela.repository;

import br.com.gotech.cyrela.entity.OcorrenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<OcorrenciaEntity, Long>{
    
}