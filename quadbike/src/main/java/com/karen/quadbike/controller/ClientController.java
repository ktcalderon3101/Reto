package com.karen.quadbike.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.karen.quadbike.model.Client;
import com.karen.quadbike.service.ClientService;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<Client> obtenerClientCompleta(){
        return clientService.obtenerClientCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Client> obtenerClientId(@PathVariable("id")Integer identificador){
        return clientService.obtenerClientId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client salvarClient(@RequestBody Client client){
        return clientService.salvarClient(client);
    }
}
