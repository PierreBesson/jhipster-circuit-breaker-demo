package com.mycompany.myapp.web.rest.client;

import com.mycompany.myapp.web.rest.dto.FooDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "app1", fallback = App1FooClientFallback.class)
public interface App1FooClient {

    @RequestMapping(value = "/api/foos",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FooDTO> createFoo(FooDTO foo);

    @RequestMapping(value = "/api/foos",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FooDTO> updateFoo(FooDTO foo);

    @RequestMapping(value = "/api/foos",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    List<FooDTO> getAllFoos();

    @RequestMapping(value = "/api/foos/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FooDTO> getFoo(@PathVariable("id") Long id);

    @RequestMapping(value = "/api/foos/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteFoo(@PathVariable("id") Long id);
}

