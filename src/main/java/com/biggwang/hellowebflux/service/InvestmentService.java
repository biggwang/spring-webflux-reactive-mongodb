package com.biggwang.hellowebflux.service;

import com.biggwang.hellowebflux.entity.InvestmentEntity;
import com.biggwang.hellowebflux.repository.InvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    public Flux<InvestmentEntity> getInvestmentList() {
        return investmentRepository.findAll();
    }

    public Mono<InvestmentEntity> invest(String userId) {
        return investmentRepository.save(
                InvestmentEntity.builder()
                        .id(userId)
                        .title("hi:" + LocalDateTime.now())
                        .build()
        );
    }

}
