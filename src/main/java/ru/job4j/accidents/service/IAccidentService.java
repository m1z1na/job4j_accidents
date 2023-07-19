package ru.job4j.accidents.service;

import java.util.List;

import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;

public interface IAccidentService {
    List<Accident> findAll();
    List<AccidentType> findAllTypes();
    List<Rule> findAllRules();
    void create(Accident accident);
    void update(Accident accident);
    Accident getById(int id);
}
