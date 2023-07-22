package ru.job4j.accidents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Rule;
import ru.job4j.accidents.repository.RuleMem;

import java.util.Set;

@Service
public class RuleService implements IRuleService {
    private final RuleMem memory;

    @Autowired
    public RuleService(RuleMem memory) {
        this.memory = memory;
    }

    @Override
    public Set<Rule> findAll() {
        return memory.getAll();
    }

}
