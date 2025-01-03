package com.football_bingo.Football.Bingo.Service.service.impl;

import com.football_bingo.Football.Bingo.Service.dto.achievement.AchievementSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.bingo.BingoGridDto;
import com.football_bingo.Football.Bingo.Service.dto.bingo.BingoSquareDto;
import com.football_bingo.Football.Bingo.Service.dto.club.ClubSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.coach.CoachSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.competition.CompetitionSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.nation.NationSummaryDto;
import com.football_bingo.Football.Bingo.Service.dto.player.TeammateDto;
import com.football_bingo.Football.Bingo.Service.entity.*;
import com.football_bingo.Football.Bingo.Service.exception.ResourceNotFoundException;
import com.football_bingo.Football.Bingo.Service.mapper.*;
import com.football_bingo.Football.Bingo.Service.repository.*;
import com.football_bingo.Football.Bingo.Service.service.BingoGridService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.*;

@Service
@AllArgsConstructor
public class BingoGridServiceImpl implements BingoGridService {

    private NationRepository nationRepository;
    private ClubRepository clubRepository;
    private CompetitionRepository competitionRepository;
    private AchievementRepository achievementRepository;
    private CoachRepository coachRepository;
    private PlayerRepository playerRepository;

    private NationMapper nationMapper;
    private ClubMapper clubMapper;
    private CompetitionMapper competitionMapper;
    private AchievementMapper achievementMapper;
    private CoachMapper coachMapper;
    private TeammateMapper teammateMapper;
    private PlayerMapper playerMapper;

    @Override
    public List<NationSummaryDto> drawRandomNations(int topPercentage, int drawCount) {
        int totalNations = (int) nationRepository.count();
        int topLimit = Math.max((topPercentage * totalNations) / 100, drawCount);

        System.out.println("Total nations: " + totalNations);
        System.out.println("Top 10% nations count: " + topLimit);

        Pageable pageable = PageRequest.of(0, topLimit);
        List<Nation> topNations = nationRepository.findTopRepresentedNations(pageable);

        System.out.println("Top nations fetched (before shuffle):");
        topNations.forEach(nation -> System.out.println(nation.getName()));

        Collections.shuffle(topNations);

        List<Nation> selectedNations = topNations.stream().limit(drawCount).toList();
        System.out.println("Randomly selected nations:");
        selectedNations.forEach(nation -> System.out.println(nation.getName()));

        return nationMapper.toSummaryDtoList(selectedNations);
    }

    @Override
    public List<ClubSummaryDto> drawRandomClubs(int topPercentage, int drawCount) {
        int totalClubs = (int) clubRepository.count();
        int topLimit = Math.max((topPercentage * totalClubs) / 100, drawCount);

        System.out.println("Total clubs: " + totalClubs);
        System.out.println("Top 10% clubs count: " + topLimit);

        // IDs to exclude ("Retired", "Career break" and "Without Club")
        List<Integer> excludedIds = List.of(123, 515, 2113);

        Pageable pageable = PageRequest.of(0, topLimit);
        List<Club> topClubs = clubRepository.findTopRepresentedClubs(pageable, excludedIds);

        System.out.println("Top clubs fetched (before shuffle):");
        topClubs.forEach(club -> System.out.println(club.getName()));

        Collections.shuffle(topClubs);

        List<Club> selectedClubs = topClubs.stream().limit(drawCount).toList();
        System.out.println("Randomly selected clubs:");
        selectedClubs.forEach(club -> System.out.println(club.getName()));

        return clubMapper.toSummaryDtoList(selectedClubs);
    }

    @Override
    public List<CompetitionSummaryDto> drawRandomCompetitions(int topPercentage, int drawCount) {
        int totalCompetitions = (int) competitionRepository.count();
        int topLimit = Math.max((topPercentage * totalCompetitions) / 100, drawCount);

        System.out.println("Total competitions: " + totalCompetitions);
        System.out.println("Top 10% competitions count: " + topLimit);

        Pageable pageable = PageRequest.of(0, topLimit);
        List<Competition> topCompetitions = competitionRepository.findTopRepresentedCompetitions(pageable);

        System.out.println("Top competitions fetched (before shuffle):");
        topCompetitions.forEach(competition -> System.out.println(competition.getName()));

        Collections.shuffle(topCompetitions);

        List<Competition> selectedCompetitions = topCompetitions.stream().limit(drawCount).toList();
        System.out.println("Randomly selected competitions:");
        selectedCompetitions.forEach(competition -> System.out.println(competition.getName()));

        return competitionMapper.toSummaryDtoList(selectedCompetitions);
    }

