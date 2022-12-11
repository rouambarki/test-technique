package com.testtechnique.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.testtechnique.dto.AgentDto;
import com.testtechnique.service.AgentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
public class AgentResource {
    public AgentService agentService;
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/agents")
    ResponseEntity<Map<String,List<AgentDto>>> getAllAgents(){
        log.info("get all agents");
        Map<String,List<AgentDto>> agents = agentService.getAll();
        return ResponseEntity.ok().body(agents);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/agent")
    ResponseEntity<AgentDto> createAgent(@RequestBody AgentDto agent) {
        log.info("create new Agent");
        AgentDto agentDto = agentService.createAgent(agent);
        return ResponseEntity.ok().body(agentDto);
    }
    @PutMapping(path = "/v1/{name}")
    ResponseEntity<AgentDto> updateAgent(@RequestBody AgentDto agentDto , @PathVariable String name) throws IOException {
        log.info(" update  Agent ");
        AgentDto agent = agentService.updateAgent(agentDto,name);
        return ResponseEntity.ok().body(agent);
    }
    @DeleteMapping("/v1/{id}")
    ResponseEntity<Void> deleteAgent(@PathVariable String id) {
        log.info("delete Agent");
        agentService.deleteAgent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/count-agent")
    ResponseEntity<Map<String,Integer>> countAgentsByStatus(){
        log.info("count agents");
        Map<String,Integer> agents = agentService.countAgentsByStatus();
        return ResponseEntity.ok().body(agents);
    }





}
