package ru.job4j_accidents.service;

import java.util.List;
import java.util.Map;
import ru.job4j.accidents.model.Accident;

public interface IAccidentService {
    List<Accident> findAll();
}