    @Override
    public List<AchievementSummaryDto> drawRandomAchievements(int topPercentage, int drawCount) {
        int totalAchievements = (int) achievementRepository.count();
        int topLimit = Math.max((topPercentage * totalAchievements) / 100, drawCount);

        System.out.println("Total achievements: " + totalAchievements);
        System.out.println("Top 10% achievements count: " + topLimit);

        Pageable pageable = PageRequest.of(0, topLimit);
        List<Achievement> topAchievements = achievementRepository.findTopRepresentedAchievements(pageable);

        System.out.println("Top achievements fetched (before shuffle):");
        topAchievements.forEach(achievement -> System.out.println(achievement.getName()));

        Collections.shuffle(topAchievements);

        List<Achievement> selectedAchievements = topAchievements.stream().limit(drawCount).toList();
        System.out.println("Randomly selected achievements:");
        selectedAchievements.forEach(achievement -> System.out.println(achievement.getName()));

        return achievementMapper.toSummaryDtoList(selectedAchievements);
    }

    @Override
    public List<CoachSummaryDto> drawRandomCoaches(int topPercentage, int drawCount) {
        int totalCoaches = (int) coachRepository.count();
        int topLimit = Math.max((topPercentage * totalCoaches) / 100, drawCount);

        System.out.println("Total coaches: " + totalCoaches);
        System.out.println("Top 10% coaches count: " + topLimit);

        Pageable pageable = PageRequest.of(0, topLimit);
        List<Coach> topCoaches = coachRepository.findTopRepresentedCoaches(pageable);

        System.out.println("Top coaches fetched (before shuffle):");
        topCoaches.forEach(coach -> System.out.println(coach.getName()));

        Collections.shuffle(topCoaches);

        List<Coach> selectedCoaches = topCoaches.stream().limit(drawCount).toList();
        System.out.println("Randomly selected coaches:");
        selectedCoaches.forEach(coach -> System.out.println(coach.getName()));

        return coachMapper.toSummaryDtoList(selectedCoaches);
    }

    @Override
    public List<TeammateDto> drawRandomTeammateWith(int topPercentage, int drawCount) {
        int totalPlayers = playerRepository.countEligibleTeammates();
        int topLimit = Math.max((topPercentage * totalPlayers) / 100, drawCount);

        System.out.println("Total players: " + totalPlayers);
        System.out.println("Top 10% players count " + topLimit);

        Pageable pageable = PageRequest.of(0, topLimit);
        List<Player> topPlayers = playerRepository.findTopRepresentedTeammates(pageable);

        System.out.println("Top players fetched by enabled teammates:");
        topPlayers.forEach(player -> System.out.println(player.getName()));

        Collections.shuffle(topPlayers);

        List<Player> selectedPlayers = topPlayers.stream().limit(drawCount).toList();
        System.out.println("Randomly selected players:");
        selectedPlayers.forEach(player -> System.out.println(player.getName()));

        return teammateMapper.toDtoList(selectedPlayers);
    }

