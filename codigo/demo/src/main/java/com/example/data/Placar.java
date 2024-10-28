package com.example.data;

/**
 * The Placar class represents a sports match score.
 */
public class Placar {

    private int placarId; // Identifier for the score
    private int partidaId; // Date of the match (consider using a Date object)
    private int placarQ1Casa; // Score of the home team in 1st quarter
    private int placarQ1Visitante; // Score of the visiting team in 1st quarter
    private int placarQ2Casa; // Score of the home team in 2nd quarter
    private int placarQ2Visitante; // Score of the visiting team in 2nd quarter
    private int placarQ3Casa; // Score of the home team in 3rd quarter
    private int placarQ3Visitante; // Score of the visiting team in 3rd quarter
    private int placarQ4Casa; // Score of the home team in 4th quarter
    private int placarQ4Visitante; // Score of the visiting team in 4th quarter
    private int prorrogacaoCasa; // Overtime score of the home team
    private int prorrogacaoVisitante; // Overtime score of the visiting team
    private int placarTotalCasa; // Total score Casa
    private int placarTotalVisitante;

    /**
     * Constructor to initialize a Placar object with specified attributes.
     *
     * @param placarId                The ID of the score.
     * @param partidaId               The id of the match.
     * @param placarQ1Casa            Score of the home team in 1st quarter.
     * @param placarQ1Visitante       Score of the visiting team in 1st quarter.
     * @param placarQ2Casa            Score of the home team in 2nd quarter.
     * @param placarQ2Visitante       Score of the visiting team in 2nd quarter.
     * @param placarQ3Casa            Score of the home team in 3rd quarter.
     * @param placarQ3Visitante       Score of the visiting team in 3rd quarter.
     * @param placarQ4Casa            Score of the home team in 4th quarter.
     * @param placarQ4Visitante       Score of the visiting team in 4th quarter.
     * @param prorrogacaoCasa         Overtime score of the home team.
     * @param prorrogacaoVisitante    Overtime score of the visiting team.
     * @param placarTotalCasa             Total score.
     * @param placarTotalVisitante
     */
    public Placar(int partidaId, int placarQ1Casa, int placarQ1Visitante, int placarQ2Casa, int placarQ2Visitante,
            int placarQ3Casa, int placarQ3Visitante, int placarQ4Casa, int placarQ4Visitante,
            int prorrogacaoCasa, int prorrogacaoVisitante, int placarTotalCasa, int placarTotalVisitante) {
        this.partidaId = partidaId;
        this.placarQ1Casa = placarQ1Casa;
        this.placarQ1Visitante = placarQ1Visitante;
        this.placarQ2Casa = placarQ2Casa;
        this.placarQ2Visitante = placarQ2Visitante;
        this.placarQ3Casa = placarQ3Casa;
        this.placarQ3Visitante = placarQ3Visitante;
        this.placarQ4Casa = placarQ4Casa;
        this.placarQ4Visitante = placarQ4Visitante;
        this.prorrogacaoCasa = prorrogacaoCasa;
        this.prorrogacaoVisitante = prorrogacaoVisitante;
        this.placarTotalCasa = placarTotalCasa;
        this.placarTotalVisitante = placarTotalVisitante;
    }

    public Placar(int placarId, int partidaId,
            int placarQ1Casa, int placarQ1Visitante, int placarQ2Casa, int placarQ2Visitante,
            int placarQ3Casa, int placarQ3Visitante, int placarQ4Casa, int placarQ4Visitante,
            int prorrogacaoCasa, int prorrogacaoVisitante, int placarTotalCasa, int placarTotalVisitante) {
        this.placarId = placarId;
        this.partidaId = partidaId;
        this.placarQ1Casa = placarQ1Casa;
        this.placarQ1Visitante = placarQ1Visitante;
        this.placarQ2Casa = placarQ2Casa;
        this.placarQ2Visitante = placarQ2Visitante;
        this.placarQ3Casa = placarQ3Casa;
        this.placarQ3Visitante = placarQ3Visitante;
        this.placarQ4Casa = placarQ4Casa;
        this.placarQ4Visitante = placarQ4Visitante;
        this.prorrogacaoCasa = prorrogacaoCasa;
        this.prorrogacaoVisitante = prorrogacaoVisitante;
        this.placarTotalCasa = placarTotalCasa;
        this.placarTotalVisitante = placarTotalVisitante;
    }

    /**
     * Gets the ID of the score.
     *
     * @return The ID of the score.
     */
    public int getPlacarId() {
        return placarId;
    }

