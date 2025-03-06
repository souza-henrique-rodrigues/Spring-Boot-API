package com.henrique.Projeto1.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;

    }

    @GetMapping("")
     public List<Run> findAll(){
        return runRepository.findAll();
    };

    @GetMapping("/{id}")
    public Run findById(@PathVariable Integer id) {

        Optional <Run> run = runRepository.findById(id);

        if (run.isEmpty()){
            throw new RunNotFoundException();
        };
        return run.get();

    };

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updateRun(@RequestBody Run run, @PathVariable Integer id){
        runRepository.updateRun(run, id);

    };

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteRun(@PathVariable  Integer id){
        runRepository.deleteRun(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createRun(@RequestBody Run run){

        runRepository.createRun(run);


    }









}
