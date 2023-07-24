package ru.job4j.accidents.repository.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.AccidentType;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AccidentTypeJdbcTemplate {
    private final JdbcTemplate jdbc;
    private final RowMapper<AccidentType> mapper = (resultSet, rowNum) -> {
        AccidentType type = new AccidentType();
        type.setId(resultSet.getInt("id"));
        type.setName(resultSet.getString("name"));
        return type;
    };

    public AccidentType save(AccidentType accidentType) {
        jdbc.update("insert into types (name) values (?)",
                accidentType.getName());
        return accidentType;
    }

    public List<AccidentType> getAll() {
        return jdbc.query("select id, name from types",
                (rs, row) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));
                    return accidentType;
                });
    }

    public Optional<AccidentType> findById(int id) {
        AccidentType type = jdbc.queryForObject("SELECT * FROM types WHERE id = ?", mapper, id);
        return Optional.ofNullable(type);
    }


}