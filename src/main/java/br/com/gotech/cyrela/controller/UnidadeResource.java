package br.com.gotech.cyrela.controller;

import br.com.gotech.cyrela.entity.UnidadeEntity;
import br.com.gotech.cyrela.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/unidade")
public class UnidadeResource {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @GetMapping
    public List<UnidadeEntity> listar() {
        return unidadeRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public UnidadeEntity buscar(@PathVariable Long codigo) {
        return unidadeRepository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    @PostMapping
    public UnidadeEntity cadastrar(@RequestBody UnidadeEntity bloco) {
        return unidadeRepository.save(bloco);
    }

    @PutMapping("/{id}")
    @Transactional
    public UnidadeEntity atualizar(@RequestBody UnidadeEntity bloco, @PathVariable Long id) {
        bloco.setIdUnidade(id);
        return unidadeRepository.save(bloco);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo) {
        unidadeRepository.deleteById(codigo);
    }

}
