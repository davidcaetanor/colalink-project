package br.com.colalink.colalink.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record LinkDtoRequest(
       @NotBlank @URL String urlOriginal
) {
}
