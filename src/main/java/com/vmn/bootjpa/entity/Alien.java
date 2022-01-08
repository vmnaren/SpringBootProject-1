package com.vmn.bootjpa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String tech;
}
