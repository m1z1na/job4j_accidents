package ru.job4j.accidents.repository.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public Accident save(Accident accident) {
        jdbc.update("insert into accidents (name) values (?)",
                accident.getName());
        return accident;
    }

    public List<Accident> getAll() {
        return jdbc.query("select id, name from accidents",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    public boolean update(Accident accident) {
        jdbc.update("update into accidents (name) values (?) where id=(?)",
                accident.getName(), accident.getId());
        return true;
    }


    public Optional<Accident> findById(int id) {
        String sql = "SELECT * FROM accidents WHERE ID=?";
        return Optional.ofNullable((Accident) jdbc.queryForObject(
                sql, new Object[]{id},  Accident.class));



    }


}