import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner opcion = new Scanner(System.in);
        String [] Mon_Pai = {"USD","ARS","PEN","BOB","CLP","COP","BRL","MXN","UYU"};
        ArrayList<String> conversiones = new ArrayList<>();
        Iniciador inicio = new Iniciador();
        inicio.menuPrincipal();
        while (true) {
            var opcion_elegida = Integer.valueOf(opcion.nextLine());
            switch (opcion_elegida) {
                case 1: {
                    int [] datos = inicio.menuMonedas();
                    Double [] resultado = inicio.Agrupar (Mon_Pai[datos[0]-1], Mon_Pai[datos[1]-1]);
                    conversiones.add("Conversion de " + Mon_Pai[datos[0]-1] + " a " + Mon_Pai[datos[1]-1] + " con valor " + resultado[0] + "; resultado: " + resultado[1]);
                    inicio.menuPrincipal();
                    break;
                }
                case 2:{

                    for (String i: conversiones) {
                        System.out.println(i);
                    }
                    inicio.menuPrincipal();
                    break;
                }
            }
            if (opcion_elegida == 3){
                break;
            }

        }

    }
}