package Progra2;

import java.util.*;

class Actividad {
    int inicio;
    int fin;
    String nombre;
    
    public Actividad(int inicio, int fin, String nombre) {
        this.inicio = inicio;
        this.fin = fin;
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre + " (" + inicio + "-" + fin + ")";
    }
}

public class PlanificadorTareas {
    
    public List<Actividad> seleccionarActividades(List<Actividad> actividades) {
        if (actividades == null || actividades.isEmpty()) {
            return new ArrayList<>();
        }
        
        actividades.sort(Comparator.comparingInt(a -> a.fin));
        
        List<Actividad> seleccionadas = new ArrayList<>();
        int ultimoFin = -1;
        
        for (Actividad actividad : actividades) {
            if (actividad.inicio >= ultimoFin) {
                seleccionadas.add(actividad);
                ultimoFin = actividad.fin;
            }
        }
        
        return seleccionadas;
    }
    
    public static void main(String[] args) {
        PlanificadorTareas planificador = new PlanificadorTareas();
        
        List<Actividad> actividades = Arrays.asList(
            new Actividad(1, 4, "Actividad A"),
            new Actividad(3, 5, "Actividad B"),
            new Actividad(0, 6, "Actividad C"),
            new Actividad(5, 7, "Actividad D"),
            new Actividad(3, 8, "Actividad E"),
            new Actividad(5, 9, "Actividad F"),
            new Actividad(6, 10, "Actividad G"),
            new Actividad(8, 11, "Actividad H")
        );
        
        List<Actividad> resultado = planificador.seleccionarActividades(actividades);
        
        System.out.println("Actividades seleccionadas (máximo número sin solaparse):");
        for (Actividad act : resultado) {
            System.out.println(act);
        }
        System.out.println("Total: " + resultado.size() + " actividades");
    }
}