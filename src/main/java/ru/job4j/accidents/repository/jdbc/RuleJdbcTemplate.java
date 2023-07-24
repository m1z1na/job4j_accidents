package ru.job4j.accidents.repository.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.Rule;

import java.util.HashSet;
import java.util.Set;

@Repository
@AllArgsConstructor
public class RuleJdbcTemplate {
    private final JdbcTemplate jdbc;

    public Accident save(Accident accident) {
        jdbc.update("insert into rules (name) values (?)",
                accident.getName());
        return accident;
    }

    public Set<Rule> getAll() {
        return new HashSet<>(jdbc.query("select id, name from rules",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                }));
    }

}