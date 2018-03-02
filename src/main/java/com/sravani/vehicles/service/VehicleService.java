package com.sravani.vehicles.service;

import com.mongodb.DBObject;
import com.sravani.vehicles.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Vehicle find(final String id) {
        Vehicle vehicle = mongoTemplate.findById(id, Vehicle.class);
        return vehicle;
    }

    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = mongoTemplate.findAll(Vehicle.class);
        return vehicles;
    }

    public String create(final Vehicle vehicle) {
        mongoTemplate.save(vehicle);
        return vehicle.getId();
    }

    public Vehicle update(final Vehicle vehicle) {
        mongoTemplate.save(vehicle);
        return find(vehicle.getId());
    }

    public void delete(final Vehicle vehicle) {
        mongoTemplate.remove(vehicle);
    }

    public void deleteById(final String id) {
        delete(find(id));
    }


    public String sayHello(){
        return "Hello1";
    }

}
