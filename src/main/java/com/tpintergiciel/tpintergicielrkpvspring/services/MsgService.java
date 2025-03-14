package com.tpintergiciel.tpintergicielrkpvspring.services;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import com.tpintergiciel.tpintergicielrkpvspring.classes.Msg;
import com.tpintergiciel.tpintergicielrkpvspring.repository.ClientRepository;
import com.tpintergiciel.tpintergicielrkpvspring.repository.MsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MsgService {
    @Autowired
    private MsgRepository msgRepository;

    public List<Msg> getAllMsg() {
        System.out.println(msgRepository.findAll());
        return msgRepository.findAll();
    }

    public Msg createMsg(Msg msg) {
        return msgRepository.save(msg);
    }


}