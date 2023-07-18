package ru.job4j_accidents.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j_accidents.repository.AccidentMem;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentService implements IAccidentService {

    private final AccidentMem memory;

    @Autowired
    public AccidentService(AccidentMem memory) {
        this.memory = memory;
    }


    @Override
    public List<Accident> findAll() {
        return new ArrayList<Accident>(this.memory.getAll().values());
    }
}
