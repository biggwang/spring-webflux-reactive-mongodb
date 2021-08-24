package com.biggwang.hellowebflux.controller;

import com.biggwang.hellowebflux.entity.InvestmentEntity;
import com.biggwang.hellowebflux.service.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class InvestmentController {

    private final InvestmentService investmentService;

    @GetMapping("/investment")
    public Flux<InvestmentEntity> getInvestment() {
        return investmentService.getInvestmentList();
    }

    @GetMapping("/investment/{userId}")
    public Mono<InvestmentEntity> invest(@PathVariable String userId) {
        return investmentService.invest(userId);
    }

}
