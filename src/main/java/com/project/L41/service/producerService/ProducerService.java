package com.project.L41.service.producerService;

import com.project.L41.model.producerModel.Producer;

import java.util.List;

public interface ProducerService {
    void addProducer(Producer producer);
    List<Producer> loadAllProducer();
    Producer findProducerByID(long id);
    List<Producer> findProducerByName(String name);
    void deleteProducerByID(long id);
    void updateProduce(Producer producer);
}
