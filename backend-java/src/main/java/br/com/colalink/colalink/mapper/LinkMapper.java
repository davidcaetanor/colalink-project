package br.com.colalink.colalink.mapper;

import br.com.colalink.colalink.dto.request.LinkDtoRequest;
import br.com.colalink.colalink.dto.response.LinkDtoResponse;
import br.com.colalink.colalink.entity.LinkEntity;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper {

    public LinkDtoResponse toDto(LinkEntity linkEntity){
        return new LinkDtoResponse(
                linkEntity.getUrlOriginal(),
                linkEntity.getUrlShortened(),
                linkEntity.getDataExpiration()
        );
    }

    public LinkEntity toEntity(LinkDtoRequest request){
        LinkEntity entity = new LinkEntity();
        entity.setUrlOriginal(request.urlOriginal());
        return entity;
    }

}
