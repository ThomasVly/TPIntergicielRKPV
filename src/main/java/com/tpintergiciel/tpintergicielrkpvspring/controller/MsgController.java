package com.tpintergiciel.tpintergicielrkpvspring.controller;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import com.tpintergiciel.tpintergicielrkpvspring.classes.Msg;
import com.tpintergiciel.tpintergicielrkpvspring.services.ClientService;
import com.tpintergiciel.tpintergicielrkpvspring.services.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @PostMapping("/create")
    public Msg createMsg(@RequestBody Msg msg) {
        return msgService.createMsg(msg);
    }

    // Get all users
    @GetMapping("/get")
    public List<Msg> getAllMsg() {
        return msgService.getAllMsg();
    }

    // Get user by ID

}
