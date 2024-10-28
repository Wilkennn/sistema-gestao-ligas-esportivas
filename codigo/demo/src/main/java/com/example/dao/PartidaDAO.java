package com.example.dao;

import com.example.data.Partida;
import com.example.data.Placar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PartidaDAO extends CommonDAO<Partida> {

    private Connection connection;

    public PartidaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Partida partida) {
        String insertQuery = "INSERT INTO partida (partida_data, partida_equipe_casa_id, partida_equipe_visitante_id, "
                +
                "placar_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            statement.setTimestamp(1, new Timestamp(partida.getPartidaData().getTime()));
            statement.setInt(2, partida.getPartidaEquipeCasaId());
            statement.setInt(3, partida.getPartidaEquipeVisitanteId());

            Placar placar = new Placar(partida.getPartidaId(), partida.getPartidaEquipeCasaId(),
                    partida.getPartidaEquipeVisitanteId(),
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            PlacarDAO placarDAO = new PlacarDAO(connection);
            int placarId = placarDAO.create(placar);

            if (placarId == -1) {
                throw new RuntimeException("Algo deu errado, tente mais tarde!");
            }

            statement.setInt(4, placarId);

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 on failure
    }

    @Override
    public void update(Partida partida) {
        String updateQuery = "UPDATE partida SET partida_data = ?, partida_equipe_casa_id = ?, partida_equipe_visitante_id = ?, "
                + "partida_placar_id = ? WHERE partida_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setTimestamp(1, new Timestamp(partida.getPartidaData().getTime()));
            statement.setInt(2, partida.getPartidaEquipeCasaId());
            statement.setInt(3, partida.getPartidaEquipeVisitanteId());
            statement.setInt(4, partida.getPlacarId());
            statement.setInt(5, partida.getPartidaId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String deleteQuery = "DELETE FROM partida WHERE partida_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partida getById(int id) {
        String selectQuery = "SELECT * FROM partida WHERE partida_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToPartida(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if not found or on failure
    }

    @Override
    public List<Partida> getAll() {
        List<Partida> partidas = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM partida";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectAllQuery);
            while (resultSet.next()) {
                Partida partida = mapResultSetToPartida(resultSet);
                partidas.add(partida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidas;
    }

    public List<Partida> getPartidasByEquipeId(int equipeId) {
        List<Partida> partidas = new ArrayList<>();
        String selectQuery = "SELECT * FROM partida WHERE partida_equipe_casa_id = ? OR partida_equipe_visitante_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, equipeId);
            statement.setInt(2, equipeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Partida partida = mapResultSetToPartida(resultSet);
                partidas.add(partida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidas;
    }

    public List<Partida> getAllByCampeonatoId(int campeonatoId) {
        List<Partida> partidas = new ArrayList<>();
        String selectQuery = "SELECT * FROM partida WHERE partida_campeonato = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, campeonatoId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Partida partida = mapResultSetToPartida(resultSet);
                partidas.add(partida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidas;
    }

    private Partida mapResultSetToPartida(ResultSet resultSet) throws SQLException {

        int partidaId = resultSet.getInt("partida_id");
        Timestamp partidaData = resultSet.getTimestamp("partida_data");
        int partidaEquipeCasaId = resultSet.getInt("partida_equipe_casa_id");
        int partidaEquipeVisitanteId = resultSet.getInt("partida_visitante_id");
        int placarId = resultSet.getInt("placar_id");
        int campeonatoId = resultSet.getInt("partida_campeonato_id");

        return new Partida(partidaId, partidaData, partidaEquipeCasaId, partidaEquipeVisitanteId, placarId, campeonatoId);
    }
}
