package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.Products;
import pl.sda.gda15.project.domain.repository.ProductsRepository;
import pl.sda.gda15.project.model.ProductsPOJO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final OrderService orderService;

    @Autowired
    public ProductsService(ProductsRepository productsRepository, OrderService orderService, UserService userService) {
        this.productsRepository = productsRepository;
        this.orderService = orderService;
    }


    public Products map(ProductsPOJO productsPOJO) {
        return new Products(productsPOJO.getProductsId(),productsPOJO.getProductName(),productsPOJO.getQuantity());
    }

    public ProductsPOJO map(Products products) {
        return new ProductsPOJO(products.getProductId(), products.getProductName(), products.getQuantity());
    }

    public List<ProductsPOJO> getProducts() {
        return productsRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }
}
