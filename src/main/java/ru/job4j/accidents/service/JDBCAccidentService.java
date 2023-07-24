package ru.job4j.accidents.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;
import ru.job4j.accidents.repository.jdbc.AccidentJdbcTemplate;
import ru.job4j.accidents.repository.jdbc.AccidentTypeJdbcTemplate;
import ru.job4j.accidents.repository.jdbc.RuleJdbcTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Primary
public class JDBCAccidentService implements IAccidentService {

    private final RuleJdbcTemplate rule;
    private final AccidentTypeJdbcTemplate type;
    private final AccidentJdbcTemplate accident;

    @Autowired
    public JDBCAccidentService(AccidentJdbcTemplate accident, AccidentTypeJdbcTemplate type, RuleJdbcTemplate rule) {
        this.accident = accident;
        this.rule = rule;
        this.type = type;

//        create(new Accident(1, "name1", "text1", "address1", this.type.findById(1).orElse(null), this.rule.getAll()));
//        create(new Accident(2, "name2", "text2", "address2", this.type.findById(2).orElse(null), this.rule.getAll()));
//        create(new Accident(3, "name3", "text3", "address3", this.type.findById(1).orElse(null), this.rule.getAll()));
//        create(new Accident(4, "name4", "text4", "address4", this.type.findById(1).orElse(null), this.rule.getAll()));
//        create(new Accident(5, "name5", "text5", "address5", this.type.findById(2).orElse(null), this.rule.getAll()));

    }


    @Override
    public List<Accident> findAll() {
        /*return (List<Accident>) accidentsRepostiory.findAll();
        return accidentsRepostiory.getAll();*/
        return this.accident.getAll();
    }

    @Override
    public List<AccidentType> findAllTypes() {

        return type.getAll();
    }

    @Override
    public Set<Rule> findAllRules() {
        return rule.getAll();
    }

    @Override
    public void create(Accident accident) {
        this.accident.save(accident);
    }

    @Override
    public boolean update(Accident accident) {
        return this.accident.update(accident);
    }

    @Override
    public Optional<Accident> getById(int id) {
        return this.accident.findById(id);
    }
}
