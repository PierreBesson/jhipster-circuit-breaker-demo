package com.mycompany.myapp.web.rest.client;

import com.mycompany.myapp.web.rest.dto.BarDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.inject.Inject;
import java.util.List;

@Component
public class App1BarClientFallback implements App1BarClient {

    private final Logger log = LoggerFactory.getLogger(App1BarClientFallback.class);

    @Override
    public ResponseEntity<BarDTO> createBar(BarDTO foo) {
        log.warn("Triggered fallback for createBar : {}", foo);
        return null;
    }

    @Override
    public ResponseEntity<BarDTO> updateBar(BarDTO foo) {
        log.warn("Triggered fallback for updateBar : {}", foo);
        return null;
    }

    @Override
    public List<BarDTO> getAllBars() {
        log.warn("Triggered fallback for getAllBars");
        return null;
    }

    @Override
    public ResponseEntity<BarDTO> getBar(@PathVariable("id") Long id) {
        log.warn("Triggered fallback for getBar, id: {}", id);
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteBar(@PathVariable("id") Long id) {
        log.warn("Triggered fallback for deleteBar, id: {}", id);
        return null;
    }
}
