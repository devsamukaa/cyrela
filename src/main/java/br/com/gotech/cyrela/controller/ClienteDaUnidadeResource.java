package br.com.gotech.cyrela.controller;

import br.com.gotech.cyrela.entity.ClienteDaUnidadeEntity;
import br.com.gotech.cyrela.repository.ClienteDaUnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente_da_unidade")
public class ClienteDaUnidadeResource {

    @Autowired
    private ClienteDaUnidadeRepository clienteDaUnidadeRepository;

    @GetMapping
    public List<ClienteDaUnidadeEntity> listar() {
        return clienteDaUnidadeRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public ClienteDaUnidadeEntity buscar(@PathVariable Long codigo) {
        return clienteDaUnidadeRepository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ClienteDaUnidadeEntity cadastrar(@RequestBody ClienteDaUnidadeEntity clienteDaUnidade) {
        return clienteDaUnidadeRepository.save(clienteDaUnidade);
    }

    @PutMapping("/{id}")
    public ClienteDaUnidadeEntity atualizar(@RequestBody ClienteDaUnidadeEntity clienteDaUnidade, @PathVariable Long id) {
        clienteDaUnidade.setIdClienteDaUnidade(id);
        return clienteDaUnidadeRepository.save(clienteDaUnidade);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo) {
        clienteDaUnidadeRepository.deleteById(codigo);
    }

}