    /**
     * Sets the ID of the score.
     *
     * @param placarId The ID of the score.
     */
    public void setPlacarId(int placarId) {
        this.placarId = placarId;
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
     * Gets the score of the home team in the 1st quarter.
     *
     * @return The score of the home team in the 1st quarter.
     */
    public int getPlacarQ1Casa() {
        return placarQ1Casa;
    }

    /**
     * Sets the score of the home team in the 1st quarter.
     *
     * @param placarQ1Casa The score of the home team in the 1st quarter.
     */
    public void setPlacarQ1Casa(int placarQ1Casa) {
        this.placarQ1Casa = placarQ1Casa;
    }

    /**
     * Gets the score of the visiting team in the 1st quarter.
     *
     * @return The score of the visiting team in the 1st quarter.
     */
    public int getPlacarQ1Visitante() {
        return placarQ1Visitante;
    }

    /**
     * Sets the score of the visiting team in the 1st quarter.
     *
     * @param placarQ1Visitante The score of the visiting team in the 1st quarter.
     */
    public void setPlacarQ1Visitante(int placarQ1Visitante) {
        this.placarQ1Visitante = placarQ1Visitante;
    }

    /**
     * Gets the score of the home team in the 2nd quarter.
     *
     * @return The score of the home team in the 2nd quarter.
     */
    public int getPlacarQ2Casa() {
        return placarQ2Casa;
    }

    /**
     * Sets the score of the home team in the 2nd quarter.
     *
     * @param placarQ2Casa The score of the home team in the 2nd quarter.
     */
    public void setPlacarQ2Casa(int placarQ2Casa) {
        this.placarQ2Casa = placarQ2Casa;
    }

    /**
     * Gets the score of the visiting team in the 2nd quarter.
     *
     * @return The score of the visiting team in the 2nd quarter.
     */
    public int getPlacarQ2Visitante() {
        return placarQ2Visitante;
    }

    /**
     * Sets the score of the visiting team in the 2nd quarter.
     *
     * @param placarQ2Visitante The score of the visiting team in the 2nd quarter.
     */
    public void setPlacarQ2Visitante(int placarQ2Visitante) {
        this.placarQ2Visitante = placarQ2Visitante;
    }

    /**
     * Gets the score of the home team in the 3rd quarter.
     *
     * @return The score of the home team in the 3rd quarter.
     */
    public int getPlacarQ3Casa() {
        return placarQ3Casa;
    }

    /**
     * Sets the score of the home team in the 3rd quarter.
     *
     * @param placarQ3Casa The score of the home team in the 3rd quarter.
     */
    public void setPlacarQ3Casa(int placarQ3Casa) {
        this.placarQ3Casa = placarQ3Casa;
    }

    /**
     * Gets the score of the visiting team in the 3rd quarter.
     *
     * @return The score of the visiting team in the 3rd quarter.
     */
    public int getPlacarQ3Visitante() {
        return placarQ3Visitante;
    }

    /**
     * Sets the score of the visiting team in the 3rd quarter.
     *
     * @param placarQ3Visitante The score of the visiting team in the 3rd quarter.
     */
    public void setPlacarQ3Visitante(int placarQ3Visitante) {
        this.placarQ3Visitante = placarQ3Visitante;
    }

    /**
     * Gets the score of the home team in the 4th quarter.
     *
     * @return The score of the home team in the 4th quarter.
     */
    public int getPlacarQ4Casa() {
        return placarQ4Casa;
    }

    /**
     * Sets the score of the home team in the 4th quarter.
     *
     * @param placarQ4Casa The score of the home team in the 4th quarter.
     */
    public void setPlacarQ4Casa(int placarQ4Casa) {
        this.placarQ4Casa = placarQ4Casa;
    }

    /**
     * Gets the score of the visiting team in the 4th quarter.
     *
     * @return The score of the visiting team in the 4th quarter.
     */
    public int getPlacarQ4Visitante() {
        return placarQ4Visitante;
    }

    /**
     * Sets the score of the visiting team in the 4th quarter.
     *
     * @param placarQ4Visitante The score of the visiting team in the 4th quarter.
     */
    public void setPlacarQ4Visitante(int placarQ4Visitante) {
        this.placarQ4Visitante = placarQ4Visitante;
    }

    /**
     * Gets the overtime score of the home team.
     *
     * @return The overtime score of the home team.
     */
    public int getProrrogacaoCasa() {
        return prorrogacaoCasa;
    }

    /**
     * Sets the overtime score of the home team.
     *
     * @param prorrogacaoCasa The overtime score of the home team.
     */
    public void setProrrogacaoCasa(int prorrogacaoCasa) {
        this.prorrogacaoCasa = prorrogacaoCasa;
    }

    /**
     * Gets the overtime score of the visiting team.
     *
     * @return The overtime score of the visiting team.
     */
    public int getProrrogacaoVisitante() {
        return prorrogacaoVisitante;
    }

    /**
     * Sets the overtime score of the visiting team.
     *
     * @param prorrogacaoVisitante The overtime score of the visiting team.
     */
    public void setProrrogacaoVisitante(int prorrogacaoVisitante) {
        this.prorrogacaoVisitante = prorrogacaoVisitante;
    }

    /**
     * Gets the total score.
     *
     * @return The total score.
     */
    public int getPlacarTotal() {
        return placarTotalCasa;
    }

    /**
     * Sets the total score.
     *
     * @param placarTotalCasa The total score.
     */
    public void setPlacarTotal(int placarTotalCasa) {
        this.placarTotalCasa = placarTotalCasa;
    }

        public int getPlacarTotalVisitante() {
        return placarTotalVisitante;
    }

    public void setPlacarTotalVisitante(int placarTotalVisitante) {
        this.placarTotalVisitante = placarTotalVisitante;
    }
}
