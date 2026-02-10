package br.com.colalink.colalink.mapper;

import br.com.colalink.colalink.dto.request.LinkDtoRequest;
import br.com.colalink.colalink.dto.response.LinkDtoResponse;
import br.com.colalink.colalink.entity.LinkEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class LinkMapper {

    public LinkDtoResponse toDto(LinkEntity linkEntity){

        String fullLink = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/v1/api/links")
                .path(linkEntity.getUrlShortened())
                .toUriString();
        
        return new LinkDtoResponse(
                linkEntity.getUrlOriginal(),
                fullLink,
                linkEntity.getDataExpiration()
        );
        
    }

    public LinkEntity toEntity(LinkDtoRequest request){
        LinkEntity entity = new LinkEntity();
        entity.setUrlOriginal(request.urlOriginal());
        return entity;
    }

}
