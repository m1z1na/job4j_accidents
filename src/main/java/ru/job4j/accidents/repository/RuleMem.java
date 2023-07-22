package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RuleMem {
    private final Set<Rule> rules = ConcurrentHashMap.newKeySet();

    public RuleMem() {
        create(new Rule(1, "Две машины"));
        create(new Rule(2, "Машина и человек"));
        create(new Rule(3, "Машина и велосипед"));
    }

    public void create(Rule rule) {
        rules.add(rule);
    }

    public Set<Rule> getAll() {
        return rules;
    }


}
