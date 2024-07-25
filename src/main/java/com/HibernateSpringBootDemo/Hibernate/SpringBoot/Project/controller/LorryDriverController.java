package com.HibernateSpringBootDemo.Hibernate.SpringBoot.Project.controller;

import com.HibernateSpringBootDemo.Hibernate.SpringBoot.Project.entity.LorryDriver;
import com.HibernateSpringBootDemo.Hibernate.SpringBoot.Project.service.LorryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class LorryDriverController {

    @Autowired
    private LorryDriverService service;


    @GetMapping("/{id}")
    public ResponseEntity<LorryDriver> getDriverById(@PathVariable Long id){
        Optional<LorryDriver> driver = service.findById(id);
        return driver.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<LorryDriver> getAllDrivers(){
        return service.findAll();
    }

    @PostMapping
    public LorryDriver createDriver(@RequestBody LorryDriver driver) {
        return service.save(driver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LorryDriver> updateDriver(@PathVariable Long id, @RequestBody LorryDriver driverDetails) {
        Optional<LorryDriver> driverOptional = service.findById(id);
        if (driverOptional.isPresent()) {
            LorryDriver driver = driverOptional.get();
            driver.setName(driverDetails.getName());
            driver.setDriverId(driverDetails.getDriverId());
            driver.setContactNumber(driverDetails.getContactNumber());
            driver.setNicNumber(driverDetails.getNicNumber());
            return ResponseEntity.ok(service.save(driver));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        Optional<LorryDriver> driverOptional = service.findById(id);
        if (driverOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
