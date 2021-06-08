package nl.getandgo.application.controller;


import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.StatisticStoreOrderTurnOverDTO;
import nl.getandgo.application.service.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService service;

    @GetMapping(value = "api/test/order")
    public List<StatisticStoreOrderTurnOverDTO> testmethod(){
        return service.getOrderOverTurnLastHalfYear(10000L);
    }


}
