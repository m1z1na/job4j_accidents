package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);
    private final AccidentTypeMem memoryTypes;
    private final RuleMem memoryrules;

    public AccidentMem(AccidentTypeMem memoryTypes, RuleMem memoryrules) {
        this.memoryTypes = memoryTypes;
        this.memoryrules = memoryrules;
        Set<Rule> rules = null;
        create(new Accident(0, "name1", "text1", "address1", memoryTypes.findById(1), rules));
        create(new Accident(2, "name2", "text2", "address2", memoryTypes.findById(2), rules));
        create(new Accident(3, "name3", "text3", "address3", memoryTypes.findById(1), rules));
        create(new Accident(4, "name4", "text4", "address4", memoryTypes.findById(1), rules));
        create(new Accident(5, "name5", "text5", "address5", memoryTypes.findById(2), rules));
    }

    public void create(Accident accident) {
        accident.setId(counter.addAndGet(1));
        accidents.put(accident.getId(), accident);
    }

    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public List<Accident> getAll() {
        return new ArrayList<Accident>(accidents.values());
    }

    public List<Rule> getAllRules() {
        return new ArrayList<Rule>(memoryrules.getAll());
    }


    public List<AccidentType> getAllTypes() {
        return new ArrayList<AccidentType>(memoryTypes.getAll());
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
