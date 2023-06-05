package com.project.L41.controller.producerController;

import com.project.L41.model.producerModel.Producer;
import com.project.L41.repository.producerRepository.ProducerRepository;
import com.project.L41.service.poductService.ProductService;
import com.project.L41.service.producerService.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @PostMapping("/add")
    public void addProducer(@RequestBody Producer producer) {
        producerService.addProducer(producer);
    }

    @GetMapping("/all")
    public List<Producer> getAllProducer() {
        return producerService.loadAllProducer();
    }

    @GetMapping("/id/{id}")
    Producer getProducerByID(@PathVariable long id) {
        return producerService.findProducerByID(id);
    }

    @GetMapping("/name/{name}")
    List<Producer> findProducerByName(@PathVariable String name) {
        return producerService.findProducerByName(name);
    }
    @DeleteMapping("id/{id}")
    void deleteProducerByID(@PathVariable long id){
        producerService.deleteProducerByID(id);
    }
    @PutMapping("/update")
    void updateProducer(@RequestBody Producer producer){
        producerService.updateProduce(producer);
    }
}
