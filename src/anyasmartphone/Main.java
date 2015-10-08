/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anyasmartphone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static private ArrayList<Integer> apps = new ArrayList();
    static private Map<Integer, Integer> aplicaciones = new HashMap<>();
    static int cantApp;
    static int cantRun;
    static int cantPantalla;
    //static int[] ejecutar;

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);

        cantApp = in.nextInt();

        cantRun = in.nextInt();

        cantPantalla = in.nextInt();

        //ejecutar = new int[cantRun];

        //Map<Integer, Integer> aplicaciones = new HashMap<>();
        int appId;
        for (int i = 0; i < cantApp; i++) {
            appId = in.nextInt();
            apps.add(i, appId);
            aplicaciones.put(appId, i);
        }
        long acciones = 0;
        int app;
        for (int i = 0; i < cantRun; i++) {
            app = in.nextInt();
            acciones += contarAcc(app);
            acciones++;
            //System.out.println("Acciones pocicion "+i+": "+acciones);
            ordenar(app);
        }
//        if (cantApp==10) {
//            acciones += 2;
//        }
        System.out.println(acciones);

    }

    private static int contarAcc(int app) {
        int movimientos = (int) aplicaciones.get(app) / cantPantalla;
        //System.out.println("Pantalla: "+acciones);
        //acciones += 1;
        
        //System.out.println("movimientos de pantalla: "+movimientos);
//        if ((ejecutar[app] % cantPantalla != 0) && cantPantalla > aplicaciones.get(ejecutar[app])) {
//            movimientos++;
//            System.out.println("+1");
//        }
        return movimientos;
    }

    private static void ordenar(int app) {
        //System.out.println("orden: " + aplicaciones);
        if (aplicaciones.get(app) > 0) {
            int aux = aplicaciones.get(app);
            apps.set(aux, apps.get(aux - 1));
            apps.set(aux - 1, app);
            
            aplicaciones.put(app, aux - 1);
            aplicaciones.put(apps.get(aux), aux);
            //aplicaciones.put(aplicaciones.get(aux - 1), aux);
        }
        //System.out.println(apps);
        //System.out.println("orden: " + aplicaciones);
        
    }

}
