package br.com.colalink.colalink.dto.response;

import java.time.LocalDateTime;

public record LinkDtoResponse(
        String urlOriginal,
        String urlShortened,
        LocalDateTime dataExpiration) {
}
