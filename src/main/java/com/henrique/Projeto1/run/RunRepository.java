package com.henrique.Projeto1.run;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.sql.Types;
import java.util.List;
import java.util.Optional;


@Repository
public class RunRepository {

    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    };

    public List<Run> findAll(){
        return jdbcClient.sql("select * from Run").query(Run.class).list();
    }


    public Optional<Run> findById(Integer id){
        return jdbcClient.sql("SELECT id,title,started_on,finished_on,km,location FROM Run WHERE id = :id").
                param("id",id).
                query(Run.class).
                optional();
    };

    public Integer createRun(Run run){
        return jdbcClient.sql("INSERT INTO Run(id,title,started_on,finished_on,km,location)  VALUES(:id, :title, :started_on, :finished_on, :km, :location)").
                param("id", run.id(), Types.INTEGER).
                param("title", run.title(), Types.VARCHAR).
                param("started_on", run.startedOn(), Types.TIMESTAMP).
                param("finished_on",run.finishedOn(), Types.TIMESTAMP).
                param("km", run.km(), Types.INTEGER).
                param("location", run.location(), Types.VARCHAR).update();
        };


    public void deleteRun(Integer id){
        Optional<Run> resourceId = findById(id);
        jdbcClient.sql("DELETE FROM Run WHERE id = :id").param("id", id).update();
        }


    public Optional<Run> updateRun(Run run, Integer id){
        findById(run.id());
        jdbcClient.sql("UPDATE Run SET title = :title, started_on = :started_on, finished_on = :finished_on, km = :km, location = :location WHERE id = :id").
                param("id", id).
                param("title", run.title(), Types.VARCHAR).
                param("started_on", run.startedOn(), Types.TIMESTAMP).
                param("finished_on",run.finishedOn(), Types.TIMESTAMP).
                param("km", run.km(), Types.INTEGER).
                param("location", run.location(), Types.VARCHAR).update();
        return findById(id);

    };

    };

