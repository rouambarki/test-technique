package com.testtechnique.converter;

import com.testtechnique.dto.AgentDto;
import com.testtechnique.entity.Agent;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
@Data(staticConstructor = "newInstance")

public class AgentConverter implements Converter<Agent, AgentDto> {
    @Override
    public AgentDto convert(Agent agent) {
        if (Objects.isNull(agent)) {
            return null;
        }

        return AgentDto.builder()
                .id(agent.getId())
                .os(agent.getOs())
                .ip(agent.getIp())
                .name(agent.getName())
                .dateAdd(agent.getDateAdd())
                .lasKeepAlive(agent.getLasKeepAlive())
                .version(agent.getVersion())
                .status(agent.getStatus())
                .build();
    }

    }
