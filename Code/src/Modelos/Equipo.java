package Modelos;

public class Equipo {

    private int id;
    private String nombre_equipo;
    private String ciudad;

    public Equipo (){}

    public Equipo(int id, String nombre_equipo, String ciudad) {
        this.id = id;
        this.nombre_equipo = nombre_equipo;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        if (nombre_equipo != null && !nombre_equipo.trim().isEmpty()) {
            this.nombre_equipo = nombre_equipo.trim();
        }
        // Si está vacío o es null, no se asigna
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        if (ciudad != null && !ciudad.trim().isEmpty()) {
            this.ciudad = ciudad.trim();
        }
        // Si está vacío o es null, no se asigna
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre_equipo='" + nombre_equipo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
