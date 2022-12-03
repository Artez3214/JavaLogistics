package com.example.kursinis.utils;

import com.example.kursinis.model.CreatedForum;
import com.example.kursinis.model.Licence;
import com.example.kursinis.repository.LicenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
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
                                rs.getString("dateEnding"),
                                rs.getString("dateAcquireq"),
                                rs.getString("category"),
                                rs.getInt("userId")
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
