package pl.sda.gda15.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserPOJO {

    private UUID userId;

    private String companyName;
    private Integer NIP;
    private String adres;
    private String zipCode;
    private String city;
    private String country;
    private String name;
    private String surname;
    private String email;
    private List<OrderPOJO> orderList;
}
