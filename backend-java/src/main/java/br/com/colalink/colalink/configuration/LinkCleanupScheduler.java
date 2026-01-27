package br.com.colalink.colalink.configuration;

import br.com.colalink.colalink.repository.LinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@Slf4j
public class LinkCleanupScheduler {
    private final LinkRepository linkRepository;

    public LinkCleanupScheduler(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Transactional
    @Scheduled(fixedRate = 43200000) // milisegundos = 12 horas
    public void execute(){
        LocalDateTime now = LocalDateTime.now();
        int totalDeletedLinks = linkRepository.deleteByDataExpirationBefore(now);
        if (totalDeletedLinks > 0){
            log.info("Limpeza concluída: {} links removidos.", totalDeletedLinks);
        } else {
            log.info("Limpeza concluída, nenhum link foi removido!");
        }
    }
}
