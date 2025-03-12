package com.henrique.Projeto1.run;

import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;

    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
     public List<Run> findAll(){
        return runRepository.findAll();
    };


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public Optional<Run> findById(@PathVariable Integer id){
        return runRepository.findById(id);
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Run createRun(@RequestBody Run run){

        Integer affectedRows = runRepository.createRun(run);

        if (affectedRows == 0) {
            throw  new ResponseStatusException(HttpStatus.CONFLICT, "CREATION FAILED");
        }
        return runRepository.findById(run.id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    };



    @DeleteMapping("{id}")
    public void deleteRun(@PathVariable Integer id){
        runRepository.deleteRun(id);

    }







    };

