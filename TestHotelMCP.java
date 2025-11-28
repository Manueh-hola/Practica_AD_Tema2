	package es.studium.AD2;
	
	import java.util.Scanner;
	
	public class TestHotelMCP {
	    public static void main(String[] args) {
	
	        Scanner teclado = new Scanner(System.in);
	        boolean salir = false;
	
	        while (!salir) {
	            System.out.println("\n=== MENÚ HOTEL ===");
	            System.out.println("1. Crear cliente");
	            System.out.println("2. Leer cliente");
	            System.out.println("3. Actualizar cliente");
	            System.out.println("4. Eliminar cliente");
	            System.out.println("0. Salir");
	            System.out.print("Elige una opción: ");
	
	            String opcion = teclado.nextLine();
	
	            if (opcion.equals("1")) {
	                crearCliente(teclado);
	            } else if (opcion.equals("2")) {
	                leerCliente(teclado);
	            } else if (opcion.equals("3")) {
	                actualizarCliente(teclado);
	            } else if (opcion.equals("4")) {
	                eliminarCliente(teclado);
	            } else if (opcion.equals("0")) {
	                salir = true;
	                System.out.println("Saliendo...");
	            } else {
	                System.out.println("Error: opción no válida, intenta de nuevo.");
	            }
	        }
	
	        teclado.close();
	    }
	
	    // ------------------------------ CREAR CLIENTE ------------------------------
	    private static void crearCliente(Scanner teclado) {
	        System.out.println("\n=== REGISTRO DE CLIENTE ===");
	
	        System.out.print("Nombre: ");
	        String nombre = teclado.nextLine();
	        System.out.print("Apellidos: ");
	        String apellidos = teclado.nextLine();
	        System.out.print("Email: ");
	        String email = teclado.nextLine();
	        System.out.print("DNI: ");
	        String dni = teclado.nextLine();
	        System.out.print("Clave: ");
	        String clave = teclado.nextLine();
	
	        if (nombre.trim().isEmpty() || apellidos.trim().isEmpty() || email.trim().isEmpty()|| dni.trim().isEmpty() || clave.trim().isEmpty()) {
	            System.out.println("Error: No puedes dejar campos vacíos.");
	        } else {
	            int id = ClientePersistenciaMCP.crearCliente(nombre, apellidos, email, dni, clave);
	            if (id != -1) {
	                System.out.println("Cliente guardado correctamente con ID: " + id);
	            } else {
	                System.out.println("Error al guardar el cliente.");
	            }
	        }
	    }
	
	    // ------------------------------ LEER CLIENTE ------------------------------
	    private static void leerCliente(Scanner teclado) {
	        System.out.print("\nIngresa el ID del cliente a leer: ");
	        int id = Integer.parseInt(teclado.nextLine());
	
	        System.out.print("Campo a leer (nombre, apellidos, email, dni, clave): ");
	        String campo = teclado.nextLine();
	
	        String valor = ClientePersistenciaMCP.leerCliente(id, campo);
	        if (valor != null) {
	            System.out.println(campo + ": " + valor);
	        } else {
	            System.out.println("Cliente no encontrado o campo inválido.");
	        }
	    }
	
	    // ------------------------------ ACTUALIZAR CLIENTE ------------------------------
	    private static void actualizarCliente(Scanner teclado) {
	        System.out.print("\nIngresa el ID del cliente a actualizar: ");
	        int id = Integer.parseInt(teclado.nextLine());
	
	        System.out.print("Campo a actualizar (nombre, apellidos, email, dni, clave): ");
	        String campo = teclado.nextLine();
	
	        System.out.print("Nuevo valor: ");
	        String nuevoValor = teclado.nextLine();
	
	        if (nuevoValor.trim().isEmpty()) {
	            System.out.println("Error: El valor no puede estar vacío.");
	        } else {
	            boolean actualizado = ClientePersistenciaMCP.actualizarCliente(id, campo, nuevoValor);
	            if (actualizado) {
	                System.out.println("Cliente actualizado correctamente.");
	            } else {
	                System.out.println("Error al actualizar el cliente.");
	            }
	        }
	    }
	
	    // ------------------------------ ELIMINAR CLIENTE ------------------------------
	    private static void eliminarCliente(Scanner teclado) {
	        System.out.print("\nIngresa el ID del cliente a eliminar: ");
	        int id = Integer.parseInt(teclado.nextLine());
	
	        boolean eliminado = ClientePersistenciaMCP.eliminarCliente(id);
	        if (eliminado) {
	            System.out.println("Cliente eliminado correctamente.");
	        } else {
	            System.out.println("Error al eliminar el cliente.");
	        }
	    }
	}
