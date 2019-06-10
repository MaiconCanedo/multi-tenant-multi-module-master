package br.com.maicon.pratica.webserviceprincipal.resource;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import br.com.maicon.pratica.webserviceprincipal.model.exception.BadRequestExecption;
import br.com.maicon.pratica.webserviceprincipal.model.exception.NoContentException;
import br.com.maicon.pratica.webserviceprincipal.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
