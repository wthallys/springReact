package com.wthallys.springreact.repositories;

import com.wthallys.springreact.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
