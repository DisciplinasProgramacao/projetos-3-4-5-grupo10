package Veiculo.Furgao;

import Rota.Rota;
import Veiculo.Veiculo;
import java.util.Date;

public class Furgao extends Veiculo {

    public Furgao(String identifier, int tankSize, double saleValue, int mileage) {
        this.identifier = identifier;
        this.tankSize = tankSize;
        this.saleValue = saleValue;
        this.mileage = mileage;
    }

    public double getSaleValue() {
        return this.saleValue;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage() {
        return this.mileage;
    }
    
    public double calcIPVAVehicleCost(){
        return 0.03*saleValue;
    }

    public double calcMaintenanceCost(){
        return this.mileage/10000*120.0;
    }

    public double calcVehicleInsuranceCost(){
        return 0.03*saleValue;
    }

    public double calcInspectionCost(){
        return this.mileage/10000*500.0;
    }

    public void addRoutes(Date date, int distance){
        Rota route = new Rota(date, distance);
        this.routes.add(route);
        if(date.getTime() < System.currentTimeMillis()) {
            this.mileage += route.getDistance();
        }
    }
}
