package com.example.dao;

import com.example.data.Placar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlacarDAO extends CommonDAO<Placar> {

    private Connection connection;

    public PlacarDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Placar placar) {
        String insertQuery = "INSERT INTO placar (partida_id, placar_q1_casa, placar_q1_visitante, placar_q2_casa, " +
                "placar_q2_visitante, placar_q3_casa, placar_q3_visitante, placar_q4_casa, placar_q4_visitante, " +
                "prorrogacao_casa, prorrogacao_visitante, placar_total) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, placar.getPartidaId());
            statement.setInt(2, placar.getPlacarQ1Casa());
            statement.setInt(3, placar.getPlacarQ1Visitante());
            statement.setInt(4, placar.getPlacarQ2Casa());
            statement.setInt(5, placar.getPlacarQ2Visitante());
            statement.setInt(6, placar.getPlacarQ3Casa());
            statement.setInt(7, placar.getPlacarQ3Visitante());
            statement.setInt(8, placar.getPlacarQ4Casa());
            statement.setInt(9, placar.getPlacarQ4Visitante());
            statement.setInt(10, placar.getProrrogacaoCasa());
            statement.setInt(11, placar.getProrrogacaoVisitante());
            statement.setInt(12, placar.getPlacarTotal());

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
    public void update(Placar placar) {
        String updateQuery = "UPDATE placar SET placar_q1_casa = ?, placar_q1_visitante = ?, placar_q2_casa = ?, " +
                "placar_q2_visitante = ?, placar_q3_casa = ?, placar_q3_visitante = ?, placar_q4_casa = ?, " +
                "placar_q4_visitante = ?, prorrogacao_casa = ?, prorrogacao_visitante = ?, placar_total = ? " +
                "WHERE placar_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setInt(1, placar.getPlacarQ1Casa());
            statement.setInt(2, placar.getPlacarQ1Visitante());
            statement.setInt(3, placar.getPlacarQ2Casa());
            statement.setInt(4, placar.getPlacarQ2Visitante());
            statement.setInt(5, placar.getPlacarQ3Casa());
            statement.setInt(6, placar.getPlacarQ3Visitante());
            statement.setInt(7, placar.getPlacarQ4Casa());
            statement.setInt(8, placar.getPlacarQ4Visitante());
            statement.setInt(9, placar.getProrrogacaoCasa());
            statement.setInt(10, placar.getProrrogacaoVisitante());
            statement.setInt(11, placar.getPlacarTotal());
            statement.setInt(12, placar.getPlacarId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String deleteQuery = "DELETE FROM placar WHERE placar_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Placar getById(int id) {
        String selectQuery = "SELECT * FROM placar WHERE placar_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToPlacar(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if not found or on failure
    }

    public Placar getByPartidaId(int id) {
        String selectQuery = "SELECT * FROM placar WHERE partida_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToPlacar(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if not found or on failure
    }

    @Override
    public List<Placar> getAll() {
        List<Placar> placares = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM placar";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectAllQuery);
            while (resultSet.next()) {
                Placar placar = mapResultSetToPlacar(resultSet);
                placares.add(placar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placares;
    }

    private Placar mapResultSetToPlacar(ResultSet resultSet) throws SQLException {
        int placarId = resultSet.getInt("placar_id");
        int partidaId = resultSet.getInt("partida_id");
        int placarQ1Casa = resultSet.getInt("placar_q1_casa");
        int placarQ1Visitante = resultSet.getInt("placar_q1_visitante");
        int placarQ2Casa = resultSet.getInt("placar_q2_casa");
        int placarQ2Visitante = resultSet.getInt("placar_q2_visitante");
        int placarQ3Casa = resultSet.getInt("placar_q3_casa");
        int placarQ3Visitante = resultSet.getInt("placar_q3_visitante");
        int placarQ4Casa = resultSet.getInt("placar_q4_casa");
        int placarQ4Visitante = resultSet.getInt("placar_q4_visitante");
        Integer prorrogacaoCasa = resultSet.getInt("prorrogacao_casa");
        Integer prorrogacaoVisitante = resultSet.getInt("prorrogacao_visitante");
        int placarTotalCasa = resultSet.getInt("placar_total_casa");
        int placarTotalVisitante = resultSet.getInt("placar_total_visitante");
    
        return new Placar(placarId, partidaId, placarQ1Casa, placarQ1Visitante, placarQ2Casa, placarQ2Visitante,
                placarQ3Casa, placarQ3Visitante, placarQ4Casa, placarQ4Visitante, prorrogacaoCasa, prorrogacaoVisitante, placarTotalCasa, placarTotalVisitante);
    }

}
