package com.example.data;

import java.util.List;

public class Campeonato {
    private int campeonatoId;
    private List<Equipe> campeonatoEquipes;

    /**
     * Constructor to initialize a Campeonato object with specified attributes.
     *
     * @param campeonatoId
     * @param campeonatoEquipes
     */

    public Campeonato(int campeonatoId, List<Equipe> campeonatoEquipes) {
        this.campeonatoId = campeonatoId;
        this.campeonatoEquipes = campeonatoEquipes;
    }


    /**
     * @return int return the campeonatoId
     */
    public int getCampeonatoId() {
        return campeonatoId;
    }

    /**
     * @param campeonatoId the campeonatoId to set
     */
    public void setCampeonatoId(int campeonatoId) {
        this.campeonatoId = campeonatoId;
    }

    /**
     * @return List<Equipe> return the campeonatoEquipes
     */
    public List<Equipe> getCampeonatoEquipes() {
        return campeonatoEquipes;
    }

    /**
     * @param campeonatoEquipes the campeonatoEquipes to set
     */
    public void setCampeonatoEquipes(List<Equipe> campeonatoEquipes) {
        this.campeonatoEquipes = campeonatoEquipes;
    }

}
