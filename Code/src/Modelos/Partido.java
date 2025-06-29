package Modelos;

import java.util.Date;

public class Partido {

    private int idPartido;
    private Date fecha;
    private int idEquipoLocal;
    private int idEquipoVisitante;
    private int puntosLocal;
    private int puntosVisitante;
    private String fase;

    public Partido(int idPartido, Date fecha, int idEquipoLocal, int idEquipoVisitante, int puntosLocal, int puntosVisitante, String fase) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoVisitante = idEquipoVisitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.fase = fase;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(int idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public int getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    public void setIdEquipoVisitante(int idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "idPartido=" + idPartido +
                ", fecha=" + fecha +
                ", idEquipoLocal=" + idEquipoLocal +
                ", idEquipoVisitante=" + idEquipoVisitante +
                ", puntosLocal=" + puntosLocal +
                ", puntosVisitante=" + puntosVisitante +
                ", fase='" + fase + '\'' +
                '}';
    }
}
