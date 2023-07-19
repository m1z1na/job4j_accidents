package ru.job4j.accidents.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;
import ru.job4j.accidents.repository.AccidentMem;
import ru.job4j.accidents.repository.AccidentTypeMem;

import java.util.List;

@Service
public class AccidentService implements IAccidentService {

    private final AccidentMem memory;

    @Autowired
    public AccidentService(AccidentMem memory, AccidentTypeMem memoryType) {
        this.memory = memory;
    }


    @Override
    public List<Accident> findAll() {
        return this.memory.getAll();
    }

    @Override
    public List<AccidentType> findAllTypes() {
        return memory.getAllTypes();
    }

    @Override
    public List<Rule> findAllRules() {
        return memory.getAllRules();
    }

    @Override
    public void create(Accident accident) {
        memory.create(accident);
    }

    @Override
    public void update(Accident accident) {
        memory.update(accident);
    }

    @Override
    public Accident getById(int id) {
        return memory.findById(id);
    }
}
