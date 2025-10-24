package com.angel.screenmatch.calculos;

public class FiltroRecomendacion {

    public void filtra (Clasificacion clasificacion) {
        if (clasificacion.getClasificacion() >= 4) {
            System.out.println("Muy bien evaluado por el momento");
        }else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("Popular por el momento");
        }else {
            System.out.println("Colocalo en tu lista de ver mas tarde");
        }
    }
}
