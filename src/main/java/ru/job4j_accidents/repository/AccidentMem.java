package ru.job4j_accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public AccidentMem() {
        accidents.put(counter.addAndGet(1), new Accident(0, "name1", "text1", "address1"));
        accidents.put(counter.addAndGet(1), new Accident(2, "name2", "text2", "address2"));
        accidents.put(counter.addAndGet(1), new Accident(3, "name3", "text3", "address3"));
        accidents.put(counter.addAndGet(1), new Accident(4, "name4", "text4", "address4"));
        accidents.put(counter.addAndGet(1), new Accident(5, "name5", "text5", "address5"));
    }

    public void save(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(counter.addAndGet(1));
        }
        accidents.put(accident.getId(), accident);
    }

    public Map<Integer, Accident> getAll() {
        return accidents;
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
