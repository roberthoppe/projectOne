package pl.sda.gda15.project.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
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

@OneToMany(mappedBy = "user")
    private List<Order> orderList;
}
