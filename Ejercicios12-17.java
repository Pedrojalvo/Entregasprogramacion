import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


//Una expresión lambda es una función anónima (sin nombre) que se puede tratar como un objeto y pasar como argumento a métodos. En Java, las lambdas permiten escribir código más conciso y funcional, especialmente cuando se trabaja con colecciones y streams.


public class EjerciciosLambdas {

    public static double integral(double a, double b, double h, Function<Double, Double> funcion) {
        double suma = 0.0;
        for (double x = a; x < b; x += h) {
            suma += funcion.apply(x) * h;
        }
        return suma;
    }

    public static void ejercicio14() {
        System.out.println("=== EJERCICIO 14 ===");
        
        // 1. Stream mediante IntStream.of()
        System.out.println("\n1. IntStream.of():");
        IntStream.of(1, 2, 3, 4, 5)
                 .forEach(n -> System.out.print(n + " "));
        
        // 2. Stream mediante IntStream.range()
        System.out.println("\n\n2. IntStream.range(1, 10):");
        IntStream.range(1, 10)
                 .forEach(n -> System.out.print(n + " "));
        
        // 3. Stream mediante IntStream.iterate()
        System.out.println("\n\n3. IntStream.iterate(0, n -> n + 2).limit(10):");
        IntStream.iterate(0, n -> n + 2)
                 .limit(10)
                 .forEach(n -> System.out.print(n + " "));
        
        // 4. Stream de números aleatorios con Random.doubles()
        System.out.println("\n\n4. Random.doubles().limit(10):");
        new Random().doubles(10, 0, 100)
                    .forEach(n -> System.out.printf("%.2f ", n));
        System.out.println();
    }


    public static void ejercicio15() {
        System.out.println("\n=== EJERCICIO 15 ===");
        
        // Lista de ejemplo para trabajar
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> nombres = Arrays.asList("Ana", "Juan", "Maria", "Pedro", "Luisa", "Carlos");
        
        // 1. Sumar todos los elementos
        int suma = numeros.stream()
                         .reduce(0, Integer::sum);
        System.out.println("1. Suma de elementos: " + suma);
        
        // 2. Calcular el promedio
        double promedio = numeros.stream()
                                 .mapToDouble(Integer::doubleValue)
                                 .average()
                                 .orElse(0.0);
        System.out.println("2. Promedio: " + promedio);
        
        // 3. Encontrar el máximo
        int maximo = numeros.stream()
                           .max(Integer::compareTo)
                           .orElse(0);
        System.out.println("3. Máximo: " + maximo);
        
        // 4. Encontrar el mínimo
        int minimo = numeros.stream()
                           .min(Integer::compareTo)
                           .orElse(0);
        System.out.println("4. Mínimo: " + minimo);
        
        // 5. Contar elementos pares
        long pares = numeros.stream()
                           .filter(n -> n % 2 == 0)
                           .count();
        System.out.println("5. Números pares: " + pares);
        
        // 6. Filtrar números mayores que un valor (ej. > 5)
        List<Integer> mayoresQue5 = numeros.stream()
                                           .filter(n -> n > 5)
                                           .collect(Collectors.toList());
        System.out.println("6. Mayores que 5: " + mayoresQue5);
        
        // 7. Ordenar ascendente
        List<Integer> ascendente = numeros.stream()
                                          .sorted()
                                          .collect(Collectors.toList());
        System.out.println("7. Orden ascendente: " + ascendente);
        
        // 8. Ordenar descendente
        List<Integer> descendente = numeros.stream()
                                           .sorted(Comparator.reverseOrder())
                                           .collect(Collectors.toList());
        System.out.println("8. Orden descendente: " + descendente);
        
        // 9. Multiplicar cada elemento por 2
        List<Integer> multiplicados = numeros.stream()
                                             .map(n -> n * 2)
                                             .collect(Collectors.toList());
        System.out.println("9. Multiplicados por 2: " + multiplicados);
        
        // 10. Obtener primeros n elementos
        List<Integer> primeros5 = numeros.stream()
                                         .limit(5)
                                         .collect(Collectors.toList());
        System.out.println("10. Primeros 5 elementos: " + primeros5);
        
        // 11. Obtener elementos distintos
        List<Integer> conDuplicados = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5);
        List<Integer> distintos = conDuplicados.stream()
                                               .distinct()
                                               .collect(Collectors.toList());
        System.out.println("11. Elementos distintos: " + distintos);
        
