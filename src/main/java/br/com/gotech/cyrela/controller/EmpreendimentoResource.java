package br.com.gotech.cyrela.controller;

import br.com.gotech.cyrela.entity.EmpreendimentoEntity;
import br.com.gotech.cyrela.repository.EmpreendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empreendimento")
public class EmpreendimentoResource {

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    @GetMapping
    public List<EmpreendimentoEntity> listar() {
        return empreendimentoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public EmpreendimentoEntity buscar(@PathVariable Long codigo) {
        return empreendimentoRepository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EmpreendimentoEntity cadastrar(@RequestBody EmpreendimentoEntity empreendimento) {
        return empreendimentoRepository.save(empreendimento);
    }

    @PutMapping("/{id}")
    public EmpreendimentoEntity atualizar(@RequestBody EmpreendimentoEntity empreendimento, @PathVariable Long id) {
        empreendimento.setIdEmpreendimento(id);
        return empreendimentoRepository.save(empreendimento);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo) {
        empreendimentoRepository.deleteById(codigo);
    }

}
