package com.testtechnique.dto;

import com.testtechnique.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentDto {
    private String os;
    private Date lasKeepAlive;
    private Date dateAdd;
    private String ip;
    private String name;

    private String id;
    private String version;
    @Enumerated(EnumType.STRING)
    private Status status;

}
