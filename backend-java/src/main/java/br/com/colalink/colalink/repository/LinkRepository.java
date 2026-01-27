package br.com.colalink.colalink.repository;

import br.com.colalink.colalink.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity, Long> {
    boolean existsLinkEntityByUrlShortened(String shortCode);
    Optional<LinkEntity> findByUrlShortened(String shortCode);
    @Modifying
    @Query("DELETE FROM LinkEntity linkEntity WHERE linkEntity.dataExpiration < :now")
    int deleteByDataExpirationBefore(@Param("now")LocalDateTime now);

}
