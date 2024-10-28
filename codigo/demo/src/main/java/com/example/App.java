package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.example.dao.EquipeDAO;
import com.example.dao.MySQLDBHandler;
import com.example.dao.PartidaDAO;
import com.example.dao.PlacarDAO;
import com.example.data.Equipe;
import com.example.data.Partida;
import com.example.data.Placar;

public class App {
    public static void main(String[] args) throws ParseException {
        try (Connection connection = MySQLDBHandler.getConnection()) {

            Scanner scanner = new Scanner(System.in);

            int opcao;

            PartidaDAO partidaDAO = new PartidaDAO(connection);
            PlacarDAO placarDAO = new PlacarDAO(connection);
            EquipeDAO equipeDAO = new EquipeDAO(connection);

            do {
                System.out.println("Menu:");
                System.out.println("1. Cadastrar partida futura");
                System.out.println("2. Registrar resultado de partida");
                System.out.println("3. Mostrar todas as partidas");
                System.out.println("4. Gerar tabela de classificação");
                System.out.println("5. Melhor ataque");
                System.out.println("6. Melhor defesa");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {

                    case 1:

                        System.out.println("Digite a data da partida");
                        String partidaData = scanner.nextLine();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = formatter.parse(partidaData);
                        scanner.nextLine();
                        System.out.println("Digite o nome do time da casa");
                        String equipeCasaName = scanner.nextLine();
                        System.out.println("Digite o nome do time visitante");
                        String equipeVisitanteName = scanner.nextLine();
                        System.out.println("Digite o placar do time da casa");
                        int placarCasa = scanner.nextInt();
                        System.out.println("Digite o placar do time visitante");
                        int placarVisitante = scanner.nextInt();
                        System.out.println("Digite o ID campeonato: ");
                        int campeonatoId = scanner.nextInt();

                        // Buscando equipe pelo nome;

                        EquipeDAO equipesDAO = new EquipeDAO(connection);

                        Equipe equipeCasa = equipesDAO.getEquipeByName(equipeCasaName);
                        Equipe equipeVisitante = equipesDAO.getEquipeByName(equipeVisitanteName);

                        // Criando Instancia de partida
                        Partida partida = new Partida(
                                date,
                                equipeCasa.getEquipeId(),
                                equipeVisitante.getEquipeId(),
                                campeonatoId
                            );

                        partidaDAO.create(partida);

                        System.out.println("Partida Registrada com sucesso!");

                        break;

                    case 2: // Registrar Dados do Placar de uma partida

                        System.out.println("Digite o id da partida");
                        int partidaId = scanner.nextInt();

                        Placar placar = placarDAO.getByPartidaId(partidaId);

                        System.out.println("Q1 - Casa:");
                        int q1Casa = scanner.nextInt();
                        System.out.println("Q1 - Visitante:");
                        int q1Visitante = scanner.nextInt();

                        System.out.println("Q2 - Casa:");
                        int q2Casa = scanner.nextInt();
                        System.out.println("Q2 - Visitante:");
                        int q2Visitante = scanner.nextInt();

                        System.out.println("Q3 - Casa:");
                        int q3Casa = scanner.nextInt();
                        System.out.println("Q3 - Visitante:");
                        int q3Visitante = scanner.nextInt();

                        System.out.println("Q4 - Casa:");
                        int q4Casa = scanner.nextInt();
                        System.out.println("Q4 - Visitante:");
                        int q4Visitante = scanner.nextInt();

                        System.out.println("Prorrogação - Casa:");
                        int prorrogacaoCasa = scanner.nextInt();
                        System.out.println("Prorrogação - Visitante:");
                        int prorrogacaoVisitante = scanner.nextInt();

                        System.out.println("Total - Casa:");
                        int totalCasa = scanner.nextInt();
                        System.out.println("Total - Visitante:");
                        int totalVisitante = scanner.nextInt();

                        Placar placarToUpdate = new Placar(placar.getPlacarId(), placar.getPartidaId(),
                                q1Casa,
                                q1Visitante,
                                q2Casa,
                                q2Visitante,
                                q3Casa,
                                q3Visitante,
                                q4Casa,
                                q4Visitante,
                                prorrogacaoCasa,
                                prorrogacaoVisitante,
                                totalCasa,
                                totalVisitante);
                        
                        placarDAO.update(placarToUpdate);

                        System.out.println("Placar Registrada com sucesso!");

                        break;

                    case 3: //  Buscar todas as partidas

                        System.out.println("Digite o id do campeonato");
                        int campeonatoTodoId = scanner.nextInt();
                        
                        List<Partida> partidas = partidaDAO.getAllByCampeonatoId(campeonatoTodoId);

                        for (Partida p : partidas){

                            String eqCasaName = equipeDAO.getById(p.getPartidaEquipeCasaId()).getEquipeNome();
                            String eqCasaVisitanteName = equipeDAO.getById(p.getPartidaEquipeVisitanteId()).getEquipeNome();
                            
                            placar = placarDAO.getByPartidaId(p.getPartidaId());

                            System.out.println("Data: " + p.getPartidaData());
                            System.out.println("Equipe da casa: " + eqCasaName);
                            System.out.println("Equipe visitante: " + eqCasaVisitanteName);
                            System.out.println("Placar da casa: " + placar.getPlacarTotal());
                            System.out.println("Placar visitante: " + placar.getPlacarTotalVisitante());
                        }

                        break;

                    case 4: // Gerar tabela de classificação

                        System.out.println("Digite o id do campeonato");
                        int campeonatId = scanner.nextInt();

                        partidas = partidaDAO.getAllByCampeonatoId(campeonatId);
                        List<Equipe> equipes = equipeDAO.getAllByCampeonatoId(campeonatId);

                        Map<Equipe, Integer> pontos = new HashMap<>();
                        for (Equipe equipe : equipes) {
                            pontos.put(equipe, 0);
                        }

                        for (Partida partidasPartida : partidas) {
                            String eqCasaName = equipeDAO.getById(partidasPartida.getPartidaEquipeCasaId()).getEquipeNome();
                            String eqVisitanteName = equipeDAO.getById(partidasPartida.getPartidaEquipeVisitanteId()).getEquipeNome();

                            Placar placars = placarDAO.getByPartidaId(partidasPartida.getPartidaId());

                            System.out.println("Data: " + partidasPartida.getPartidaData());
                            System.out.println("Equipe da casa: " + eqCasaName);
                            System.out.println("Equipe visitante: " + eqVisitanteName);
                            System.out.println("Placar da casa: " + placars.getPlacarTotal());
                            System.out.println("Placar visitante: " + placars.getPlacarTotalVisitante());

                        if (placars.getPlacarTotal() > placars.getPlacarTotalVisitante()) {
                            pontos.put(equipeDAO.getById(partidasPartida.getPartidaEquipeCasaId()), pontos.get(equipeDAO.getById(partidasPartida.getPartidaEquipeCasaId())) + 2); // Vitória para a equipe da casa.
                            pontos.put(equipeDAO.getById(partidasPartida.getPartidaEquipeVisitanteId()), pontos.get(equipeDAO.getById(partidasPartida.getPartidaEquipeVisitanteId())) + 1); // Derrota para a equipe visitante.
                        } else if (placars.getPlacarTotal() < placars.getPlacarTotalVisitante()) {
                            pontos.put(equipeDAO.getById(partidasPartida.getPartidaEquipeCasaId()), pontos.get(equipeDAO.getById(partidasPartida.getPartidaEquipeCasaId())) + 1); // Derrota para a equipe da casa.
                            pontos.put(equipeDAO.getById(partidasPartida.getPartidaEquipeVisitanteId()), pontos.get(equipeDAO.getById(partidasPartida.getPartidaEquipeVisitanteId())) + 2); // Vitória para a equipe visitante.
                        } else {
                            pontos.put(equipeDAO.getById(partidasPartida.getPartidaEquipeCasaId()), pontos.get(equipeDAO.getById(partidasPartida.getPartidaEquipeCasaId())) + 1); // Empate.
                            pontos.put(equipeDAO.getById(partidasPartida.getPartidaEquipeVisitanteId()), pontos.get(equipeDAO.getById(partidasPartida.getPartidaEquipeVisitanteId())) + 1); // Empate.
                        }
                    }

                    // Classifica as equipes com base nos pontos.
                    List<Map.Entry<Equipe, Integer>> equipesClassificadas = pontos.entrySet()
                            .stream()
                            .sorted(Map.Entry.<Equipe, Integer>comparingByValue().reversed())
                            .collect(Collectors.toList());

                    System.out.println("Tabela de classificação para o campeonato de ID " + campeonatId + ":");
                    for (Map.Entry<Equipe, Integer> equipePontos : equipesClassificadas) {
                        System.out.println("Equipe: " + equipePontos.getKey().getEquipeNome());
                        System.out.println("Pontos: " + equipePontos.getValue());
                        System.out.println();
                    }
                    break;

                    case 5: // Equipe com melhor ataque

                        System.out.println("Digite o id do campeonato");
                        int ataqueCampeonatoId = scanner.nextInt();

                        equipes = equipeDAO.getAllByCampeonatoId(ataqueCampeonatoId);

                        Equipe equipeMelhorAtaque = null;
                        int melhorAtaque = 0;

                        for (Equipe equipe : equipes) {
                            List<Partida> partidasEquipeList = partidaDAO.getPartidasByEquipeId(equipe.getEquipeId());
                            int equipeTotal = 0;

                            for (Partida p : partidasEquipeList) {
                                placar = placarDAO.getByPartidaId(p.getPartidaId());
                                equipeTotal +=  p.getPartidaEquipeCasaId() == equipe.getEquipeId() ? placar.getPlacarTotal() : placar.getPlacarTotalVisitante();
                            }

                            if (equipeMelhorAtaque == null || equipeTotal > melhorAtaque) {
                                equipeMelhorAtaque = equipe;
                                melhorAtaque = equipeTotal;
                            }
                        }

                        if (equipeMelhorAtaque != null) {
                            System.out.println("A equipe com o melhor ataque é: " + equipeMelhorAtaque.getEquipeNome() + " com um total de " + melhorAtaque + " gols.");
                        } else {
                            System.out.println("Nenhuma equipe encontrada para o campeonato informado.");
                        }
                        
                        break;

                    case 6: // Equipe com melhor defesa

                        System.out.println("Digite o id do campeonato");
                        int defesaCampeonatoId = scanner.nextInt();

                        equipes = equipeDAO.getAllByCampeonatoId(defesaCampeonatoId);

                        Equipe equipeMelhorDefesa = null;
                        int melhorDefesa = Integer.MAX_VALUE;

                        for (Equipe equipe : equipes) {
                            List<Partida> partidasEquipeList = partidaDAO.getPartidasByEquipeId(equipe.getEquipeId());
                            int equipeTotalGolsSofridos = 0;

                            for (Partida p : partidasEquipeList) {
                                Placar placar2 = placarDAO.getByPartidaId(p.getPartidaId());
                                int golsSofridos = equipe.getEquipeId() == p.getPartidaEquipeCasaId() ?
                                    placar2.getPlacarTotalVisitante() : placar2.getPlacarTotal();

                                equipeTotalGolsSofridos += golsSofridos;
                            }

                            if (equipeMelhorDefesa == null || equipeTotalGolsSofridos < melhorDefesa) {
                                equipeMelhorDefesa = equipe;
                                melhorDefesa = equipeTotalGolsSofridos;
                            }
                        }

                        if (equipeMelhorDefesa != null) {
                            System.out.println("A equipe com a melhor defesa é: " + equipeMelhorDefesa.getEquipeNome() +
                                    " com um total de " + melhorDefesa + " gols sofridos.");
                        } else {
                            System.out.println("Nenhuma equipe encontrada para o campeonato informado.");
                        }

                        break;

                    case 0:
                        System.out.println("Fechando...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
