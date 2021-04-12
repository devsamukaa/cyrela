package br.com.gotech.cyrela.repository;

import br.com.gotech.cyrela.entity.AtividadeAgendadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AtividadeAgendadaRepository extends JpaRepository<AtividadeAgendadaEntity, Long>{

    List<AtividadeAgendadaEntity> findByDataInicio (Date dataInicio);
    List<AtividadeAgendadaEntity> findByDataInicioAAndOcorrencia_Unidade_Bloco_Empreendimento_IdEmpreendimento (Date dataInicio, Long idEmpreendimento);
    List<AtividadeAgendadaEntity> findByDataInicioAndOcorrencia_Unidade_Bloco_Empreendimento_IdEmpreendimento (Date dataInicio, Long idEmpreendimento);
}