package Veiculo.Carro;

import Rota.Rota;
import Veiculo.Veiculo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Carro extends Veiculo {

    public Carro(){}

    public Carro(String identifier, int tankSize, double saleValue, int mileage, double kilometerPerLiter) {
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
        return 0.04*saleValue;
    }

    public double calcMaintenanceCost(){
        return this.mileage/10000*80.0;
    }

    public double calcVehicleInsuranceCost(){
        return 0.05*saleValue+300;
    }

    public double calcInspectionCost(){
        return 0.0;
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
        System.out.println("Tipo do veículo: Carro");
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
