package Veiculo.Van;

import org.junit.Test;
import static org.junit.Assert.*;


public class VanTest {
    Van van = new Van("ABC-1234", 250, 130800.00, 60000, 9.5);
    
    //Test the addition of a route and if it add route mileage to vehicle mileage
    @Test
    public void shouldAddMileageAfterSetARouteThatHasDateInPass() {
        try {
            van.addRoutes("23/08/2022", 18);
            assertEquals(60018, van.getMileage());
            van.addRoutes("23/08/2500", 18);
            assertEquals(60018, van.getMileage());
        } catch (Exception e){
            e.getMessage();
        }
    }

    //Test the cost with inspections
    @Test
    public void shouldCalculateInspectionCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(3000, van.calcInspectionCost(), 0.001);
        van.setMileage(15000);
        assertEquals(500, van.calcInspectionCost(), 0.001);
        van.setMileage(10000);
        assertEquals(500, van.calcInspectionCost(), 0.001);
        van.setMileage(8000);
        assertEquals(0, van.calcInspectionCost(), 0.001);
    }

    //Test the cost with maintenance
    @Test
    public void shouldCalculateMaintenanceCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(720, van.calcMaintenanceCost(), 0.001);
        van.setMileage(15000);
        assertEquals(120, van.calcMaintenanceCost(), 0.001);
        van.setMileage(10000);
        assertEquals(120, van.calcMaintenanceCost(), 0.001);
        van.setMileage(5000);
        assertEquals(0, van.calcMaintenanceCost(), 0.001);
    }

    //Test the cost with insurance
    @Test
    public void shouldCalculateVehicleInsuranceCost(){
        assertEquals(0.03*van.getSaleValue(), van.calcVehicleInsuranceCost(), 0.001);
    }

    //Test the cost with IVPA
    @Test
    public void shouldCalculateVehicleIPVACost(){
        assertEquals(0.03*van.getSaleValue(), van.calcIPVAVehicleCost(), 0.001);
    }
}
