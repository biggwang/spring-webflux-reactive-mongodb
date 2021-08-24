package com.biggwang.hellowebflux.repository;

import com.biggwang.hellowebflux.entity.InvestmentEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends ReactiveMongoRepository<InvestmentEntity, String> {
}
