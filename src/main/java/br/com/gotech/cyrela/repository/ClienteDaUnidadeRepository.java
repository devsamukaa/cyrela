package br.com.gotech.cyrela.repository;

import br.com.gotech.cyrela.entity.ClienteDaUnidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDaUnidadeRepository extends JpaRepository<ClienteDaUnidadeEntity, Long>{
    
}