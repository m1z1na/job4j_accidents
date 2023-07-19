package ru.job4j.accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);
    private final AccidentTypeMem memoryType;

    public AccidentMem(AccidentTypeMem memoryType) {
        this.memoryType = memoryType;
        create(new Accident(0, "name1", "text1", "address1", memoryType.findById(1)));
        create(new Accident(2, "name2", "text2", "address2", memoryType.findById(2)));
        create(new Accident(3, "name3", "text3", "address3", memoryType.findById(1)));
        create(new Accident(4, "name4", "text4", "address4", memoryType.findById(1)));
        create(new Accident(5, "name5", "text5", "address5", memoryType.findById(2)));
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

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
