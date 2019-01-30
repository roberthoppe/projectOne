package pl.sda.gda15.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.gda15.project.domain.entity.User;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPOJO {
    private UUID orderId;
    List<ProductsPOJO> productsList;
    private User user;

    
}
