package br.com.maicon.pratica.webserviceprincipal.resource;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import br.com.maicon.pratica.webserviceprincipal.model.exception.BadRequestExecption;
import br.com.maicon.pratica.webserviceprincipal.model.exception.NoContentException;
import br.com.maicon.pratica.webserviceprincipal.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("carro")
public class CarroResource {

    private CarroService carroService;

    public CarroResource(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Carro> findById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(carroService.findById(id)
                    .orElseThrow(() -> new NoContentException("Nenhum carro encontrado!")));
        } catch (CannotCreateTransactionException e) {
            throw new BadRequestExecption("Usuário não cadastrado!");
        }
    }

    @GetMapping
    public ResponseEntity<List<Carro>> findAll(@RequestBody Carro carro) {
        try {
            List<Carro> carros = carroService.findAll(carro);
            if (carros.isEmpty())
                throw new NoContentException("Nenhum carro encontrado!");
            return ResponseEntity.ok(carros);
        } catch (CannotCreateTransactionException e) {
            throw new BadRequestExecption("Usuário não cadastrado!");
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Carro carro) {
        Carro carroSave = carroService.save(carro);
        if (carroSave == null)
            throw new BadRequestExecption("carro não salvo");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(carroSave.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
