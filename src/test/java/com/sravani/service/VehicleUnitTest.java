package com.sravani.service;

import com.sravani.vehicles.service.VehicleService;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Sridhara on 19-Feb-17.
 */
public class VehicleUnitTest {

    private VehicleService vehicleService = new VehicleService();

    @Test
    public void testSayHello(){
        String message =   vehicleService.sayHello();
        Assert.assertTrue("Hello1".equals(message));
    }

}
