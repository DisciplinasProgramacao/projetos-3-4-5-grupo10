package Veiculo.Furgao;

import org.junit.Test;
import static org.junit.Assert.*;

public class FurgaoTest {
    Furgao furgao = new Furgao("ABC-1234", 250, 130800.00, 20000, 9.5);
    
    //Test the addition of a route and if it add route mileage to vehicle mileage
    @Test
    public void shouldAddMileageAfterSetARouteThatHasDateInPass() {
        try {
            furgao.addRoutes("23/08/2022", 18);
            assertEquals(20018, furgao.getMileage());
            furgao.addRoutes("23/08/2500", 18);
            assertEquals(20018, furgao.getMileage());
        } catch (Exception e){
            e.getMessage();
        }
    }

    //Test the cost with inspections
    @Test
    public void shouldCalculateInspectionCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(1000, furgao.calcInspectionCost(),  0.001);
        furgao.setMileage(10560);
        assertEquals(500, furgao.calcInspectionCost(), 0.001);
        furgao.setMileage(10000);
        assertEquals(500, furgao.calcInspectionCost(), 0.001);
        furgao.setMileage(8000);
        assertEquals(0, furgao.calcInspectionCost(), 0.001);
    }

    //Test the cost with maintenance
    @Test
    public void shouldCalculateMaintenanceCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(240, furgao.calcMaintenanceCost(), 0.001);
        furgao.setMileage(15000);
        assertEquals(120, furgao.calcMaintenanceCost(), 0.001);
        furgao.setMileage(10000);
        assertEquals(120, furgao.calcMaintenanceCost(), 0.001);
        furgao.setMileage(5000);
        assertEquals(0, furgao.calcMaintenanceCost(), 0.001);
    }

    //Test the cost with insurance
    @Test
    public void shouldCalculateVehicleInsuranceCost(){
        assertEquals(0.03*furgao.getSaleValue(), furgao.calcVehicleInsuranceCost(), 0.001);
    }

    //Test the cost with IVPA
    @Test
    public void shouldCalculateVehicleIPVACost(){
        assertEquals(0.03*furgao.getSaleValue(), furgao.calcIPVAVehicleCost(), 0.001);
    }
}
