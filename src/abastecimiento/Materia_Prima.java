package abastecimiento;

public class Materia_Prima {
    private String idMateriaPrima;
    private String tipoMateriaPrima;
    private double cantidad;
    private String unidadMedida;
    private Proveedor proveedor;
    private Bodega bodega;

    public Materia_Prima(String idMateriaPrima, String tipoMateriaPrima, double cantidad, String unidadMedida, Proveedor proveedor, Bodega bodega) {
        this.idMateriaPrima = idMateriaPrima;
        this.tipoMateriaPrima = tipoMateriaPrima;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.proveedor = proveedor;
        this.bodega = bodega;
    }

    // Métodos getter y setter
    public String getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(String idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getTipoMateriaPrima() {
        return tipoMateriaPrima;
    }

    public void setTipoMateriaPrima(String tipoMateriaPrima) {
        this.tipoMateriaPrima = tipoMateriaPrima;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}