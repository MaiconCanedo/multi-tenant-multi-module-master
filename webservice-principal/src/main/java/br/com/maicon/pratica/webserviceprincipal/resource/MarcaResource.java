package br.com.maicon.pratica.webserviceprincipal.resource;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Marca;
import br.com.maicon.pratica.webserviceprincipal.service.MarcaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("marca")
public class MarcaResource {

    private final MarcaService marcaService;

    public MarcaResource(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Marca marca) {
        Marca marcaSave = marcaService.save(marca);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(marcaSave.getId())
                .toUri()
        ).build();
    }
}
