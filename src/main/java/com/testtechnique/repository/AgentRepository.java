package com.testtechnique.repository;

import com.testtechnique.entity.Agent;
import com.testtechnique.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public interface AgentRepository extends JpaRepository<Agent,String> {

    Agent findAgentByName(String name);
    List<Agent> findAgentsByStatus (Status status);




}
