package pl.sda.gda15.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.gda15.project.domain.entity.Products;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products, UUID> {
}
