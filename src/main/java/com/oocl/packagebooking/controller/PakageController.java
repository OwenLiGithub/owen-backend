package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Pakage;
import com.oocl.packagebooking.service.PakageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/pakages")
public class PakageController {
    @Autowired
    private PakageService pakageService;

    @GetMapping()
    public ResponseEntity getallPakage() {
        List<Pakage> allPakage =  pakageService.getallPakage();
        return ResponseEntity.status(HttpStatus.OK).body(allPakage);
    }

    @PostMapping()
    public ResponseEntity addPakge(@RequestBody Pakage pakage) {
        pakageService.addPakge(pakage);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping(params = {"status"})
    public ResponseEntity getPakageByStatus(@RequestParam("status")int status){
        List<Pakage> pakages = pakageService.getPakageByStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(pakages);
    }
    @PutMapping("/{id}")
    public ResponseEntity confirmRecipt(@RequestBody Pakage pakage){
        System.out.println(pakage);
        Pakage pk = pakageService.comfrimRecipt(pakage);
        return ResponseEntity.status(HttpStatus.OK).body(pk);
    }
    @PatchMapping("/{id}")
    public ResponseEntity updataStatus(@PathVariable("id") int id,@RequestBody Pakage pakage){
        Pakage pk = pakageService.findPakageById(id);
        pk.setTime(pakage.getTime());
        pk.setStatus(pakage.getStatus());
        Pakage pkg = pakageService.save(pakage);
        return ResponseEntity.status(HttpStatus.OK).body(pkg);
    }


}
