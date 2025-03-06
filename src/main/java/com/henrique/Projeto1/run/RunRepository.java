package com.henrique.Projeto1.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<Run>();


    public List<Run> findAll(){
        return runs;
    }

    public Optional <Run> findById(Integer id){

        return runs.stream().filter(run -> run.id() == id).findFirst();
    }


    public void createRun(Run run){
        runs.add(run);
    }

    public void updateRun(Run run,Integer id) {

        Optional<Run> existRun = findById(id);

        existRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    };

    public void deleteRun(Integer id){
        runs.removeIf(run -> run.id().equals(id) );
    }

    @PostConstruct
    private void init(){

        runs.add(new Run(
                1,
                "Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(45),
                5,
                Location.OUTDOOR));

        runs.add(new Run(
                2,
                "Treadmill Sprint",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                3,
                Location.INDOOR));
    }
}
