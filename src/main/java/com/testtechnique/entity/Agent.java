package com.testtechnique.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Agent {
    private String os;
    private Date lasKeepAlive;
    private Date dateAdd;
    private String ip;
    private String name;
    @Id
    private String id;
    private String version;
    @Enumerated(EnumType.STRING)
    private Status status;

}
