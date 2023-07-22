package ru.job4j.accidents.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;
import ru.job4j.accidents.repository.AccidentJdbcTemplate;
import ru.job4j.accidents.repository.AccidentMem;
import ru.job4j.accidents.repository.AccidentTypeMem;

import java.util.List;

@Service
public class AccidentService implements IAccidentService {

    private final AccidentMem memory;
    private final AccidentJdbcTemplate accidentsRepostiory;

    @Autowired
    public AccidentService(AccidentMem memory, AccidentTypeMem memoryType, AccidentJdbcTemplate accidentsRepostiory) {
        this.memory = memory;

        this.accidentsRepostiory = accidentsRepostiory;
    }

    @Override
    public void create(Accident accident) {
        accidentsRepostiory.save(accident);
    }

    @Override
    public List<Accident> findAll() {
        /*return (List<Accident>) accidentsRepostiory.findAll();*/
        return accidentsRepostiory.getAll();
        /*return this.memory.getAll();*/
    }

    @Override
    public List<AccidentType> findAllTypes() {
        return memory.getAllTypes();
    }

    @Override
    public List<Rule> findAllRules() {
        return memory.getAllRules();
    }

   /* @Override
    public void create(Accident accident) {
        memory.create(accident);
    }*/

    @Override
    public Accident update(Accident accident) {
        return memory.update(accident);
    }

    @Override
    public Accident getById(int id) {
        return memory.findById(id);
    }
}
