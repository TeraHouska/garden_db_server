package cz.terahouska.entities.filters;

import cz.terahouska.constant.ProductType;
import lombok.Data;

@Data
public class ProductTypeFilter {
    private ProductType type;
    private int limit = 20;
}
