package ru.job4j.accidents.service;

import java.util.List;

import ru.job4j.accidents.model.Accident;

public interface IAccidentService {
    List<Accident> findAll();
    void create(Accident accident);
    Accident getById(int id);
}
