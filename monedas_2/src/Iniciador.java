import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Iniciador {
    public void menuPrincipal() {
        System.out.println(""" 
                ¿Que es lo que desea realizar?: 
                1.- Realizar Conversiones
                2.- Mostrar las conversiones realizadas 
                3.- Salir
                """);
    }
    public int [] menuMonedas() {
        Scanner opcion = new Scanner(System.in);
        int [] datos = new int [2];
        System.out.println("Seleccione el tipo de moneda origen y al que desea transformar");
        for (int i = 0; i < 2; i++) {
            System.out.println("""  
                1.- Dolar --> USD 
                2.- Peso Argentino --> ARS 
                3.- Sol Peruano --> PEN
                4.- Boliviano --> BOB
                5.- Peso Chileno --> CLP
                6.- Peso Colombiano --> COP
                7.- Real Brazileño --> BRL
                8.- Peso Mexicano --> MXN
                9.- Peso Uruguayo --> UYU
                """);
            var opcion_elegida = Integer.valueOf(opcion.nextLine());
            datos[i] = opcion_elegida;
        }
        return datos;
    }

    public Double quantity (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad a convertir:");
        Double cantidad = scanner.nextDouble();
        return cantidad;
    }

    public Double [] Agrupar (String Mon1,String Mon2) throws IOException, InterruptedException {
        BuscarValor valor = new BuscarValor();
        Double valorCanti = quantity();
        Double conversion = valor.GenerarValor(Mon1, Mon2, valorCanti);
        System.out.println("Total tras conversion: " + conversion);
        Double [] salida = {valorCanti,conversion};
        return salida;
    }
}
