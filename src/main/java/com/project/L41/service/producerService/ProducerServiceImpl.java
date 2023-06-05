package com.project.L41.service.producerService;

import com.project.L41.model.producerModel.Producer;
import com.project.L41.repository.producerRepository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public void addProducer(Producer producer) {
        System.out.println("add producer ");
        producerRepository.save(producer);
    }

    @Override
    public List<Producer> loadAllProducer() {
        System.out.println("find all producer");
        return producerRepository.findAll();
    }

    @Override
    public Producer findProducerByID(long id) {
        System.out.println("get producer by ID");
        Producer producer = null;

        producer = producerRepository.findById(id);


        return producer;
    }

    @Override
    public List<Producer> findProducerByName(String name) {
        System.out.println("find all poduce by same name");
        List<Producer> producerListByName = new ArrayList<>();
        try {
            producerListByName = producerRepository.findProducerByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producerListByName;
    }

    @Override
    public void deleteProducerByID(long id) {
        System.out.println("delete producer");
        producerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateProduce(Producer producer) {
        System.out.println("update produce");

        Producer exitingProducer = producerRepository.findById(producer.getIdProducer());

        exitingProducer.setName(producer.getName());
        exitingProducer.setAddress(producer.getAddress());
        producerRepository.save(exitingProducer);

    }
}
