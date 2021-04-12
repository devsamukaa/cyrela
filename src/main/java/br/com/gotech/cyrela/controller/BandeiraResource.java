package br.com.gotech.cyrela.controller;

import br.com.gotech.cyrela.entity.BandeiraEntity;
import br.com.gotech.cyrela.repository.BandeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bandeira")
public class BandeiraResource {

    @Autowired
    private BandeiraRepository bandeiraRepository;

    @GetMapping
    public List<BandeiraEntity> listar() {
        return bandeiraRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public BandeiraEntity buscar(@PathVariable Long codigo) {
        return bandeiraRepository.findById(codigo).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BandeiraEntity cadastrar(@RequestBody BandeiraEntity bandeira) {
        return bandeiraRepository.save(bandeira);
    }

    @PutMapping("/{id}")
    public BandeiraEntity atualizar(@RequestBody BandeiraEntity bandeira, @PathVariable Long id) {
        bandeira.setIdBandeira(id);
        return bandeiraRepository.save(bandeira);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo) {
        bandeiraRepository.deleteById(codigo);
    }

}
