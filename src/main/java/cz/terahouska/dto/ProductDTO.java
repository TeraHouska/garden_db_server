package cz.terahouska.dto;

import cz.terahouska.constant.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private long id;

    private String name;

    private ProductType type;

    private String breed;

    private String description;

    private long price;

    private boolean pricePerKilo;

    private LocalDate availableFrom;

    private LocalDate availableTo;
}
