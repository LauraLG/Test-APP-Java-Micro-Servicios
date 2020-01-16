
package com.sboot.test.service.controller;

import com.sboot.test.service.model.Model;
import com.sboot.test.service.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ModelController")
public class ModelController {

    @Autowired
    ModelRepository entityRepository;

    /**
     *
     * @return ResponseEntity<?>
     */
    @RequestMapping("/models")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEntities() {
        Iterable<Model> models = entityRepository.findAll();
        return new ResponseEntity<Iterable<Model>>(models, HttpStatus.OK);
    }

}
