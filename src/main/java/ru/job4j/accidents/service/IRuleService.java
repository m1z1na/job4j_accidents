package ru.job4j.accidents.service;

import ru.job4j.accidents.model.Rule;
import java.util.Set;

public interface IRuleService {
    Set<Rule> findAll();
}
