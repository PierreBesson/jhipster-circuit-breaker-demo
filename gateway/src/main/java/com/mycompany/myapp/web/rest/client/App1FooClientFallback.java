package com.mycompany.myapp.web.rest.client;

import com.mycompany.myapp.web.rest.dto.FooDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class App1FooClientFallback implements App1FooClient {

    private final Logger log = LoggerFactory.getLogger(App1FooClientFallback.class);

    @Override
    public ResponseEntity<FooDTO> createFoo(FooDTO foo) {
        log.warn("Triggered fallback for createFoo : {}", foo);
        return null;
    }

    @Override
    public ResponseEntity<FooDTO> updateFoo(FooDTO foo) {
        log.warn("Triggered fallback for updateFoo : {}", foo);
        return null;
    }

    @Override
    public List<FooDTO> getAllFoos() {
        log.warn("Triggered fallback for getAllFoos");
        return null;
    }

    @Override
    public ResponseEntity<FooDTO> getFoo(@PathVariable("id") Long id) {
        log.warn("Triggered fallback for getFoo, id: {}", id);
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteFoo(@PathVariable("id") Long id) {
        log.warn("Triggered fallback for deleteFoo, id: {}", id);
        return null;
    }
}
