package com.project.L41.repository.producerRepository;

import com.project.L41.model.producerModel.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,Long> {

    List<Producer> findProducerByName(String name) throws SQLException;
    Producer findById(long id);


}
