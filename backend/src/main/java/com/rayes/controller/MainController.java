package com.rayes.controller;

import com.rayes.service.RandomSequencesGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    RandomSequencesGenerator generator;

    @GetMapping("/generate/{length}")
    public ArrayList<Set<Integer>> generateSequences(@PathVariable Integer length) {
        return generator.generateAnArrayOfFiveSequences(length);
    }

}
