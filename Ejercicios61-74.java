import java.util.*;

public class EjerciciosTAD {

    public static void ejercicio61() {
        System.out.println("TAD (Tipo Abstracto de Datos): Especificación conceptual que define un tipo de datos por su comportamiento sin especificar implementación.");
        System.out.println("Estructura de Datos: Implementación concreta que define cómo se organizan y almacenan los datos en memoria.");
        System.out.println("Ejemplo: List es un TAD, ArrayList y LinkedList son estructuras de datos.");
    }

    public static void ejercicio62() {
        System.out.println("Lista: Colección ordenada de elementos que permite duplicados, donde cada elemento tiene una posición.");
        System.out.println("Operaciones típicas: add(), get(), remove(), set(), size(), isEmpty(), indexOf(), contains()");
    }

    public static void ejercicio63() {
        System.out.println("Formas de implementar una lista:");
        System.out.println("1. Con array dinámico (ArrayList): array interno que se redimensiona");
        System.out.println("2. Con nodos enlazados (LinkedList): cada nodo contiene dato y referencia al siguiente");
        System.out.println("3. Con array estático: capacidad fija");
        System.out.println("4. Con lista doblemente enlazada: nodos con referencia al anterior y siguiente");
    }

    public static void ejercicio64() {
        System.out.println("ArrayList:");
        System.out.println("  Ventajas: Acceso O(1), mejor localidad de caché, menos sobrecarga de memoria");
        System.out.println("  Inconvenientes: Inserción/eliminación en medio O(n), redimensionamiento costoso");
        System.out.println("LinkedList:");
        System.out.println("  Ventajas: Inserción/eliminación O(1) en cabecera/cola, no requiere redimensionamiento");
        System.out.println("  Inconvenientes: Acceso O(n), mayor consumo de memoria, peor localidad de caché");
    }

    public static void ejercicio65() {
        System.out.println("Relación: Collection → List → ArrayList y LinkedList");
        System.out.println("Collection es la interfaz raíz, List extiende Collection añadiendo comportamiento de lista,");
        System.out.println("ArrayList y LinkedList implementan la interfaz List con diferentes estrategias de almacenamiento.");
    }

    public static void ejercicio66() {
        System.out.println("Pila (Stack): Estructura de datos LIFO (Last In, First Out)");
        System.out.println("Operaciones típicas: push(), pop(), peek(), isEmpty(), size()");
    }

    public static void ejercicio67() {
        System.out.println("Aplicaciones de pilas:");
        System.out.println("1. Gestión de llamadas a funciones (call stack)");
        System.out.println("2. Evaluación de expresiones aritméticas");
        System.out.println("3. Deshacer/Rehacer (Undo/Redo)");
        System.out.println("4. Navegación web (historial)");
    }

    public static void ejercicio68() {
        System.out.println("Relación: La pila es un caso particular del TAD lista con restricciones.");
        System.out.println("Una pila puede implementarse usando una lista, limitando las operaciones a un extremo.");
        System.out.println("La lista es más general (permite inserción/eliminación en cualquier posición),");
        System.out.println("mientras que la pila sigue el principio LIFO.");
    }

    public static void ejercicio69() {
        System.out.println("Relación: Stack extiende Vector, Vector es una implementación antigua de lista sincronizada.");
        System.out.println("ArrayList es similar a Vector pero no sincronizado.");
        System.out.println("Stack está considerado como legado; se recomienda usar Deque.");
        
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        System.out.println("Stack después de push(1) y push(2): " + pila);
        System.out.println("peek(): " + pila.peek());
        pila.pop();
        System.out.println("Después de pop(): " + pila);
    }

    public static void ejercicio70() {
        System.out.println("Explicación: Se crea una pila, se apilan 1 y 2, peek muestra 2 sin eliminar,");
        System.out.println("pop elimina el 2, quedando solo el 1 en la pila.");
        
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        System.out.println("pila: " + pila);
        System.out.println("pila.peek(): " + pila.peek());
        pila.pop();
        System.out.println("pila después de pop(): " + pila);
    }

    public static void ejercicio71() {
        System.out.println("Cola (Queue): Estructura de datos FIFO (First In, First Out)");
        System.out.println("Operaciones típicas: add()/offer(), remove()/poll(), element()/peek(), isEmpty(), size()");
    }

    public static void ejercicio72() {
        System.out.println("Aplicaciones de colas:");
        System.out.println("1. Sistemas de impresión");
        System.out.println("2. Gestión de procesos en sistemas operativos");
        System.out.println("3. Mensajería asíncrona");
        System.out.println("4. Sistemas de turnos en bancos/hospitales");
    }

    public static void ejercicio73() {
        System.out.println("ArrayDeque utiliza un array circular con aritmética modular.");
        System.out.println("head = (head + 1) & (elements.length - 1) para avanzar cuando capacity es potencia de 2");
        System.out.println("head = (head - 1) & (elements.length - 1) para retroceder");
        System.out.println("Ventajas: permite inserciones en ambos extremos en O(1) sin desplazar elementos");
    }

    public static void ejercicio74() {
        System.out.println("Comparación con Stack: ArrayDeque como cola es FIFO, mientras que Stack es LIFO.");
        
        ArrayDeque<Integer> cola = new ArrayDeque<>();
        cola.add(1);
        cola.add(2);
        System.out.println("Cola después de add(1) y add(2): " + cola);
        System.out.println("peek(): " + cola.peek());
        System.out.println("poll(): " + cola.poll());
        System.out.println("Después de poll(): " + cola);
        
        System.out.println("\nDiferencia: Stack.pop() devuelve 2 (LIFO), Queue.poll() devuelve 1 (FIFO)");
    }

    public static void main(String[] args) {
        ejercicio61();
        ejercicio62();
        ejercicio63();
        ejercicio64();
        ejercicio65();
        ejercicio66();
        ejercicio67();
        ejercicio68();
        ejercicio69();
        ejercicio70();
        ejercicio71();
        ejercicio72();
        ejercicio73();
        ejercicio74();
    }
}