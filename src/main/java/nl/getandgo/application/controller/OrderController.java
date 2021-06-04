package nl.getandgo.application.controller;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.NewOrderDTO;
import nl.getandgo.application.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    /**
     * Place New Order
     * */
    @PostMapping(value = "api/orders")
    public String PlaceNewOrder(@RequestBody NewOrderDTO newOrderDTO){
        return orderService.AddingNewOrder(newOrderDTO);
    }
}
