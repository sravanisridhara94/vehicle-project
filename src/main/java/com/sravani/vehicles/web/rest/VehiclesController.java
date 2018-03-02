package com.sravani.vehicles.web.rest;

import com.sravani.vehicles.model.Vehicle;
import com.sravani.vehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    @ResponseBody
    public List<Vehicle> getVehiclesList() {
        return vehicleService.findAll();
    }

    @RequestMapping(value = "/vehicles/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Vehicle getVehiclesList(@PathVariable String id) {
        return vehicleService.find(id);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
    @ResponseBody
    public String createVehicle(Vehicle vehicle) {
        return vehicleService.create(vehicle);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.PUT)
    @ResponseBody
    public void updateVehicle(Vehicle vehicle) {
        vehicleService.update(vehicle);
    }


    @RequestMapping(value = "/vehicles/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteVehicle(@PathVariable  String id) {
        vehicleService.deleteById(id);
    }

}