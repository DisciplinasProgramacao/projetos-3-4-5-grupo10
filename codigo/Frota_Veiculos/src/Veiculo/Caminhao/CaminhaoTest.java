package Veiculo.Caminhao;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CaminhaoTest {
    Caminhao caminhao = new Caminhao("ABC-1234", 250, 130800.00, 60000);

    //Test the addition of a route and if it add route mileage to vehicle mileage
    @Test
    public void shouldAddMileageAfterSetARouteThatHasDateInPass() {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse("23/08/2022");
            caminhao.addRoutes(date, 18);
            assertEquals(caminhao.getMileage(), caminhao.getMileage()+18);
            date = new SimpleDateFormat("dd/MM/yyyy").parse("23/08/2500");
            caminhao.addRoutes(date, 18);
            assertEquals(caminhao.getMileage(), caminhao.getMileage());
        } catch (Exception e){
            e.getMessage();
        }
    }

    //Test the cost with inspections
    @Test
    public void shouldCalculateInspectionCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(caminhao.calcInspectionCost(), 2000, 0.001);
        caminhao.setMileage(34500);
        assertEquals(caminhao.calcInspectionCost(), 1000, 0.001);
        caminhao.setMileage(30000);
        assertEquals(caminhao.calcInspectionCost(), 1000, 0.001);
        caminhao.setMileage(8000);
        assertEquals(caminhao.calcInspectionCost(), 0, 0.001);
    }

    //Test the cost with maintenance
    @Test
    public void shouldCalculateMaintenanceCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(caminhao.calcMaintenanceCost(), 1000*3.00, 0.001);
        caminhao.setMileage(25000);
        assertEquals(caminhao.calcMaintenanceCost(), 1000, 0.001);
        caminhao.setMileage(20000);
        assertEquals(caminhao.calcMaintenanceCost(), 1000, 0.001);
        caminhao.setMileage(5000);
        assertEquals(caminhao.calcMaintenanceCost(), 0, 0.001);
    }

    //Test the cost with insurance
    @Test
    public void shouldCalculateVehicleInsuranceCost(){
        assertEquals(caminhao.calcVehicleInsuranceCost(), 0.02*caminhao.getSaleValue()+2000, 0.001);
    }

    //Test the cost with IVPA
    @Test
    public void shouldCalculateVehicleIPVACost(){
        assertEquals(caminhao.calcIPVAVehicleCost(), 0.04*caminhao.getSaleValue(), 0.001);
    }
}
