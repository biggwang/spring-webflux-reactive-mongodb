package com.biggwang.hellowebflux.controller;

import com.biggwang.hellowebflux.HellowebfluxApplication;
import com.biggwang.hellowebflux.entity.InvestmentEntity;
import com.biggwang.hellowebflux.repository.InvestmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@SpringBootTest(classes = HellowebfluxApplication.class)
class InvestmentControllerTest {

    @Autowired
    private WebClient webClient;
    @Autowired
    private InvestmentRepository investmentRepository;

    @Test
    void getInvestment() {
        investmentRepository.save(
                InvestmentEntity.builder()
                        .id("gogo")
                        .title("what?")
                        .build()
        );
        Flux<InvestmentEntity> investments =  webClient
                .get()
                .uri("http://localhost:5000/investment")
                .retrieve()
                .bodyToFlux(InvestmentEntity.class);
        investments.subscribe(investmentEntity -> {
            log.warn("### investment:{}", investmentEntity.toString());
        });
    }
}