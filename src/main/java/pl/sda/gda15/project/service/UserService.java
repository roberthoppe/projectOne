package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.User;
import pl.sda.gda15.project.domain.repository.UserRepository;
import pl.sda.gda15.project.model.UserPOJO;

import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final OrderService orderService;

    @Autowired
    public UserService(UserRepository userRepository, OrderService orderService) {
        this.userRepository = userRepository;
        this.orderService = orderService;
    }
    public User map(UserPOJO userPOJO){
        User user = new User(userPOJO.getUserId(),userPOJO.getCompanyName(),userPOJO.getNIP(),userPOJO.getAdres(),userPOJO.getZipCode(),
                userPOJO.getCity(),userPOJO.getCountry(),userPOJO.getName(),userPOJO.getSurname(),userPOJO.getEmail(),null);
        user.setOrderList(userPOJO.getOrderList().stream().map(orderService::map).collect(Collectors.toList()));
        return user;
    }
    public UserPOJO map (User user){
        UserPOJO userPOJO = new UserPOJO(user.getUserId(),user.getCompanyName(),user.getNIP(),user.getAdres(),user.getZipCode(),user.getCity(),
                user.getCountry(),user.getName(),user.getSurname(),user.getEmail(),null);
        userPOJO.setOrderList(user.getOrderList().stream().map(orderService::map).collect(Collectors.toList()));
        return userPOJO;

    }

}
