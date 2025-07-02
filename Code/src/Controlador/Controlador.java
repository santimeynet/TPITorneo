package Controlador;

import Vistas.Vista;
import Modelos.Equipo;
import Modelos.Jugador;
import Modelos.Torneo;
import Conexion.Conexion;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controlador {
    private Vista vista = new Vista();

    public void iniciar() {
        vista.mostrarMensaje("Bienvenido al sistema de torneos.");
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = vista.getOpcion();

            switch (opcion) {
                case 1:
                    registrarEquipo();
                    break;
                case 2:
                    registrarJugador();
                    break;
                case 3:
                    listarEquipos();
                    break;
                case 4:
                    listarJugadores();
                    break;
                case 5:
                    iniciarTorneo();
                    break;
                case 6:
                    listarTorneos();
                    break;
                case 0:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void registrarEquipo() {
        String nombre = vista.pedirNombre("Equipo");
        String ciudad = vista.pedirNombre("Ciudad");

        try (Connection con = Conexion.getConnection()) {
            String sql = "INSERT INTO Equipo (nombre_equipo, ciudad) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, ciudad);
            ps.executeUpdate();

            vista.mostrarMensaje("Equipo registrado con éxito.");

        } catch (Exception e) {
            vista.mostrarMensaje("Error al registrar equipo: " + e.getMessage());
        }
    }

    private void registrarJugador() {
        String nombre = vista.pedirNombre("Jugador");
        String apellido = vista.pedirApellido("Jugador");
        String posicion = vista.pedirPosicion("Jugador");
        int nro_camiseta = vista.pedirEdad();
        int idEquipo = vista.pedirId("Equipo al que pertenece");

        try (Connection con = Conexion.getConnection()) {
            String sql = "INSERT INTO Jugador (nombre, apellido, nro_camiseta, posicion, id_equipo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, nro_camiseta);
            ps.setString(4, posicion);
            ps.setInt(5, idEquipo);
            ps.executeUpdate();

            vista.mostrarMensaje("Jugador registrado con éxito.");

        } catch (Exception e) {
            vista.mostrarMensaje("Error al registrar jugador: " + e.getMessage());
        }
    }

    private void listarEquipos() {
        vista.mostrarMensaje("=== LISTA DE EQUIPOS Y SUS JUGADORES ===");

        String sqlEquipos = "SELECT * FROM Equipo";
        String sqlJugadores = "SELECT nombre, apellido, nro_camiseta, posicion FROM Jugador WHERE id_equipo = ?";

        try (Connection con = Conexion.getConnection();
             Statement stEquipos = con.createStatement();
             ResultSet rsEquipos = stEquipos.executeQuery(sqlEquipos)) {

            while (rsEquipos.next()) {
                int id = rsEquipos.getInt("id_equipo");
                String nombre = rsEquipos.getString("nombre_equipo");
                String ciudad = rsEquipos.getString("ciudad");

                vista.mostrarMensaje("\nEquipo: " + nombre + " (ID: " + id + ") | Ciudad: " + ciudad);

                //consultar jugadores del equipo
                PreparedStatement psJugadores = con.prepareStatement(sqlJugadores);
                psJugadores.setInt(1, id);
                ResultSet rsJugadores = psJugadores.executeQuery();

                boolean tieneJugadores = false;
                while (rsJugadores.next()) {
                    tieneJugadores = true;
                    String nombreJugador = rsJugadores.getString("nombre");
                    String apellido = rsJugadores.getString("apellido");
                    int camiseta = rsJugadores.getInt("nro_camiseta");
                    String posicion = rsJugadores.getString("posicion");

                    vista.mostrarMensaje("   - 👤 " + nombreJugador + " " + apellido + " | #" + camiseta + " | " + posicion);
                }

                if (!tieneJugadores) {
                    vista.mostrarMensaje("   (Sin jugadores registrados)");
                }

                rsJugadores.close();
                psJugadores.close();
            }

        } catch (Exception e) {
            vista.mostrarMensaje("Error al listar equipos: " + e.getMessage());
        }
    }


    private void listarJugadores() {
        vista.mostrarMensaje("=== LISTA DE JUGADORES ===");
        String sql = "SELECT * FROM Jugador";

        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id_jugador");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("Apellido");
                int idEquipo = rs.getInt("id_equipo");

                vista.mostrarMensaje("ID: " + id + " | Nombre: " + nombre + " | Apellido: " + apellido + " | Equipo ID: " + idEquipo);
            }

        } catch (Exception e) {
            vista.mostrarMensaje("Error al listar jugadores: " + e.getMessage());
        }
    }


    private void iniciarTorneo() {
        String nombreTorneo = vista.pedirNombre("Torneo");
        int anio = vista.pedirAnio();

        try (Connection con = Conexion.getConnection()) {
            //crear torneo
            String sql = "INSERT INTO Torneo (nombre_torneo, año) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombreTorneo);
            ps.setInt(2, anio);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int idTorneo = 0;
            if (rs.next()) {
                idTorneo = rs.getInt(1);
            }

            vista.mostrarMensaje("Torneo registrado con ID: " + idTorneo);

            // ingresar los 8 participantes
            List<Integer> equipos = new ArrayList<>();
            vista.mostrarMensaje("\n=== Ingreso de 8 equipos participantes (por ID) ===");
            for (int i = 1; i <= 8; i++) {
                int idEquipo = vista.pedirId("Equipo #" + i);
                equipos.add(idEquipo);
            }

            // cuartos de final
            vista.mostrarMensaje("\n=== Cuartos de Final ===");
            List<Integer> semifinalistas = new ArrayList<>();
            for (int i = 0; i < equipos.size(); i += 2) {
                int equipo1 = equipos.get(i);
                int equipo2 = equipos.get(i + 1);

                String nombreEquipo1 = obtenerNombreEquipo(con, equipo1);
                String nombreEquipo2 = obtenerNombreEquipo(con, equipo2);
                vista.mostrarMensaje("Partido: " + nombreEquipo1 + " vs " + nombreEquipo2);

                int puntos1 = vista.pedirPuntosUno(); // reutilizado como pedir puntos
                int puntos2 = vista.pedirPuntosDos();

                int ganador = (puntos1 > puntos2) ? equipo1 : equipo2;
                semifinalistas.add(ganador);

                registrarPartido(con, equipo1, equipo2, puntos1, puntos2, "Cuartos", idTorneo);
            }

            // semis
            vista.mostrarMensaje("\n=== Semifinales ===");
            List<Integer> finalistas = new ArrayList<>();
            for (int i = 0; i < semifinalistas.size(); i += 2) {
                int equipo1 = semifinalistas.get(i);
                int equipo2 = semifinalistas.get(i + 1);

                String nombreEquipo1 = obtenerNombreEquipo(con, equipo1);
                String nombreEquipo2 = obtenerNombreEquipo(con, equipo2);
                vista.mostrarMensaje("Partido: " + nombreEquipo1 + " vs " + nombreEquipo2);

                int puntos1 = vista.pedirPuntosUno();
                int puntos2 = vista.pedirPuntosDos();

                int ganador = (puntos1 > puntos2) ? equipo1 : equipo2;
                finalistas.add(ganador);

                registrarPartido(con, equipo1, equipo2, puntos1, puntos2, "Semis", idTorneo);
            }

            // final
            vista.mostrarMensaje("\n=== Final ===");
            int equipo1 = finalistas.get(0);
            int equipo2 = finalistas.get(1);

            String nombreEquipo1 = obtenerNombreEquipo(con, equipo1);
            String nombreEquipo2 = obtenerNombreEquipo(con, equipo2);
            vista.mostrarMensaje("Partido: " + nombreEquipo1 + " vs " + nombreEquipo2);

            int puntos1 = vista.pedirPuntosUno();
            int puntos2 = vista.pedirPuntosDos();

            int campeon = (puntos1 > puntos2) ? equipo1 : equipo2;
            registrarPartido(con, equipo1, equipo2, puntos1, puntos2, "Final", idTorneo);

            //actualizar torneo con el equipo campeon
            String updateSql = "UPDATE Torneo SET ganador = ? WHERE id_torneo = ?";
            PreparedStatement updatePs = con.prepareStatement(updateSql);
            updatePs.setInt(1, campeon);
            updatePs.setInt(2, idTorneo);
            updatePs.executeUpdate();

            vista.mostrarMensaje("El equipo campeón fue guardado en el torneo.");



            String nombreCampeon = obtenerNombreEquipo(con, campeon);
            vista.mostrarMensaje("\n¡El equipo campeón es: " + nombreCampeon + "!");


        } catch (Exception e) {
            vista.mostrarMensaje("Error al iniciar torneo: " + e.getMessage());
        }

    }

    private String obtenerNombreEquipo(Connection con, int idEquipo) {
        String nombre = "Desconocido";
        try {
            String sql = "SELECT nombre_equipo FROM Equipo WHERE id_equipo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre_equipo");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error al obtener nombre del equipo: " + e.getMessage());
        }
        return nombre;
    }


    private void registrarPartido(Connection con, int idLocal, int idVisitante, int puntosLocal, int puntosVisitante, String fase, int idTorneo) {
        try {
            String sql = "INSERT INTO Partido (fecha, id_torneo, id_equipo_local, id_equipo_visitante, puntos_local, puntos_visitante, fase) " +
                    "VALUES (CURDATE(), ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTorneo);
            ps.setInt(2, idLocal);
            ps.setInt(3, idVisitante);
            ps.setInt(4, puntosLocal);
            ps.setInt(5, puntosVisitante);
            ps.setString(6, fase);
            ps.executeUpdate();

            vista.mostrarMensaje("Partido registrado en fase " + fase);
        } catch (Exception e) {
            vista.mostrarMensaje("Error al registrar partido: " + e.getMessage());
        }
    }



    private void listarTorneos() {
        vista.mostrarMensaje("=== LISTA DE TORNEOS ===");
        String sql = "SELECT t.id_torneo, t.nombre_torneo, t.año, e.nombre_equipo AS nombre_ganador " +
                "FROM Torneo t " +
                "LEFT JOIN Equipo e ON t.ganador = e.id_equipo";

        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id_torneo");
                String nombre = rs.getString("nombre_torneo");
                int anio = rs.getInt("año");
                String nombre_ganador = rs.getString("nombre_ganador");

                vista.mostrarMensaje("ID: " + id + " | Nombre: " + nombre + " | Año: " + anio + " | Ganador: " + nombre_ganador);
            }

        } catch (Exception e) {
            vista.mostrarMensaje("Error al listar torneos: " + e.getMessage());
        }
    }
}

