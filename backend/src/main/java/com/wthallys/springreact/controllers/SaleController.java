package com.wthallys.springreact.controllers;


import com.wthallys.springreact.entities.Sale;
import com.wthallys.springreact.services.SaleService;
import com.wthallys.springreact.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public Page<Sale> findSales(
            @RequestParam(value = "minimumDate", defaultValue = "") String minimumDate,
            @RequestParam(value = "maximumDate", defaultValue = "") String maximumDate,
            Pageable pageable) {
        return service.findSales(minimumDate, maximumDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }
}
