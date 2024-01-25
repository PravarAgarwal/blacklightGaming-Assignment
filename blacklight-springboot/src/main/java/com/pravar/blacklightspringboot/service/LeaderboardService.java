package com.pravar.blacklightspringboot.service;

import com.pravar.blacklightspringboot.entity.User;
import com.pravar.blacklightspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeaderboardService {

    private final UserRepository userRepository;

    @Autowired
    public LeaderboardService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public List<User> getCurrentWeekLeaderboardTop200() {
//        return userRepository.findCurrentWeekLeaderboardTop200();
//    }

    public List<User> getLastWeekLeaderboardForCountry(String country) {
        // Calculate timestamps for the start of the current week and the start of the next week
        Timestamp startOfWeek = getStartOfWeek();
        Timestamp startOfNextWeek = getStartOfNextWeek();

        // Call the repository method to get the last week's leaderboard for the specified country
        return userRepository.getLastWeekLeaderboardForCountry(country, startOfWeek, startOfNextWeek);
    }

    // Helper method to get the timestamp for the start of the current week
    private Timestamp getStartOfWeek() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfWeek = now.minusDays(now.getDayOfWeek().getValue() - 1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        return Timestamp.valueOf(startOfWeek);
    }

    // Helper method to get the timestamp for the start of the next week
    private Timestamp getStartOfNextWeek() {
        return Timestamp.valueOf(getStartOfWeek().toLocalDateTime().plusWeeks(1));
    }

    public int getUserRankByUserId(String userId) {
        return userRepository.findUserRankByUserId(userId);
    }
}
