package Veiculo;

import Rota.Rota;
import java.util.LinkedList;

public abstract class Veiculo {
    protected String identifier;
    protected int tankSize;
    protected double kilometerPerLiter;
    protected double fixBaseValue;
    protected double saleValue;
    protected int mileage;
    protected LinkedList<Rota> routes;

    public abstract double calcIPVAVehicleCost();
    public abstract double calcMaintenanceCost();
    public abstract double calcVehicleInsuranceCost();
}
