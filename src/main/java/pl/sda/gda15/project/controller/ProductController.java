package pl.sda.gda15.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.gda15.project.service.OrderService;
import pl.sda.gda15.project.service.ProductsService;
import pl.sda.gda15.project.service.UserService;

@Controller
public class ProductController {

    private final UserService userService;
    private final OrderService orderService;
    private final ProductsService productsService;

    public ProductController(UserService userService, OrderService orderService, ProductsService productsService) {
        this.userService = userService;
        this.orderService = orderService;
        this.productsService = productsService;
    }
    @GetMapping("products")
    public String getAllProducts(Model model){
        model.addAttribute("products",productsService.getProducts());
        return "products";
    }
}
