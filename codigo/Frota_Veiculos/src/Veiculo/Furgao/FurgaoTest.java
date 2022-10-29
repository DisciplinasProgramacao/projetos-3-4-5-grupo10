package Veiculo.Furgao;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FurgaoTest {
    Furgao furgao = new Furgao("ABC-1234", 250, 130800.00, 20000);
    
    //Test the addition of a route and if it add route mileage to vehicle mileage
    @Test
    public void shouldAddMileageAfterSetARouteThatHasDateInPass() {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse("23/08/2022");
            furgao.addRoutes(date, 18);
            assertEquals(furgao.getMileage(), furgao.getMileage()+18);
            date = new SimpleDateFormat("dd/MM/yyyy").parse("23/08/2500");
            furgao.addRoutes(date, 18);
            assertEquals(furgao.getMileage(), furgao.getMileage());
        } catch (Exception e){
            e.getMessage();
        }
    }

    //Test the cost with inspections
    @Test
    public void shouldCalculateInspectionCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(furgao.calcInspectionCost(), 1000, 0.001);
        furgao.setMileage(10560);
        assertEquals(furgao.calcInspectionCost(), 500, 0.001);
        furgao.setMileage(10000);
        assertEquals(furgao.calcInspectionCost(), 500, 0.001);
        furgao.setMileage(8000);
        assertEquals(furgao.calcInspectionCost(), 0, 0.001);
    }

    //Test the cost with maintenance
    @Test
    public void shouldCalculateMaintenanceCostWithMileageBiggerThanEqualsAndMinorThanMileageNeeded(){
        assertEquals(furgao.calcMaintenanceCost(), 120*2.00, 0.001);
        furgao.setMileage(15000);
        assertEquals(furgao.calcMaintenanceCost(), 120, 0.001);
        furgao.setMileage(10000);
        assertEquals(furgao.calcMaintenanceCost(), 120, 0.001);
        furgao.setMileage(5000);
        assertEquals(furgao.calcMaintenanceCost(), 0, 0.001);
    }

    //Test the cost with insurance
    @Test
    public void shouldCalculateVehicleInsuranceCost(){
        assertEquals(furgao.calcVehicleInsuranceCost(), 0.03*furgao.getSaleValue(), 0.001);
    }

    //Test the cost with IVPA
    @Test
    public void shouldCalculateVehicleIPVACost(){
        assertEquals(furgao.calcIPVAVehicleCost(), 0.03*furgao.getSaleValue(), 0.001);
    }
}
