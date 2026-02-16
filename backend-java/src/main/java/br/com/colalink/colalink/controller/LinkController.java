package br.com.colalink.colalink.controller;

import br.com.colalink.colalink.dto.request.LinkDtoRequest;
import br.com.colalink.colalink.dto.response.LinkDtoResponse;
import br.com.colalink.colalink.service.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/v1/api/links")
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<LinkDtoResponse> postUrl(@Valid @RequestBody LinkDtoRequest request){
        LinkDtoResponse response = linkService.saveEntity(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{shortCode}")
    @Operation(summary = "Devolve o URL encurtado", description ="")
    public ResponseEntity<Object> getUrl(@PathVariable String shortCode){
        return linkService.findOneEntity(shortCode)
                .map(urlOriginal -> ResponseEntity.status(HttpStatus.FOUND)
                        .location(URI.create(urlOriginal)).build())
                .orElse(ResponseEntity.notFound().build());
    }

}
