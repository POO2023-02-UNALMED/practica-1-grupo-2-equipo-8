package compras;

public class Cliente {
    private String idCliente;
    private String nombre;
    private String correo; 
    private String tipoPersona; // Puede ser "Natural" o "Jurídica"

    public Cliente(String idCliente, String nombre, String correo, String tipoPersona) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.tipoPersona = tipoPersona;
    }
    
    // Métodos

    // Métodos getter y setter
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}
