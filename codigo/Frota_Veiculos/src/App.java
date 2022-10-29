import java.util.Scanner;

import Veiculo.*;

public class App {

    public static void main(String[] args) throws Exception {
        int flag = 1;
        Scanner sc = new Scanner(System.in);  
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
                    System.out.println("1)");
                    break;
                case 2:
                    System.out.println("2)");
                    break;
                case 3:
                    System.out.println("3)");
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

    public static void addVehicle() {
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
                
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
        sc.close();
    }
}
