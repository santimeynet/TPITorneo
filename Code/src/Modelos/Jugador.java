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
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
        // Si está vacío o es null, no se asigna
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()) {
            this.apellido = apellido.trim();
        }
        // Si está vacío o es null, no se asigna
    }

    public int getNro_camiste() {
        return nro_camiste;
    }

    public void setNro_camiste(int nro_camiste) {
        if (nro_camiste > 0) {
            this.nro_camiste = nro_camiste;
        }
        // Solo asigna si el número es positivo
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        if (posicion != null && !posicion.trim().isEmpty()) {
            this.posicion = posicion.trim();
        }
        // Si está vacío o es null, no se asigna
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
