package cz.terahouska.entities;

import cz.terahouska.constant.Color;
import cz.terahouska.constant.Site;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/*
Avoided extending ProductEntity
@ElementCollection did not work as intended
some attributes would be redundant
*/

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

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Color> colors;
}
