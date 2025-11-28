package es.studium.AD2;

public class ClienteMCP {
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String email;
    private String dni;
    private String clave;

    public ClienteMCP(int idCliente, String nombre, String apellidos,
                      String email, String dni, String clave) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.dni = dni;
        this.clave = clave;
    }

    public int getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getEmail() { return email; }
    public String getDni() { return dni; }
    public String getClave() { return clave; }

    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setEmail(String email) { this.email = email; }
    public void setDni(String dni) { this.dni = dni; }
    public void setClave(String clave) { this.clave = clave; }
}
