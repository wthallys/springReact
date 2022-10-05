package com.wthallys.springreact.services;

import com.wthallys.springreact.entities.Sale;
import com.wthallys.springreact.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> findSales(String minimumDate, String maximumDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minimumDate.equals("") ? today.minusDays(365) : LocalDate.parse(minimumDate);
        LocalDate max = maximumDate.equals("") ? today : LocalDate.parse(maximumDate);

        return repository.findSales(min, max, pageable);
    }

}
