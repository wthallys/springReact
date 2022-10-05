package com.wthallys.springreact.controllers;


import com.wthallys.springreact.entities.Sale;
import com.wthallys.springreact.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public Page<Sale> findSales(
            @RequestParam(value = "minimumDate", defaultValue = "") String minimumDate,
            @RequestParam(value = "maximumDate", defaultValue = "") String maximumDate,
            Pageable pageable) {
        return service.findSales(minimumDate, maximumDate, pageable);
    }
}
