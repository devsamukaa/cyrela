package br.com.gotech.cyrela.repository;

import br.com.gotech.cyrela.entity.EmpreendimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpreendimentoRepository extends JpaRepository<EmpreendimentoEntity, Long>{
    
}