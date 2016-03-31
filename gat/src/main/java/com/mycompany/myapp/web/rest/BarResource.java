package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.web.rest.client.App1BarClient;
import com.mycompany.myapp.web.rest.dto.BarDTO;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Bar.
 */
@RestController
@RequestMapping("/api/app1")
public class BarResource {

    private final Logger log = LoggerFactory.getLogger(BarResource.class);

    @Inject
    private App1BarClient app1BarClient;
    /**
     * POST  /bars : Create a new bar.
     *
     * @param bar the bar to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bar, or with status 400 (Bad Request) if the bar has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/bars",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<BarDTO> createBar(@RequestBody BarDTO bar) throws URISyntaxException {
        log.debug("REST request to save Bar : {}", bar);
        return app1BarClient.createBar(bar);
    }

    /**
     * PUT  /bars : Updates an existing bar.
     *
     * @param bar the bar to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bar,
     * or with status 400 (Bad Request) if the bar is not valid,
     * or with status 500 (Internal Server Error) if the bar couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/bars",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<BarDTO> updateBar(@RequestBody BarDTO bar) throws URISyntaxException {
        log.debug("REST request to update Bar : {}", bar);
        return app1BarClient.updateBar(bar);
    }

    /**
     * GET  /bars : get all the bars.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bars in body
     */
    @RequestMapping(value = "/bars",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<BarDTO> getAllBars() {
        log.debug("REST request to get all Bars");
        return app1BarClient.getAllBars();
    }

    /**
     * GET  /bars/:id : get the "id" bar.
     *
     * @param id the id of the bar to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bar, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/bars/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<BarDTO> getBar(@PathVariable Long id) {
        log.debug("REST request to get Bar : {}", id);
        return app1BarClient.getBar(id);
    }

    /**
     * DELETE  /bars/:id : delete the "id" bar.
     *
     * @param id the id of the bar to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/bars/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteBar(@PathVariable Long id) {
        log.debug("REST request to delete Bar : {}", id);
        return app1BarClient.deleteBar(id);
    }

}
