package Veiculo.Carro;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarroTest {
    Carro carro = new Carro("ABC-1234", 250, 130800.00, 20000, 9.5);

    //Test the addition of a route and if it add route mileage to vehicle mileage
    @Test
    public void shouldAddMileageAfterSetARouteThatHasDateInPass() {
        try {
            carro.addRoutes("23/08/2022", 18);
            assertEquals(20018, carro.getMileage());
            carro.addRoutes("23/08/2500", 18);
            assertEquals(20018, carro.getMileage());
        } catch (Exception e){
            e.getMessage();
        }
    }

    //Cars have no cost with inspection
    @Test
    public void shouldCalculateInspectionCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(0, carro.calcInspectionCost(), 0.001);
        carro.setMileage(34500);
        assertEquals(0, carro.calcInspectionCost(), 0.001);
        carro.setMileage(30000);
        assertEquals(0, carro.calcInspectionCost(), 0.001);
        carro.setMileage(8000);
        assertEquals(0, carro.calcInspectionCost(), 0.001);
    }

    //Test the cost with maintenance
    @Test
    public void shouldCalculateMaintenanceCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(160, carro.calcMaintenanceCost(), 0.001);
        carro.setMileage(15000);
        assertEquals(80, carro.calcMaintenanceCost(), 0.001);
        carro.setMileage(10000);
        assertEquals(80, carro.calcMaintenanceCost(), 0.001);
        carro.setMileage(5000);
        assertEquals(0, carro.calcMaintenanceCost(), 0.001);
    }

    //Test the cost with insurance
    @Test
    public void shouldCalculateVehicleInsuranceCost(){
        assertEquals(0.05*carro.getSaleValue()+300, carro.calcVehicleInsuranceCost(), 0.001);
    }

    //Test the cost with IVPA
    @Test
    public void shouldCalculateVehicleIPVACost(){
        assertEquals(0.04*carro.getSaleValue(), carro.calcIPVAVehicleCost(), 0.001);
    }
}
