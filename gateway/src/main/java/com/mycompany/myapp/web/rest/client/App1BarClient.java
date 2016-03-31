package com.mycompany.myapp.web.rest.client;

import com.mycompany.myapp.web.rest.dto.BarDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "app1", fallback = App1BarClientFallback.class)
public interface App1BarClient {

    @RequestMapping(value = "/api/bars",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BarDTO> createBar(BarDTO foo);

    @RequestMapping(value = "/api/bars",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BarDTO> updateBar(BarDTO foo);

    @RequestMapping(value = "/api/bars",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    List<BarDTO> getAllBars();

    @RequestMapping(value = "/api/bars/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BarDTO> getBar(@PathVariable("id") Long id);

    @RequestMapping(value = "/api/bars/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteBar(@PathVariable("id") Long id);
}

