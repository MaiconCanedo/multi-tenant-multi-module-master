package br.com.maicon.pratica.databasecontroller.resource;

import br.com.maicon.pratica.databasecontroller.model.dto.BancoDeDadosDTO;
import br.com.maicon.pratica.databasecontroller.model.entity.BancoDeDados;
import br.com.maicon.pratica.databasecontroller.model.exception.NoContentException;
import br.com.maicon.pratica.databasecontroller.model.service.BancoDeDadosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bancodedados")
public class BancoDeDadosResource {

    private BancoDeDadosService bancoDeDadosService;

    public BancoDeDadosResource(BancoDeDadosService bancoDeDadosService) {
        this.bancoDeDadosService = bancoDeDadosService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<BancoDeDadosDTO> findById(@PathVariable("id") String id) {
        BancoDeDadosDTO bancoDeDadosDTO = bancoDeDadosService.findById(id)
                .map(BancoDeDadosDTO::new)
                .orElseThrow(() -> new NoContentException("Usuário não cadastrado."));
        return ResponseEntity.ok(bancoDeDadosDTO);
    }

    @GetMapping("qualquer")
    public ResponseEntity<BancoDeDadosDTO> finAny() {
        BancoDeDadosDTO bancoDeDadosDTO = bancoDeDadosService.findAny()
                .map(BancoDeDadosDTO::new)
                .orElseThrow(() -> new NoContentException("Nenhum usuário cadastrado"));
        return ResponseEntity.ok(bancoDeDadosDTO);
    }

    @GetMapping
    public ResponseEntity<List<BancoDeDadosDTO>> findAll() {
        List<BancoDeDados> bancosDeDados = bancoDeDadosService.findAll();
        if (bancosDeDados.isEmpty())
            throw new NoContentException("Nenhum cadastro encontrado");
        return ResponseEntity.ok(bancosDeDados.stream()
                .map(BancoDeDadosDTO::new)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody BancoDeDadosDTO bancoDeDadosDTO) {
        BancoDeDados bancoDeDados = bancoDeDadosService.save(BancoDeDados.of(bancoDeDadosDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(bancoDeDados.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
