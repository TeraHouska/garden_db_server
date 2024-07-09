package cz.terahouska.dto;

import cz.terahouska.constant.Site;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerDTO {

    private Long id;

    private String name;

    private String breed;

    private String description;

    private long price;

    private LocalDate availableFrom;

    private LocalDate availableTo;

    private Boolean overhanging;

    private Boolean resilient;

    private List<Site> sites;
}
