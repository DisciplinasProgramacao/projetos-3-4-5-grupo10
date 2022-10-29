package Veiculo;

import Rota.Rota;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

public abstract class Veiculo implements Serializable{
    protected String identifier;
    protected int tankSize;
    protected double kilometerPerLiter;
    protected double saleValue;
    protected int mileage = 0;
    protected LinkedList<Rota> routes;

    public abstract double calcIPVAVehicleCost();
    public abstract double calcMaintenanceCost();
    public abstract double calcInspectionCost();
    public abstract double calcVehicleInsuranceCost();
    public abstract void addRoutes(Date date, int distance);
}
