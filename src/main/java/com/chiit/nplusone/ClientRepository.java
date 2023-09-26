package com.chiit.nplusone;

import com.chiit.nplusone.model.Client;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //@EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "client-entity-graph")
    List<Client> findByFullNameContaining(String name);
}