    @Override
    public BingoGridDto generateBingoGrid() {
        List<BingoSquareDto> squares = drawSquares();
        Set<Integer> usedPlayerIds = new HashSet<>();

        for (BingoSquareDto square : squares) {
            Player player = findPlayerForSquare(square, usedPlayerIds);
            square.setAssignedPlayerId(player.getId());
            usedPlayerIds.add(player.getId());
        }

        List<Player> extraPlayers = drawExtraPlayers(usedPlayerIds, 26);
        usedPlayerIds.addAll(extraPlayers.stream().map(Player::getId).toList());

        List<Player> allPlayers = new ArrayList<>(extraPlayers);
        for (BingoSquareDto square : squares) {
            allPlayers.add(playerRepository.findById(square.getAssignedPlayerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Player not found")));
        }

        Map<Integer, List<Integer>> playerToSquareMap = mapPlayersToSquares(allPlayers, squares);

        return new BingoGridDto(
                squares,
                allPlayers.stream().map(playerMapper::toDto).toList(),
                playerToSquareMap
        );
    }

    private List<BingoSquareDto> drawSquares() {
        List<BingoSquareDto> squares = new ArrayList<>();
        squares.addAll(drawRandomClubs(10, 5).stream()
                .map(club -> new BingoSquareDto("Played for Club", club.getName(), null))
                .toList());
        squares.addAll(drawRandomNations(10, 5).stream()
                .map(nation -> new BingoSquareDto("From Nation", nation.getName(), null))
                .toList());
        squares.addAll(drawRandomAchievements(10, 3).stream()
                .map(achievement -> new BingoSquareDto("Won Achievement", achievement.getName(), null))
                .toList());
        squares.add(drawRandomCoaches(10, 1).stream()
                .map(coach -> new BingoSquareDto("Coached by", coach.getName(), null))
                .findFirst().orElse(null));
        squares.add(drawRandomCompetitions(10, 1).stream()
                .map(competition -> new BingoSquareDto("Played in Competition", competition.getName(), null))
                .findFirst().orElse(null));
        squares.add(drawRandomTeammateWith(10, 1).stream()
                .map(teammate -> new BingoSquareDto("Teammate with", teammate.getName(), null))
                .findFirst().orElse(null));

        return squares;
    }

    private Player findPlayerForSquare(BingoSquareDto square, Set<Integer> usedPlayerIds) {
        return switch (square.getType()) {
            case "Played for Club" -> playerRepository.findPlayerByClub(square.getCriteria(), usedPlayerIds)
                    .orElseThrow(() -> new ResourceNotFoundException("No eligible player found for club: " + square.getCriteria()));
            case "From Nation" -> playerRepository.findPlayerByNation(square.getCriteria(), usedPlayerIds)
                    .orElseThrow(() -> new ResourceNotFoundException("No eligible player found for nation: " + square.getCriteria()));
            case "Won Achievement" -> playerRepository.findPlayerByAchievement(square.getCriteria(), usedPlayerIds)
                    .orElseThrow(() -> new ResourceNotFoundException("No eligible player found for achievement: " + square.getCriteria()));
            case "Played in Competition" -> playerRepository.findPlayerByCompetition(square.getCriteria(), usedPlayerIds)
                    .orElseThrow(() -> new ResourceNotFoundException("No eligible player found for competition: " + square.getCriteria()));
            case "Coached by" -> playerRepository.findPlayerByCoach(square.getCriteria(), usedPlayerIds)
                    .orElseThrow(() -> new ResourceNotFoundException("No eligible player found for coach: " + square.getCriteria()));
            case "Teammate with" -> playerRepository.findPlayerByTeammate(square.getCriteria(), usedPlayerIds)
                    .orElseThrow(() -> new ResourceNotFoundException("No eligible player found for teammate: " + square.getCriteria()));
            default -> throw new IllegalArgumentException("Unknown square type: " + square.getType());
        };
    }

    private List<Player> drawExtraPlayers(Set<Integer> usedPlayerIds, int count) {
        Pageable pageable = PageRequest.of(0, count);
        return playerRepository.findRandomEnabledPlayersNotIn(usedPlayerIds, pageable);
    }

    private Map<Integer, List<Integer>> mapPlayersToSquares(List<Player> players, List<BingoSquareDto> squares) {
        Map<Integer, List<Integer>> playerToSquareMap = new HashMap<>();
        for (int i = 0; i < squares.size(); i++) {
            BingoSquareDto square = squares.get(i);
            for (Player player : players) {
                if (doesPlayerMatchSquare(player, square)) {
                    playerToSquareMap.computeIfAbsent(player.getId(), k -> new ArrayList<>()).add(i);
                }
            }
        }
        return playerToSquareMap;
    }

    private boolean doesPlayerMatchSquare(Player player, BingoSquareDto square) {
        return switch (square.getType()) {
            case "Played for Club" -> player.getClubs().stream()
                    .anyMatch(club -> club.getName().equals(square.getCriteria()));
            case "From Nation" -> player.getCitizenships().stream()
                    .anyMatch(nation -> nation.getName().equals(square.getCriteria()));
            case "Won Achievement" -> player.getAchievements().stream()
                    .anyMatch(achievement -> achievement.getName().equals(square.getCriteria()));
            case "Played in Competition" -> player.getCompetitions().stream()
                    .anyMatch(competition -> competition.getName().equals(square.getCriteria()));
            case "Coached by" -> player.getCoaches().stream()
                    .anyMatch(coach -> coach.getName().equals(square.getCriteria()));
            case "Teammate with" -> player.getDirectTeammates().stream()
                    .anyMatch(teammate -> teammate.getName().equals(square.getCriteria())) ||
                    player.getInverseTeammates().stream()
                            .anyMatch(teammate -> teammate.getName().equals(square.getCriteria()));
            default -> false;
        };
    }
}