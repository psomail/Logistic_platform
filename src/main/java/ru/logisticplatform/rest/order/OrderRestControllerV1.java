package ru.logisticplatform.rest.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.logisticplatform.dto.RestMessageDto;
import ru.logisticplatform.dto.order.CreateOrderDto;
import ru.logisticplatform.dto.utils.ObjectMapperUtils;
import ru.logisticplatform.model.RestMessage;
import ru.logisticplatform.model.order.Order;
import ru.logisticplatform.model.user.User;
import ru.logisticplatform.model.user.UserStatus;
import ru.logisticplatform.service.RestMessageService;
import ru.logisticplatform.service.user.UserService;


/**
 * REST controller for {@link Order} connected requests.
 *
 * @author Sergei Perminov
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/orders/")
public class OrderRestControllerV1 {

    private final UserService userService;
    private final RestMessageService restMessageService;

    @Autowired
    public OrderRestControllerV1(UserService userService
                                ,RestMessageService restMessageService) {
        this.userService = userService;
        this.restMessageService = restMessageService;
    }

    @PostMapping(value = "/create/", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<?> createOrder(Authentication authentication, @RequestBody CreateOrderDto createOrderDto){

        if(createOrderDto == null){
            RestMessage restMessage = restMessageService.findByCode("G003");
            RestMessageDto restMessageDto = ObjectMapperUtils.map(restMessage, RestMessageDto.class);
            return new ResponseEntity<RestMessageDto>(restMessageDto, HttpStatus.NOT_FOUND);
        }

        User user = userService.findByUsername(authentication.getName());

        if (user == null || user.getUserStatus() == UserStatus.DELETED) {
            RestMessage restMessage = restMessageService.findByCode("U001");
            RestMessageDto restMessageDto = ObjectMapperUtils.map(restMessage, RestMessageDto.class);
            return new ResponseEntity<RestMessageDto>(restMessageDto, HttpStatus.NOT_FOUND);
        }

        Order order = ObjectMapperUtils.map(createOrderDto, Order.class);

        





        return null;
    }
}
