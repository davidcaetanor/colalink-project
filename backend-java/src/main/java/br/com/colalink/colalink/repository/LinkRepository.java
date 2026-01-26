package br.com.colalink.colalink.repository;

import br.com.colalink.colalink.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity, Long> {
    boolean existsLinkEntityByUrlShortened(String shortCode);
}
