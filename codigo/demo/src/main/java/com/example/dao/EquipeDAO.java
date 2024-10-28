package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.data.Equipe;
import com.example.data.Partida;

public class EquipeDAO extends CommonDAO<Equipe> {

    private Connection connection;

    public EquipeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Equipe equipe) {

        String insertQuery = "INSERT INTO equipe (equipe_name, campeonato_id) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, equipe.getEquipeNome());

            statement.setInt(2, equipe.getCampeonatoId());

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
    public void update(Equipe equipe) {

        String updateQuery = "UPDATE equipe SET equipe_name = ?, campeonato_id = ? WHERE equipe_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            statement.setString(1, equipe.getEquipeNome());
            statement.setInt(2, equipe.getCampeonatoId());
            statement.setInt(3, equipe.getEquipeId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String deleteQuery = "DELETE FROM equipe WHERE equipe_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipe getById(int id) {
        String selectQuery = "SELECT * FROM equipe WHERE partida_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToEquipe(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if not found or on failure
    }

    @Override
    public List<Equipe> getAll() {
        List<Equipe> equipes = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM equipe";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectAllQuery);
            while (resultSet.next()) {
                Equipe equipe = mapResultSetToEquipe(resultSet);
                equipes.add(equipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipes;
    }

    private Equipe mapResultSetToEquipe(ResultSet resultSet) throws SQLException {

        int equipeId = resultSet.getInt("equipe_id");
        String equipeName = resultSet.getString("equipe_name");
        int campeonatoId = resultSet.getInt("campeonato_id");

        return new Equipe(equipeId, equipeName, campeonatoId);
    }

    public Equipe getEquipeByName(String equipeName) {
        String selectQuery = "SELECT * FROM equipe WHERE equipe_name LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setString(1, "%" + equipeName + "%");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToEquipe(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Equipe> getAllByCampeonatoId(int campeonatoId) {
        List<Equipe> equipes = new ArrayList<>();
        String selectQuery = "SELECT * FROM equipe WHERE campeonato_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, campeonatoId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Equipe equipe = mapResultSetToEquipe(resultSet);
                equipes.add(equipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipes;
    }
}
