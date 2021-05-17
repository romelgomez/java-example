package com.autana.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.autana.repositories.UserRepository;
import com.autana.domains.User;
import com.autana.exceptions.UserNotFoundException;

// tag::hateoas-imports[]
// end::hateoas-imports[]

@RestController
public class UsersController {

    private final UserRepository repository;

    UsersController(UserRepository repository) {
        this.repository = repository;
    }

    // tag::get-single-item[]
    @GetMapping("/users/{id}")
    EntityModel<User> one(@PathVariable Long id) {

        User user = repository.findById(id) //
                .orElseThrow(() -> new UserNotFoundException(id));
        // User user = repository.findByIdWithPhones(id);

        return EntityModel.of(user, //
                linkTo(methodOn(UsersController.class).one(id)).withSelfRel());
    }
    // end::get-single-item[]

}
