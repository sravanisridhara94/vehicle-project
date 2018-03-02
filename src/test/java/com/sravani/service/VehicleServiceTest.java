package com.sravani.service;


import com.sravani.vehicles.config.AppConfig;
import com.sravani.vehicles.model.Vehicle;
import com.sravani.vehicles.service.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class VehicleServiceTest {


    @Autowired
    private VehicleService vehicleService;

    @Test
    public void testFindAll(){
       List<Vehicle> vehcles =  vehicleService.findAll();
    }

    @Test
    public void testSaveVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Sravani Vehicle14");
        vehicle.setDescription("Description 20 lines");

        String id = vehicleService.create(vehicle);
        assertTrue(id != null);

        Vehicle v = vehicleService.find(id);
        assertTrue("Sravani Vehicle14".equals(v.getName()));
        assertTrue("Description 20 lines".equals(v.getDescription()));

        List<Vehicle> vehcles =  vehicleService.findAll();
        assertTrue(vehcles != null && !vehcles.isEmpty());
    }


    @Test
    public void testUpdateVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Sravani Vehicle15");
        vehicle.setDescription("Description 21 lines");

        String id = vehicleService.create(vehicle);
        assertTrue(id != null);

        Vehicle v = new Vehicle();
        v.setId(id);
        v.setName("Sravani Vehicle15  Updated");
        Vehicle vUpdated = vehicleService.update(v);

        assertTrue( "Sravani Vehicle15  Updated".equals(vUpdated.getName())   );

    }


    @Test
    public void testDeleteVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Sravani Vehicle14");
        vehicle.setDescription("Description 20 lines");

        String id = vehicleService.create(vehicle);
        assertTrue(id != null);

        Vehicle v = vehicleService.find(id);
        assertTrue("Sravani Vehicle14".equals(v.getName()));
        assertTrue("Description 20 lines".equals(v.getDescription()));

        vehicleService.deleteById(id);

        Vehicle afterDeletion = vehicleService.find(id);
        assertTrue(afterDeletion == null);

    }


}
