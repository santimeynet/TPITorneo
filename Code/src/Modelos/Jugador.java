package Modelos;

public class Jugador {

    private int id;
    private String nombre;
    private String apellido;
    private int nro_camiste;
    private String posicion;
    private Equipo equipo;

    public Jugador(){}

    public Jugador(int id, String nombre, String apellido, int nro_camiste, String posicion, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nro_camiste = nro_camiste;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNro_camiste() {
        return nro_camiste;
    }

    public void setNro_camiste(int nro_camiste) {
        this.nro_camiste = nro_camiste;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nro_camiste=" + nro_camiste +
                ", posicion='" + posicion + '\'' +
                ", equipo=" + equipo +
                '}';
    }
}
