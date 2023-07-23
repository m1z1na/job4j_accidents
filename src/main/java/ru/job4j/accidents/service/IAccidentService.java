package ru.job4j.accidents.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;

public interface IAccidentService {

    List<Accident> findAll();
    void create(Accident accident);
    boolean update(Accident accident);
    Optional<Accident> getById(int id);
    List<AccidentType> findAllTypes();
    Set<Rule> findAllRules();
}
