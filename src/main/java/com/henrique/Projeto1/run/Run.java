package com.henrique.Projeto1.run;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;


public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime finishedOn,
        @Positive
        Integer km,
        Location location
        ) {

}