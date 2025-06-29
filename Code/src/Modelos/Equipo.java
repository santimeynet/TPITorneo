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
        this.nombre_equipo = nombre_equipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
