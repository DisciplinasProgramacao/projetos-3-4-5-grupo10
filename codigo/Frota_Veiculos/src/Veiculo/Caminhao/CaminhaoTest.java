package Veiculo.Caminhao;

import org.junit.Test;
import static org.junit.Assert.*;

public class CaminhaoTest {
    Caminhao caminhao = new Caminhao("ABC-1234", 250, 130800.00, 60000, 9.5);

    //Test the addition of a route and if it add route mileage to vehicle mileage
    @Test
    public void shouldAddMileageAfterSetARouteThatHasDateInPass() {
        try {
            caminhao.addRoutes("23/08/2022", 18);
            assertEquals(60018, caminhao.getMileage());
            caminhao.addRoutes("23/08/2500", 18);
            assertEquals(60018, caminhao.getMileage());
        } catch (Exception e){
            e.getMessage();
        }
    }

    //Test the cost with inspections
    @Test
    public void shouldCalculateInspectionCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(2000, caminhao.calcInspectionCost(), 0.001);
        caminhao.setMileage(34500);
        assertEquals(1000, caminhao.calcInspectionCost(), 0.001);
        caminhao.setMileage(30000);
        assertEquals(1000, caminhao.calcInspectionCost(), 0.001);
        caminhao.setMileage(8000);
        assertEquals(0, caminhao.calcInspectionCost(), 0.001);
    }

    //Test the cost with maintenance
    @Test
    public void shouldCalculateMaintenanceCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(3000, caminhao.calcMaintenanceCost(), 0.001);
        caminhao.setMileage(25000);
        assertEquals(1000, caminhao.calcMaintenanceCost(), 0.001);
        caminhao.setMileage(20000);
        assertEquals(1000, caminhao.calcMaintenanceCost(), 0.001);
        caminhao.setMileage(5000);
        assertEquals(0, caminhao.calcMaintenanceCost(), 0.001);
    }

    //Test the cost with insurance
    @Test
    public void shouldCalculateVehicleInsuranceCost(){
        assertEquals( 0.02*caminhao.getSaleValue()+2000, caminhao.calcVehicleInsuranceCost(), 0.001);
    }

    //Test the cost with IVPA
    @Test
    public void shouldCalculateVehicleIPVACost(){
        assertEquals(0.04*caminhao.getSaleValue(), caminhao.calcIPVAVehicleCost(), 0.001);
    }
}
