package Veiculo.Van;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class VanTest {
    Van van = new Van("ABC-1234", 250, 130800.00, 60000);
    
    //Test the addition of a route and if it add route mileage to vehicle mileage
    @Test
    public void shouldAddMileageAfterSetARouteThatHasDateInPass() {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse("23/08/2022");
            van.addRoutes(date, 18);
            assertEquals(van.getMileage(), van.getMileage()+18);
            date = new SimpleDateFormat("dd/MM/yyyy").parse("23/08/2500");
            van.addRoutes(date, 18);
            assertEquals(van.getMileage(), van.getMileage());
        } catch (Exception e){
            e.getMessage();
        }
    }

    //Test the cost with inspections
    @Test
    public void shouldCalculateInspectionCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(van.calcInspectionCost(), 3000, 0.001);
        van.setMileage(15000);
        assertEquals(van.calcInspectionCost(), 500, 0.001);
        van.setMileage(10000);
        assertEquals(van.calcInspectionCost(), 500, 0.001);
        van.setMileage(8000);
        assertEquals(van.calcInspectionCost(), 0, 0.001);
    }

    //Test the cost with maintenance
    @Test
    public void shouldCalculateMaintenanceCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(van.calcMaintenanceCost(), 120*6.00, 0.001);
        van.setMileage(15000);
        assertEquals(van.calcMaintenanceCost(), 120, 0.001);
        van.setMileage(10000);
        assertEquals(van.calcMaintenanceCost(), 120, 0.001);
        van.setMileage(5000);
        assertEquals(van.calcMaintenanceCost(), 0, 0.001);
    }

    //Test the cost with insurance
    @Test
    public void shouldCalculateVehicleInsuranceCost(){
        assertEquals(van.calcVehicleInsuranceCost(), 0.03*van.getSaleValue(), 0.001);
    }

    //Test the cost with IVPA
    @Test
    public void shouldCalculateVehicleIPVACost(){
        assertEquals(van.calcIPVAVehicleCost(), 0.03*van.getSaleValue(), 0.001);
    }
}
