package br.com.colalink.colalink.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "link_table")
public class LinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_link")
    private Long idLink;

    @Column(name = "url_original", nullable = false)
    private String urlOriginal;

    @Column(name = "url_shortened", unique = true)
    private String urlShortened;

    @Column(name = "data_expiration", nullable = false)
    private LocalDateTime dataExpiration;
}
