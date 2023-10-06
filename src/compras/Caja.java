package compras;

public class Caja {
    private String idCaja;
    private double dineroDisponible;

    public Caja(String idCaja, double dineroDisponible) {
        this.idCaja = idCaja;
        this.dineroDisponible = dineroDisponible;
    }

    // Métodos getter y setter
    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
    }

    public double getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }
}
