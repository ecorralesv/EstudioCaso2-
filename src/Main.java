import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            AVL arbol = new AVL();
            Scanner sc = new Scanner(System.in);
            int opcion, valor;

            do {
                System.out.println("\n--- MENU AVL ---");
                System.out.println("1. Insertar");
                System.out.println("2. Buscar");
                System.out.println("3. Eliminar");
                System.out.println("4. Mostrar (InOrden)");
                System.out.println("5. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Valor a insertar: ");
                        valor = sc.nextInt();
                        arbol.insertar(valor);
                        break;
                    case 2:
                        System.out.print("Valor a buscar: ");
                        valor = sc.nextInt();
                        System.out.println(arbol.buscar(valor) != null ?
                                "Encontrado" : "No está en el árbol");
                        break;
                    case 3:
                        System.out.print("Valor a eliminar: ");
                        valor = sc.nextInt();
                        arbol.eliminar(valor);
                        break;
                    case 4:
                        arbol.enOrden();
                        break;
                }
            } while (opcion != 5);

            sc.close();
        }
    }
