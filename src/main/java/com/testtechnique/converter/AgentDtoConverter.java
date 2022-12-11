package com.testtechnique.converter;

import com.testtechnique.dto.AgentDto;
import com.testtechnique.entity.Agent;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
@Data(staticConstructor = "newInstance")

public class AgentDtoConverter implements Converter<AgentDto, Agent> {
@Override
public Agent convert(AgentDto agentDto) {
        if(Objects.isNull(agentDto)){
        return null;
        }
        return Agent.builder()
        .id(agentDto.getId())
        .os(agentDto.getOs())
        .ip(agentDto.getIp())
        .name(agentDto.getName())
        .dateAdd(agentDto.getDateAdd())
        .lasKeepAlive(agentDto.getLasKeepAlive())
        .version(agentDto.getVersion())
        .status(agentDto.getStatus())
        .build();
        }
}
