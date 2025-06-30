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
        if (idTorneo > 0) {
            this.idTorneo = idTorneo;
        }
        // Solo asigna si el ID es positivo
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        if (nombreTorneo != null && !nombreTorneo.trim().isEmpty()) {
            this.nombreTorneo = nombreTorneo.trim();
        }
        // Si está vacío o es null, no se asigna
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio >= 1900 && anio <= 2100) {
            this.anio = anio;
        }
        // Solo asigna si el año está en un rango razonable
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