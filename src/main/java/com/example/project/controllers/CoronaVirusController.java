package com.example.project.controllers;

import com.example.project.models.CoronaVirus;
import com.example.project.services.corona.CoronaVirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CoronaVirusController {
    @Autowired
    CoronaVirusService coronaVirusService;

    @GetMapping("/corona")
    public List<CoronaVirus> getAllData() throws IOException, InterruptedException {
        return coronaVirusService.fetchVirusData();
    }
}
