package com.example.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.example.dao.MySQLDBHandler;
import com.example.dao.PartidaDAO;

public class Equipe {
    private int equipeId;
    private String equipeNome;
    private List<Partida> equipePartidas;
    private int campeonatoId;

    /**
     * Constructor to initialize a Equipe object with specified attributes.
     *
     * @param equipeId
     * @param equipeNome
     * @param equipePartidas
     * @param campeonatoId
     */
    public Equipe(int equipeId, String equipeNome, int campeonatoId) {
        this.equipeId = equipeId;
        this.equipeNome = equipeNome;
        this.campeonatoId = campeonatoId;
    }

    /**
     * @return int return the equipeId
     */
    public int getEquipeId() {
        return equipeId;
    }

    /**
     * @param equipeId the equipeId to set
     */
    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }

    /**
     * @return String return the equipeNome
     */
    public String getEquipeNome() {
        return equipeNome;
    }

    /**
     * @param equipeNome the equipeNome to set
     */
    public void setEquipeNome(String equipeNome) {
        this.equipeNome = equipeNome;
    }

    /**
     * @return List<Partida> return the equipePartidas
     */
    public List<Partida> getEquipePartidas() {

        try (Connection connection = MySQLDBHandler.getConnection()) {

            PartidaDAO partidaDAO = new PartidaDAO(connection);

            List<Partida> partidasList = partidaDAO.getPartidasByEquipeId(this.getEquipeId());

            return partidasList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipePartidas;
    }

    public int getCampeonatoId() {
        return campeonatoId;
    }

    public void setCampeonatoId(int campeonatoId) {
        this.campeonatoId = campeonatoId;
    }

}
