package com.tigerhall.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@ToString(exclude = "tiger")
@EqualsAndHashCode(exclude = "tiger")
@Entity
@Table(name = "tiger_sighting")
public class TigerSighting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tiger_id", foreignKey = @ForeignKey(name = "FK_TIGER"))
    private Tiger tiger;

    private LocalDateTime seen;

    private String coordinates;
}
