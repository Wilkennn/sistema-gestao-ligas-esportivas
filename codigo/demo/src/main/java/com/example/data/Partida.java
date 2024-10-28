package com.example.data;

import java.util.Date;

/**
 * The Partida class represents a sports match.
 */
public class Partida {

    private int partidaId; // Identifier for the match
    private Date partidaData; // Date of the match (consider using a Date object)
    private int partidaEquipeCasaId; // ID of the home team
    private int partidaEquipeVisitanteId; // ID of the visiting team
    private int placarId; // Score of the home team
    private int campeonatoId; // Score of the home team

    /**
     * Constructor to initialize a Partida object with specified attributes.
     *
     * @param partidaId                   The ID of the match.
     * @param partidaData                 The date of the match.
     * @param partidaEquipeCasaId         The ID of the home team.
     * @param partidaEquipeVisitanteId    The ID of the visiting team.
     * @param partidaEquipeCasaPlacar     The score of the home team.
     * @param partidaEquipeVisitantePlacar The score of the visiting team.
     * @param campeonatoId
     */

    public Partida(Date partidaData, int partidaEquipeCasaId, int partidaEquipeVisitanteId, int campeonatoId) {
        this.partidaData = partidaData;
        this.partidaEquipeCasaId = partidaEquipeCasaId;
        this.partidaEquipeVisitanteId = partidaEquipeVisitanteId;
        this.campeonatoId = campeonatoId;
    }
    
    public Partida(int partidaId, Date partidaData, int partidaEquipeCasaId, int partidaEquipeVisitanteId, int placarId, int campeonatoId) {
        this.partidaId = partidaId;
        this.partidaData = partidaData;
        this.partidaEquipeCasaId = partidaEquipeCasaId;
        this.partidaEquipeVisitanteId = partidaEquipeVisitanteId;
        this.placarId = placarId;
        this.campeonatoId = campeonatoId;
    }

    /**
     * Gets the ID of the match.
     *
     * @return The ID of the match.
     */
    public int getPartidaId() {
        return partidaId;
    }

    /**
     * Sets the ID of the match.
     *
     * @param partidaId The ID of the match.
     */
    public void setPartidaId(int partidaId) {
        this.partidaId = partidaId;
    }

    /**
     * Gets the date of the match.
     *
     * @return The date of the match.
     */
    public Date getPartidaData() {
        return partidaData;
    }

    /**
     * Sets the date of the match.
     *
     * @param partidaData The date of the match.
     */
    public void setPartidaData(Date partidaData) {
        this.partidaData = partidaData;
    }

    /**
     * Gets the ID of the home team.
     *
     * @return The ID of the home team.
     */
    public int getPartidaEquipeCasaId() {
        return partidaEquipeCasaId;
    }

    /**
     * Sets the ID of the home team.
     *
     * @param partidaEquipeCasaId The ID of the home team.
     */
    public void setPartidaEquipeCasaId(int partidaEquipeCasaId) {
        this.partidaEquipeCasaId = partidaEquipeCasaId;
    }

    /**
     * Gets the ID of the visiting team.
     *
     * @return The ID of the visiting team.
     */
    public int getPartidaEquipeVisitanteId() {
        return partidaEquipeVisitanteId;
    }

    /**
     * Sets the ID of the visiting team.
     *
     * @param partidaEquipeVisitanteId The ID of the visiting team.
     */
    public void setPartidaEquipeVisitanteId(int partidaEquipeVisitanteId) {
        this.partidaEquipeVisitanteId = partidaEquipeVisitanteId;
    }

    /**
     * Gets the score of the home team.
     *
     * @return The score of the home team.
     */
    public int getPlacarId() {
        return placarId;
    }

    /**
     * Sets the score of the home team.
     *
     * @param placarId The score of the home team.
     */
    public void setPlacarId(int placarId) {
        this.placarId = placarId;
    }
        
    public int getCampeonatoId() {
        return campeonatoId;
    }

    public void setCampeonatoId(int campeonatoId) {
        this.campeonatoId = campeonatoId;
    }

}
