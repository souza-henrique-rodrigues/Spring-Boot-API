package com.henrique.Projeto1.run;



import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RunService {

    private final RunRepository runRepository;
    public RunService (RunRepository runRepository) {
        this.runRepository = runRepository;
    }


    public Optional<Run> findById(Integer id) {

        if (runRepository.findById(id).isEmpty()){
            throw new RunNotFoundException("Resource doesn't exist.");
        }
        return runRepository.findById(id);
    }


    };
