package io.github.cleanarch.springdata.specificationexecutor.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface CustomerRepository
    extends JpaSpecificationExecutor<Customer>, JpaRepository<Customer, Long> {}
