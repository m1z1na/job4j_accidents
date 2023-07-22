package ru.job4j.accidents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.repository.AccidentTypeMem;

import java.util.List;

@Service
public class AccidentTypeService implements IAccidentTypeService {

    private final AccidentTypeMem memoryTypes;
    @Autowired
    public AccidentTypeService(AccidentTypeMem memoryTypes) {
        this.memoryTypes = memoryTypes;
    }

    @Override
    public List<AccidentType> findAll() {
        return memoryTypes.getAll();
    }

    @Override
    public AccidentType getById(int id) {
        return memoryTypes.findById(id);
    }
}
