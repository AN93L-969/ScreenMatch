import com.angel.screenmatch.calculos.CalculadoraDeTiempo;
import com.angel.screenmatch.calculos.FiltroRecomendacion;
import com.angel.screenmatch.modelos.Episodio;
import com.angel.screenmatch.modelos.Pelicula;
import com.angel.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(7.5);
        miPelicula.evalua(10);
        miPelicula.evalua(9.0);
        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println("Média de evaluaciones de la película: " + miPelicula.calculaMedia());

        Serie casaDragon = new Serie("La casa del dragón", 2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodios(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.setDuracionEnMinutos(180);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus titulos favoritos: " + calculadora.getTiempoTotal() + " minutos.");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Targaryen");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(90);

        filtroRecomendacion.filtra(episodio);

        var peliculaDeAngel = new Pelicula("El señor de los anillos", 2001);
        peliculaDeAngel.setDuracionEnMinutos(180);

        ArrayList <Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeAngel);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera película es: " + listaDePeliculas.get(0).getNombre());
        System.out.println(listaDePeliculas.toString());
        System.out.println("toString de la película: " + listaDePeliculas.get(0).toString());
    }
}
