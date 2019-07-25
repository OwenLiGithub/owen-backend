package com.oocl.packagebooking.service;

import com.oocl.packagebooking.dao.PakageRepostitory;
import com.oocl.packagebooking.entity.Pakage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PakageService {
    @Autowired
    private PakageRepostitory pakageRepostitory;
   public List<Pakage> getallPakage(){
       return pakageRepostitory.findAll();
   }
   public void addPakge(Pakage pakage){
       pakageRepostitory.save(pakage);
   }

    public List<Pakage> getPakageByStatus(int status) {
        return pakageRepostitory.findAllPakageByStatus(status);
    }

    public Pakage findPakageById(int id) {
       return pakageRepostitory.findById(id).get();
    }

    public Pakage updataStatus(Pakage pakage) {
       pakage.setStatus(1);
       return  pakageRepostitory.save(pakage);

    }

    public Pakage comfrimRecipt(Pakage pakage) {
        return  pakageRepostitory.save(pakage);

    }

    public Pakage save(Pakage pakage) {
        return  pakageRepostitory.save(pakage);
    }
}
