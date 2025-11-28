package es.studium.AD2;

import java.sql.*;

public class ClientePersistenciaMCP {

    private static final String URL = "jdbc:mysql://localhost:3306/hotelMCP";
    private static final String USER = "root";
    private static final String PASSWORD = "Studium2024#";

    // ------------------------------ CREAR CLIENTE ------------------------------
    public static int crearCliente(String nombre, String apellidos, String email, String dni, String clave) {
        // Verificar duplicados
        if (existeCliente(email, dni)) {
            System.out.println("Error: El email o DNI ya existen.");
            return -1;
        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement()) {

            String sql = "INSERT INTO clienteMCP (nombre, apellidos, email, dni, clave) VALUES ('"
                    + nombre + "', '" + apellidos + "', '" + email + "', '" + dni + "', '" + clave + "')";

            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            // Obtener ID generado
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // si falla
    }

    // ------------------------------ VERIFICAR DUPLICADOS ------------------------------
    private static boolean existeCliente(String email, String dni) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement()) {

            String sql = "SELECT idCliente FROM clienteMCP WHERE email='" + email + "' OR dni='" + dni + "'";
            ResultSet rs = st.executeQuery(sql);
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ------------------------------ LEER CLIENTE ------------------------------
    public static String leerCliente(int idCliente, String campo) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement()) {

            String sql = "SELECT " + campo + " FROM clienteMCP WHERE idCliente=" + idCliente;
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(campo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ------------------------------ ACTUALIZAR CLIENTE ------------------------------
    public static boolean actualizarCliente(int idCliente, String campo, String nuevoValor) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement()) {

            String sql = "UPDATE clienteMCP SET " + campo + "='" + nuevoValor + "' WHERE idCliente=" + idCliente;
            int filas = st.executeUpdate(sql);
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ------------------------------ ELIMINAR CLIENTE ------------------------------
    public static boolean eliminarCliente(int idCliente) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement()) {

            String sql = "DELETE FROM clienteMCP WHERE idCliente=" + idCliente;
            int filas = st.executeUpdate(sql);
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
