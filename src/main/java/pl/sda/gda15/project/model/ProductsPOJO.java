package pl.sda.gda15.project.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsPOJO {
    private UUID productsId;
    private String productName;
    private Integer quantity;


}
