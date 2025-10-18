public class Pelicula {
    String nombre;
    int fechaDeLanzamiento;
    int duracionEnMinutos;
    boolean incluidoEnElPlan;
    double sumaDeLasEvaluaciones;
    int totalDeLasEvaluaciones;

    void muestraFichaTecnica () {
        System.out.println("El nombre de la película es: " + nombre);
        System.out.println("Su fecha de lanzamiento es: " + fechaDeLanzamiento);
        System.out.println("Duración en minutos: " + duracionEnMinutos);

        if (incluidoEnElPlan) {
            System.out.println("Película disponible en su plan.");
        }else {
            System.out.println("Película no disponible en su plan.");
        }
    }

    void evalua (double nota) {
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones ++;
    }

    double calculaMedia () {
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }
}
