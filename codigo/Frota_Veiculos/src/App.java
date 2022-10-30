import java.util.LinkedList;
import java.util.Scanner;

import Rota.Rota;
import Veiculo.Veiculo;
import Veiculo.Caminhao.Caminhao;
import Veiculo.Van.Van;
import Veiculo.Carro.Carro;
import Veiculo.Furgao.Furgao;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws Exception {
        int flag = 1;
        Scanner sc = new Scanner(System.in); 
        
        LinkedList<Veiculo> frota = new LinkedList<Veiculo>();

        while(flag != 0) {
            System.out.println("Selecione uma opção");
            System.out.println("1) Carregar um conjunto de veículos de um arquivo");
            System.out.println("2) Salvar um conjunto de veículos de um arquivo");
            System.out.println("3) Incluir um novo veículo");
            System.out.println("4) Incluir rotas para um veículo");
            System.out.println("5) Localizar um veículo da frota");
            System.out.println("6) Imprimir um relatório do veículo com seus gastos até o momento.");
            System.out.println("0) Sair");
            flag = sc.nextInt(); 
            switch(flag) {
                case 1:
                    loadVehiclesFromFile(frota);
                    frota.getLast().generateReport();
                    break;
                case 2:
                    System.out.println("2)");
                    break;
                case 3:
                    addVehicle(frota);
                    break;
                case 4:
                    System.out.println("4)");
                    break;
                case 5:
                    System.out.println("5)");
                    break;
                case 6:
                    System.out.println("6)");
                    break;
            }
        }
        sc.close();
    }

    public static void addVehicle(LinkedList<Veiculo> frota) {
        Veiculo vehicle;
        String str;
        String[] vect;
        int flag = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione o tipo de veiculo que deseja adicionar na frota");
        System.out.println("1) Carro");
        System.out.println("2) Caminhao");
        System.out.println("3) Furgao");
        System.out.println("4) Van");
        System.out.println("0) Cancelar");
        flag = sc.nextInt();
        switch (flag) {
            case 1:
                System.out.println("Insira os dados nesse formato:");
                System.out.println("Placa,Tamanho do Tanque,Preço de Venda,Quilometragem,Economia");
                str = sc.nextLine();
                vect = str.split(",");
                vehicle = new Carro(vect[0], Integer.parseInt(vect[1]), Double.parseDouble(vect[2]), Integer.parseInt(vect[3]), Double.parseDouble(vect[4]));
                frota.add(vehicle);
                break;
            case 2:
                System.out.println("Insira os dados nesse formato:");
                System.out.println("Placa,Tamanho do Tanque,Preço de Venda,Quilometragem,Economia");
                str = sc.nextLine();
                vect = str.split(",");
                vehicle = new Carro(vect[0], Integer.parseInt(vect[1]), Double.parseDouble(vect[2]), Integer.parseInt(vect[3]), Double.parseDouble(vect[4]));
                frota.add(vehicle);
                break;
            case 3:
                System.out.println("Insira os dados nesse formato:");
                System.out.println("Placa,Tamanho do Tanque,Preço de Venda,Quilometragem,Economia");
                str = sc.nextLine();
                vect = str.split(",");
                vehicle = new Carro(vect[0], Integer.parseInt(vect[1]), Double.parseDouble(vect[2]), Integer.parseInt(vect[3]), Double.parseDouble(vect[4]));
                frota.add(vehicle);
                break;
            case 4:
                System.out.println("Insira os dados nesse formato:");
                System.out.println("Placa,Tamanho do Tanque,Preço de Venda,Quilometragem,Economia");
                str = sc.nextLine();
                vect = str.split(",");
                vehicle = new Carro(vect[0], Integer.parseInt(vect[1]), Double.parseDouble(vect[2]), Integer.parseInt(vect[3]), Double.parseDouble(vect[4]));
                frota.add(vehicle);
                break;
        }
        sc.close();
    }
    
    public static void loadVehiclesFromFile(LinkedList<Veiculo> frota) {
        String path = "/home/ribas/PUCMINAS/Lab_PM/projetos-3-4-5-grupo10/codigo/Frota_Veiculos/src/vehicles/load_vehicles.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            Veiculo vehicle;
            line = br.readLine();
            while(line != null) {
                String[] vect = line.split(",");
                if(vect[0].toLowerCase() == "carro") {
                    vehicle = new Carro(vect[1], Integer.parseInt(vect[2]), Double.parseDouble(vect[3]), Integer.parseInt(vect[4]), Double.parseDouble(vect[5]));
                } else if(vect[0].toLowerCase() == "caminhao") {
                    vehicle = new Caminhao(vect[1], Integer.parseInt(vect[2]), Double.parseDouble(vect[3]), Integer.parseInt(vect[4]), Double.parseDouble(vect[5]));
                } else if(vect[0].toLowerCase() == "furgao") {
                    vehicle = new Furgao(vect[1], Integer.parseInt(vect[2]), Double.parseDouble(vect[3]), Integer.parseInt(vect[4]), Double.parseDouble(vect[5]));
                } else if(vect[0].toLowerCase() == "van") {
                    vehicle = new Van(vect[1], Integer.parseInt(vect[2]), Double.parseDouble(vect[3]), Integer.parseInt(vect[4]), Double.parseDouble(vect[5]));
                } else {
                    throw new IOException("Veiculo Invalido");
                }
                frota.add(vehicle);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void saveVehiclesOnFile() {

    }
}