        // 12. Agrupar por longitud (ejemplo con strings)
        Map<Integer, List<String>> porLongitud = nombres.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("12. Nombres agrupados por longitud: " + porLongitud);
    }

    public static double integralConStreams(double a, double b, double h, Function<Double, Double> funcion) {
        return IntStream.range(0, (int)((b - a) / h))
                        .mapToDouble(i -> a + i * h)
                        .map(x -> funcion.apply(x) * h)
                        .sum();
    }


    public static class Persona {
        private String nombre;
        private LocalDate fechaDeNacimiento;
        
        public Persona(String nombre, LocalDate fechaDeNacimiento) {
            this.nombre = nombre;
            this.fechaDeNacimiento = fechaDeNacimiento;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        public LocalDate getFechaDeNacimiento() {
            return fechaDeNacimiento;
        }
        
        public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
            this.fechaDeNacimiento = fechaDeNacimiento;
        }
        
        public long calcularEdad() {
            return Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
        }
        
        @Override
        public String toString() {
            return String.format("Persona{nombre='%s', fechaNacimiento=%s, edad=%d}", 
                                nombre, fechaDeNacimiento, calcularEdad());
        }
    }
    

    public static void ejercicio17() {
        System.out.println("\n=== EJERCICIO 17 ===");
        
        // Crear lista de personas
        List<Persona> personas = Arrays.asList(
            new Persona("Ana", LocalDate.of(1995, 5, 15)),
            new Persona("Juan", LocalDate.of(1990, 8, 22)),
            new Persona("Maria", LocalDate.of(2000, 3, 10)),
            new Persona("Carlos", LocalDate.of(1985, 12, 1)),
            new Persona("Luisa", LocalDate.of(1998, 7, 18))
        );
        
        // Mostrar todas las personas
        System.out.println("Lista de personas:");
        personas.forEach(System.out::println);
        
        // Filtrar personas mayores de 25 años
        System.out.println("\nPersonas mayores de 25 años:");
        personas.stream()
                .filter(p -> p.calcularEdad() > 25)
                .forEach(System.out::println);
        
        // Ordenar por edad
        System.out.println("\nPersonas ordenadas por edad:");
        personas.stream()
                .sorted(Comparator.comparingLong(Persona::calcularEdad))
                .forEach(System.out::println);
        
        // Obtener nombres de personas menores de 30 años
        System.out.println("\nNombres de personas menores de 30 años:");
        personas.stream()
                .filter(p -> p.calcularEdad() < 30)
                .map(Persona::getNombre)
                .forEach(System.out::println);
        
        // Calcular edad promedio
        double edadPromedio = personas.stream()
                                      .mapToLong(Persona::calcularEdad)
                                      .average()
                                      .orElse(0.0);
        System.out.println("\nEdad promedio: " + edadPromedio);
    }

    public static void main(String[] args) {
        // Ejemplo de uso del ejercicio 13 y 16
        System.out.println("=== EJERCICIO 13 y 16 - Ejemplo de integral ===");
        
        // Definir funciones usando lambdas
        Function<Double, Double> cuadratica = x -> x * x;
        Function<Double, Double> seno = x -> Math.sin(x);
        Function<Double, Double> lineal = x -> 2 * x + 1;
        
        // Calcular integrales con el método tradicional
        System.out.println("\nUsando integral() (ejercicio 13):");
        System.out.printf("∫(x^2) de 0 a 1: %.4f%n", integral(0, 1, 0.0001, cuadratica));
        System.out.printf("∫(sin x) de 0 a π: %.4f%n", integral(0, Math.PI, 0.0001, seno));
        System.out.printf("∫(2x+1) de 0 a 2: %.4f%n", integral(0, 2, 0.0001, lineal));
        
        // Calcular integrales con streams
        System.out.println("\nUsando integralConStreams() (ejercicio 16):");
        System.out.printf("∫(x^2) de 0 a 1: %.4f%n", integralConStreams(0, 1, 0.0001, cuadratica));
        System.out.printf("∫(sin x) de 0 a π: %.4f%n", integralConStreams(0, Math.PI, 0.0001, seno));
        System.out.printf("∫(2x+1) de 0 a 2: %.4f%n", integralConStreams(0, 2, 0.0001, lineal));
        
        // Ejecutar ejercicio 14
        ejercicio14();
        
        // Ejecutar ejercicio 15
        ejercicio15();
        
        // Ejecutar ejercicio 17
        ejercicio17();
    }
}