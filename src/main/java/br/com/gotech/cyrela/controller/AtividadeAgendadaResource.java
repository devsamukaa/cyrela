package br.com.gotech.cyrela.controller;

import br.com.gotech.cyrela.entity.AtividadeAgendadaEntity;
import br.com.gotech.cyrela.entity.DiaAgendamento;
import br.com.gotech.cyrela.entity.UnidadeEntity;
import br.com.gotech.cyrela.helper.DateHelper;
import br.com.gotech.cyrela.repository.AtividadeAgendadaRepository;
import br.com.gotech.cyrela.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;

@RestController
@RequestMapping("/atividade_agendada")
public class AtividadeAgendadaResource {

    @Autowired
    private AtividadeAgendadaRepository atividadeAgendadaRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @GetMapping
    public List<AtividadeAgendadaEntity> listar() {
        return atividadeAgendadaRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public AtividadeAgendadaEntity buscar(@PathVariable Long codigo) {
        return atividadeAgendadaRepository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    @PostMapping
    public AtividadeAgendadaEntity cadastrar(@RequestBody AtividadeAgendadaEntity atividadeAgendada) {

        UnidadeEntity unidade = unidadeRepository.findByIdUnidade(atividadeAgendada.getOcorrencia().getUnidade().getIdUnidade());

        List<AtividadeAgendadaEntity> atividadesDoDia =
                atividadeAgendadaRepository.findByDataInicioAndOcorrencia_Unidade_Bloco_Empreendimento_IdEmpreendimento(
                        atividadeAgendada.getDataInicio(),
                        unidade
                                .getBloco()
                                .getEmpreendimento()
                                .getIdEmpreendimento()
                );

        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(atividadeAgendada.getDataInicio());

        if((atividadesDoDia.size() >= 3)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data informada está indisponível para novos agendamentos nesse empreendimento.");
        }else if(dateCalendar.get(Calendar.DAY_OF_WEEK) == 7 || dateCalendar.get(Calendar.DAY_OF_WEEK) == 1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data informada não pode ser um dia de final de semana. Apenas: seg, ter, qua, qui ou sex.");
        }else {
            return atividadeAgendadaRepository.save(atividadeAgendada);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public AtividadeAgendadaEntity atualizar(@RequestBody AtividadeAgendadaEntity atividadeAgendada, @PathVariable Long id) {
        atividadeAgendada.setIdAtividadeAgendada(id);
        return atividadeAgendadaRepository.save(atividadeAgendada);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo) {
        atividadeAgendadaRepository.deleteById(codigo);
    }

    @GetMapping("/agendamentos_no_dia")
    public List<AtividadeAgendadaEntity> agendamentos_no_dia(@RequestParam(required = false) String dataInicio, @RequestParam(required = false) Long idEmpreendimento) {


        if(dataInicio != null && idEmpreendimento != null) {
            return atividadeAgendadaRepository.findByDataInicioAndOcorrencia_Unidade_Bloco_Empreendimento_IdEmpreendimento(DateHelper.parseDate(dataInicio), idEmpreendimento);
        }else if(dataInicio != null) {
            return atividadeAgendadaRepository.findByDataInicio(DateHelper.parseDate(dataInicio));
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Os parâmetros não foram passados adequadamente");
        }

    }

    @GetMapping("/calendario_agendamento")
    public List<DiaAgendamento> calendario_agendamento(@RequestParam int mes, @RequestParam int ano, @RequestParam Long idEmpreendimento) {

        List<DiaAgendamento> listaDeDias = new ArrayList<DiaAgendamento>();

        if(mes > 12){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Os parâmetros não foram passados adequadamente");
        }

        try{
            Calendar data = new GregorianCalendar(ano, mes == 0 ? 0 : mes -1, 1);
            int daysInMonth = data.getActualMaximum(Calendar.DAY_OF_MONTH);

            List<AtividadeAgendadaEntity> atividadesDoDiaPorEmpreendimento = null;
            String dia;

            for (var i = 1; i <= daysInMonth; i++) {

                dia = i < 10L ? "0"+ i : String.valueOf(i);
                data.setTime(DateHelper.parseDate(dia+"/"+mes+"/"+ano));

                atividadesDoDiaPorEmpreendimento =
                        atividadeAgendadaRepository.findByDataInicioAndOcorrencia_Unidade_Bloco_Empreendimento_IdEmpreendimento(
                                data.getTime(),
                                idEmpreendimento
                        );

                if(atividadesDoDiaPorEmpreendimento.size() >= 3 || data.get(Calendar.DAY_OF_WEEK) == 7 || data.get(Calendar.DAY_OF_WEEK) == 1){
                    listaDeDias.add(new DiaAgendamento(i, false));
                }else{
                    listaDeDias.add(new DiaAgendamento(i, true));
                }

            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Os parâmetros não foram passados adequadamente");
        }

        return listaDeDias;
    }
}
