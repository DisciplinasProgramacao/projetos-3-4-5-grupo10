package Veiculo.Furgao;

import Rota.Rota;
import Veiculo.Veiculo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Furgao extends Veiculo {

    public Furgao(){}

    public Furgao(String identifier, int tankSize, double saleValue, int mileage, double kilometerPerLiter) {
        this.identifier = identifier;
        this.tankSize = tankSize;
        this.saleValue = saleValue;
        this.mileage = mileage;
        this.kilometerPerLiter = kilometerPerLiter;
        this.routes = new LinkedList<Rota>();
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

    public void addRoutes(String date, int distance){
        try{
            Date routeDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            Rota route = new Rota(routeDate, distance);
            this.routes.add(route);
            if(routeDate.getTime() < System.currentTimeMillis()) {
                this.mileage += route.getDistance();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void generateReport() {
        System.out.println("Tipo do veículo: Furgão");
        System.out.println("Placa: "+this.identifier);
        System.out.println("Valor de venda: "+this.saleValue);
        System.out.println("Quilometragem: "+this.mileage);
        System.out.println("Tamanho do tanque: "+this.tankSize);
        System.out.println("Autonomia diária: "+this.kilometerPerLiter*tankSize);
        System.out.println("Gastos com Vistoria: "+this.calcInspectionCost());
        System.out.println("Gastos com Manutenção: "+this.calcMaintenanceCost());
        System.out.println("Gastos com IPVA: "+this.calcIPVAVehicleCost());
        System.out.println("Gastos com Seguro: "+this.calcVehicleInsuranceCost());
        System.out.println("Gastos totais: "+ (this.calcInspectionCost()+
                                               this.calcIPVAVehicleCost()+
                                               this.calcMaintenanceCost()+
                                               this.calcVehicleInsuranceCost()));
        System.out.print("Rotas :");
        for(Rota item : routes) {
            System.out.println(""+ item.getDate() + " | " + item.getDistance());
        }
        System.out.println("Data de emissão: " + new Date(System.currentTimeMillis()));
    }
}
