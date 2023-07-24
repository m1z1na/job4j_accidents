package ru.job4j.accidents.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;
import ru.job4j.accidents.repository.AccidentMem;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccidentService implements IAccidentService {

    private final AccidentMem memory;

    private final RuleService rule;
    private final AccidentTypeService type;

    @Autowired
    public AccidentService(AccidentMem memory, AccidentTypeService memoryType, RuleService rule) {
        this.memory = memory;
        this.rule = rule;
        this.type = memoryType;

        create(new Accident(1, "name1", "text1", "address1", this.type.getById(1), this.rule.findAll()));
        create(new Accident(2, "name2", "text2", "address2", this.type.getById(2), this.rule.findAll()));
        create(new Accident(3, "name3", "text3", "address3", this.type.getById(1), this.rule.findAll()));
        create(new Accident(4, "name4", "text4", "address4", this.type.getById(1), this.rule.findAll()));
        create(new Accident(5, "name5", "text5", "address5", this.type.getById(2), this.rule.findAll()));

    }


    @Override
    public List<Accident> findAll() {
        return this.memory.getAll();
    }

    @Override
    public List<AccidentType> findAllTypes() {

        return type.findAll();
    }

    @Override
    public Set<Rule> findAllRules() {
        return rule.findAll();
    }

    @Override
    public void create(Accident accident) {
        memory.create(accident);
    }

    @Override
    public boolean update(Accident accident) {
        return memory.update(accident);
    }

    @Override
    public Optional<Accident> getById(int id) {

        return memory.findById(id);
    }
}
