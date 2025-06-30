package Modelos;

public class Torneo {

    private int idTorneo;
    private String nombreTorneo;
    private int anio;


    public Torneo() {
    }

    public Torneo(int idTorneo, String nombreTorneo, int anio) {
        this.idTorneo = idTorneo;
        this.nombreTorneo = nombreTorneo;
        this.anio = anio;
    }

    // Getters y Setters

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "idTorneo=" + idTorneo +
                ", nombreTorneo='" + nombreTorneo + '\'' +
                ", anio=" + anio +
                '}';
    }
}
