package ru.job4j_accidents.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentMem {

    Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    public AccidentMem() {
        accidents.put(1,new Accident(0, "name1", "text1", "address1"));
        accidents.put(2,new Accident(2, "name2", "text2", "address2"));
        accidents.put(3,new Accident(3, "name3", "text3", "address3"));
        accidents.put(4,new Accident(4, "name4", "text4", "address4"));
        accidents.put(5,new Accident(5, "name5", "text5", "address5"));
    }

    public Map<Integer, Accident> getAll(){
        return accidents;
    }

}
