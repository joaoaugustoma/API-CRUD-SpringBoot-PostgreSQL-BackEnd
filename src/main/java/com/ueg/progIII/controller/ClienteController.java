package com.ueg.progIII.controller;

import com.ueg.progIII.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "api/v1/cliente" )
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
}
