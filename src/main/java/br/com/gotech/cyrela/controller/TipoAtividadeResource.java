package br.com.gotech.cyrela.controller;

import br.com.gotech.cyrela.entity.TipoAtividadeEntity;
import br.com.gotech.cyrela.repository.TipoAtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_atividade")
public class TipoAtividadeResource {

    @Autowired
    private TipoAtividadeRepository tipoAtividadeRepository;

    @GetMapping
    public List<TipoAtividadeEntity> listar() {
        return tipoAtividadeRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public TipoAtividadeEntity buscar(@PathVariable Long codigo) {
        return tipoAtividadeRepository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TipoAtividadeEntity cadastrar(@RequestBody TipoAtividadeEntity tipoAtividade) {
        return tipoAtividadeRepository.save(tipoAtividade);
    }

    @PutMapping("/{id}")
    public TipoAtividadeEntity atualizar(@RequestBody TipoAtividadeEntity tipoAtividade, @PathVariable Long id) {
        tipoAtividade.setIdTipoAtividade(id);
        return tipoAtividadeRepository.save(tipoAtividade);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo) {
        tipoAtividadeRepository.deleteById(codigo);
    }

}
