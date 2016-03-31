package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.web.rest.client.App1FooClient;
import com.mycompany.myapp.web.rest.dto.FooDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing Foo2.
 */
@RestController
@RequestMapping("/api/app1")
public class FooResource {

    private final Logger log = LoggerFactory.getLogger(FooResource.class);
    @Inject
    private App1FooClient app1FooClient;
    /**
     * POST  /foos : Create a new foo.
     *
     * @param foo the foo to create
     * @return the ResponseEntity with status 201 (Created) and with body the new foo, or with status 400 (Bad Request) if the foo has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/foos",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<FooDTO> createFoo(@RequestBody FooDTO foo) throws URISyntaxException {
        log.debug("REST request to save Foo : {}", foo);
        return app1FooClient.createFoo(foo);
    }

    /**
     * PUT  /foos : Updates an existing foo.
     *
     * @param foo the foo to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated foo,
     * or with status 400 (Bad Request) if the foo is not valid,
     * or with status 500 (Internal Server Error) if the foo couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/foos",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<FooDTO> updateFoo(@RequestBody FooDTO foo) throws URISyntaxException {
        log.debug("REST request to update Foo : {}", foo);
        return app1FooClient.updateFoo(foo);
    }

    /**
     * GET  /foos : get all the foos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of foo2S in body
     */
    @RequestMapping(value = "/foos",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<FooDTO> getAllFoos() {
        log.debug("REST request to get all Foos");
        return app1FooClient.getAllFoos();
    }

    /**
     * GET  /foos/:id : get the "id" foo.
     *
     * @param id the id of the fooDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the foo2DTO, or with status 404 (Not Found)
    */
    @RequestMapping(value = "/foos/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<FooDTO> getFoo(@PathVariable Long id) {
        log.debug("REST request to get Foo : {}", id);
        return app1FooClient.getFoo(id);
    }

    /**
     * DELETE  /foos/:id : delete the "id" foo.
     *
     * @param id the id of the foo to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/foos/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteFoo(@PathVariable Long id) {
        log.debug("REST request to delete Foo : {}", id);
        return app1FooClient.deleteFoo(id);
    }
}
