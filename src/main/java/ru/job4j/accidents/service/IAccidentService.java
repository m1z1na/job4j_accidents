package ru.job4j.accidents.service;

import java.util.List;

import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;

public interface IAccidentService {
    List<Accident> findAll();
    List<AccidentType> findAllType();
    void create(Accident accident);
    void update(Accident accident);
    Accident getById(int id);
}
