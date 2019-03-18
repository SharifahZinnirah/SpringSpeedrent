package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
   private static Map<String, Home> HomeRepo = new HashMap<>();
   static {
      Home hilux = new Home();
      hilux.setname("Hilux");
      hilux.setmanufacturer("Toyota");
      HomeRepo.put(hilux.getname(), hilux);
      
      Home sonata = new Home();
      sonata.setname("Sonata");
      sonata.setmanufacturer("Hyundai");
      HomeRepo.put(sonata.getname(), sonata);
   }
   @RequestMapping(value = "/hello")
   public ResponseEntity<Object> getHome() {
      return new ResponseEntity<>(HomeRepo.values(), HttpStatus.OK);
   }
}