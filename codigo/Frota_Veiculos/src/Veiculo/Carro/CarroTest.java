package Veiculo.Carro;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CarroTest {
    Carro carro = new Carro("ABC-1234", 250, 130800.00, 20000);

    //Test the addition of a route and if it add route mileage to vehicle mileage
    @Test
    public void shouldAddMileageAfterSetARouteThatHasDateInPass() {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse("23/08/2022");
            carro.addRoutes(date, 18);
            assertEquals(carro.getMileage(), carro.getMileage()+18);
            date = new SimpleDateFormat("dd/MM/yyyy").parse("23/08/2500");
            carro.addRoutes(date, 18);
            assertEquals(carro.getMileage(), carro.getMileage());
        } catch (Exception e){
            e.getMessage();
        }
    }

    //Cars have no cost with inspection
    @Test
    public void shouldCalculateInspectionCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(carro.calcInspectionCost(), 0, 0.001);
        carro.setMileage(34500);
        assertEquals(carro.calcInspectionCost(), 0, 0.001);
        carro.setMileage(30000);
        assertEquals(carro.calcInspectionCost(), 0, 0.001);
        carro.setMileage(8000);
        assertEquals(carro.calcInspectionCost(), 0, 0.001);
    }

    //Test the cost with maintenance
    @Test
    public void shouldCalculateMaintenanceCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(carro.calcMaintenanceCost(), 160, 0.001);
        carro.setMileage(15000);
        assertEquals(carro.calcMaintenanceCost(), 80, 0.001);
        carro.setMileage(10000);
        assertEquals(carro.calcMaintenanceCost(), 80, 0.001);
        carro.setMileage(5000);
        assertEquals(carro.calcMaintenanceCost(), 0, 0.001);
    }

    //Test the cost with insurance
    @Test
    public void shouldCalculateVehicleInsuranceCost(){
        assertEquals(carro.calcVehicleInsuranceCost(), 0.05*carro.getSaleValue()+300, 0.001);
    }

    //Test the cost with IVPA
    @Test
    public void shouldCalculateVehicleIPVACost(){
        assertEquals(carro.calcIPVAVehicleCost(), 0.04*carro.getSaleValue(), 0.001);
    }
}
