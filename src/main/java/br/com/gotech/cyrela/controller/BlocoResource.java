package br.com.gotech.cyrela.controller;

import br.com.gotech.cyrela.entity.BlocoEntity;
import br.com.gotech.cyrela.repository.BlocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/bloco")
public class BlocoResource {

    @Autowired
    private BlocoRepository blocoRepository;

    @GetMapping
    public List<BlocoEntity> listar() {
        return blocoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public BlocoEntity buscar(@PathVariable Long codigo) {
        return blocoRepository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    @PostMapping
    public BlocoEntity cadastrar(@RequestBody BlocoEntity bloco) {
        return blocoRepository.save(bloco);
    }

    @PutMapping("/{id}")
    @Transactional
    public BlocoEntity atualizar(@RequestBody BlocoEntity bloco, @PathVariable Long id) {
        bloco.setIdBloco(id);
        return blocoRepository.save(bloco);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo) {
        blocoRepository.deleteById(codigo);
    }

}
