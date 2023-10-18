package abastecimiento;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private String idProveedor;
    private String nombre;
    private String empresa;
    private List<Materia_Prima> materiasPrimasSuministradas;

    public Proveedor(String idProveedor, String nombre, String empresa) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.empresa = empresa;
        this.materiasPrimasSuministradas = new ArrayList<>();
    }

    // Métodos getter y setter
    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public List<Materia_Prima> getMateriasPrimasSuministradas() {
        return materiasPrimasSuministradas;
    }

    public void agregarMateriaPrima(Materia_Prima materiaPrima) {
        materiasPrimasSuministradas.add(materiaPrima);
    }

    public void quitarMateriaPrima(Materia_Prima materiaPrima) {
        materiasPrimasSuministradas.remove(materiaPrima);
    }
}

