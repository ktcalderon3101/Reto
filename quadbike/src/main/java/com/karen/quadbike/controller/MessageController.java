package com.karen.quadbike.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.karen.quadbike.model.Message;
import com.karen.quadbike.service.MessageService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/all")
    public List<Message> obtenerMessageCompleta(){
        return messageService.obtenerMessageCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Message> obtenerMessageId(@PathVariable("id")Integer identificador){
        return messageService.obtenerMessageId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message salvarMessage(@RequestBody Message message){
        return messageService.salvarMessage(message);
    }
}
