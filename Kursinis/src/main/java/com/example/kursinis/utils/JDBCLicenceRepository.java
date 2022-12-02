package com.example.kursinis.utils;

import com.example.kursinis.model.CreatedForum;
import com.example.kursinis.model.Licence;
import com.example.kursinis.repository.LicenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JDBCLicenceRepository implements LicenceRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Licence> findAll() {
        return jdbcTemplate.query(
                "select * from licence",
                (rs,rowNum) ->
                        new Licence(
                                rs.getInt("licenceId"),
                                LocalDate.parse(rs.getString("dateEnding")),
                                LocalDate.parse(rs.getString("dateAcquireq")),
                                rs.getString("category")
                        )
        );
    }
    @Override
    public String delete(String destinationInfo){return "";}

    @Override
    public String update(String destinationInfo){return "";}

    @Override
    public String insert(String destinationInfo){return "";}
}
