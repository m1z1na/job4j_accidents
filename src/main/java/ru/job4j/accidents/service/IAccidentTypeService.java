package ru.job4j.accidents.service;

import ru.job4j.accidents.model.AccidentType;
import java.util.List;

public interface IAccidentTypeService {

    List<AccidentType> findAll();

    AccidentType getById(int id);
}
