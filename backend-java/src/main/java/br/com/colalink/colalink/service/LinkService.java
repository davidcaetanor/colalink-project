package br.com.colalink.colalink.service;

import br.com.colalink.colalink.dto.request.LinkDtoRequest;
import br.com.colalink.colalink.dto.response.LinkDtoResponse;
import br.com.colalink.colalink.entity.LinkEntity;
import br.com.colalink.colalink.mapper.LinkMapper;
import br.com.colalink.colalink.repository.LinkRepository;
import br.com.colalink.colalink.utils.ShortCodeGenerator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class LinkService {
    private final LinkRepository linkRepository;
    private final LinkMapper linkMapper;
    private final ShortCodeGenerator shortCodeGenerator;

    public LinkService(LinkRepository linkRepository, LinkMapper linkMapper, ShortCodeGenerator shortCodeGenerator) {
        this.linkRepository = linkRepository;
        this.linkMapper = linkMapper;
        this.shortCodeGenerator = shortCodeGenerator;
    }

    public String createShortenedCode() {
        String shortCode;
        do {
            shortCode = shortCodeGenerator.execute(7);
        } while (linkRepository.existsLinkEntityByUrlShortened(shortCode));
        return shortCode;
    }

    @Transactional
    public LinkDtoResponse saveEntity(LinkDtoRequest request){
        LinkEntity linkEntity = linkMapper.toEntity(request);
        linkEntity.setUrlShortened(createShortenedCode());
        linkEntity.setDataExpiration(LocalDateTime.now().plusDays(1));
        LinkEntity savedEntity = linkRepository.save(linkEntity);
        return linkMapper.toDto(savedEntity);
    }


}
