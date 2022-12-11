package com.testtechnique.service;
import com.testtechnique.converter.AgentConverter;
import com.testtechnique.converter.AgentDtoConverter;
import com.testtechnique.dto.AgentDto;
import com.testtechnique.entity.Agent;
import com.testtechnique.entity.Status;
import com.testtechnique.repository.AgentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AgentService {
private final AgentRepository agentRepository;

public Map<String,List<AgentDto>> getAll(){
    List<Agent> agents = agentRepository.findAll();
    Map<String, List<AgentDto>> listMap = new HashMap<>();
    listMap.put("results",agents.stream().map(client -> AgentConverter.newInstance().convert(client)).collect(Collectors.toList()) );
    return listMap;
}
    public AgentDto createAgent(AgentDto agentDto) {
        Agent agent = AgentDtoConverter.newInstance().convert(agentDto);
        Agent savedAgent = agentRepository.save(agent);
        return AgentConverter.newInstance().convert(savedAgent);}
    public AgentDto updateAgent(AgentDto agentDto, String name){
    Agent agent = agentRepository.findAgentByName(name);
    agent.setName(agentDto.getName());
    agent.setId(agentDto.getId());
    agent.setDateAdd(agentDto.getDateAdd());
    agent.setIp(agentDto.getIp());
    agent.setOs(agentDto.getOs());
    agent.setStatus(agentDto.getStatus());
    agent.setLasKeepAlive(agentDto.getLasKeepAlive());
    Agent savedAgent = agentRepository.save(agent);
    return AgentConverter.newInstance().convert(savedAgent);
    }
    public void deleteAgent(String id){
    Agent agent= agentRepository.findById(id).orElse(null);
    agentRepository.delete(agent);
    }
    public  Map<String, Integer> countAgentsByStatus(){
        Map<String, Integer> listStatus = new HashMap<>();
        /** Get Number of agents **/
        Integer total = agentRepository.findAll().size();
        listStatus.put("Total agents", total);
        /** Get Number of agents disconnected **/
        Integer disconnected = agentRepository.findAgentsByStatus(Status.disconnected).size();
        listStatus.put("Disconnected Agents",disconnected);
        /** Get Number of agents disconnected active **/
        Integer active = agentRepository.findAgentsByStatus(Status.active).size();
        listStatus.put("Active agents",active);
        /** Get Number of agents disconnected pending **/
        Integer pending = agentRepository.findAgentsByStatus(Status.pending).size();
        listStatus.put("Pending Agents",pending);
        /** Get Number of agents never  **/
        Integer never= agentRepository.findAgentsByStatus(Status.never_connected).size();
        listStatus.put("Never connected agents",never);

        return listStatus;
    }

}
