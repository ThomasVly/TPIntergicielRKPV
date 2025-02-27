package com.tpintergiciel.tpintergicielrkpvspring.repository;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Msg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MsgRepository extends JpaRepository<Msg, Long> {

    List<Msg> findMsgByExpediteur(String expediteur);

    List<Msg> findMsgByReceveur(String receveur);
}
