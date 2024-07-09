package cz.terahouska.entities;

import cz.terahouska.constant.Site;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "flower")
@Getter
@Setter
public class FlowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String breed;

    @Column
    private String description;

    @Column(nullable = false)
    private long price;

    @Column(nullable = false)
    private LocalDate availableFrom;

    @Column(nullable = false)
    private LocalDate availableTo;

    @Column
    private Boolean overhanging;

    @Column
    private Boolean resilient;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Site> sites;
}
