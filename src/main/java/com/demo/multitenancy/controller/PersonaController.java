package com.demo.multitenancy.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.multitenancy.model.Persona;
import com.demo.multitenancy.model.repository.RepositorioPersona;

import javax.validation.Valid;

/** Simple controller to illustrate templates. */
@RestController
@RequestMapping(value = "/person")
public class PersonaController {

  /** Person repository. */
  @Autowired
  private transient RepositorioPersona repository;

  /**
   * Person retriever.
   * @return Person
   */
  @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
  @ResponseBody public ResponseEntity<?> getPerson(@PathVariable final Long personId) {
    final Persona person = repository.findOne(personId);
    if (person == null) {
      return ResponseEntity.notFound().build();
    }
    final Resource<Persona> resource = new Resource<Persona>(person);
    resource.add(linkTo(methodOn(PersonaController.class).getPerson(personId)).withSelfRel());

    return ResponseEntity.ok(resource);
  }

  /**
   * Person creation.
   * @return Person
   */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody public ResponseEntity<?> savePerson(@RequestBody final Persona person) {
    final Persona persistedPerson = repository.save(person);
    final Resource<Persona> resource = new Resource<Persona>(persistedPerson);
    resource.add(
        linkTo(methodOn(PersonaController.class).getPerson(persistedPerson.getId())).withSelfRel()
    );
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .contentType(MediaType.APPLICATION_JSON)
        .body(resource);
  }

}