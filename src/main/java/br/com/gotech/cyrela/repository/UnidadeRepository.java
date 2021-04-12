package br.com.gotech.cyrela.repository;

import br.com.gotech.cyrela.entity.UnidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeRepository extends JpaRepository<UnidadeEntity, Long>{

    UnidadeEntity findByIdUnidade(Long idUnidade);

}