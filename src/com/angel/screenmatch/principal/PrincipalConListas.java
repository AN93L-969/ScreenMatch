package com.angel.screenmatch.principal;

import com.angel.screenmatch.modelos.Pelicula;
import com.angel.screenmatch.modelos.Serie;
import com.angel.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.evalua(6);
        var peliculaDeAngel = new Pelicula("El señor de los anillos", 2001);
        peliculaDeAngel.evalua(10);
        Serie casaDragon = new Serie("La casa del dragón", 2022);

        List<Titulo> lista = new LinkedList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeAngel);
        lista.add(casaDragon);

        for (Titulo item : lista){
            System.out.println(item.getNombre());

            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println("Clasificación: " + pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArrtistas = new ArrayList<>();
        listaDeArrtistas.add("Penelope Cruz");
        listaDeArrtistas.add("Antonio Banderas");
        listaDeArrtistas.add("Ricardo darin");

        System.out.println("Lista de artistas no ordenada" + listaDeArrtistas);
        Collections.sort(listaDeArrtistas);
        System.out.println("Lista de artistas ordenada" + listaDeArrtistas);

        Collections.sort(lista);
        System.out.println("Lista ordenada de titulos: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha de lamzamiento: " + lista);
    }
}
