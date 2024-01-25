package com.pravar.blacklightspringboot.controller;

import com.pravar.blacklightspringboot.entity.User;
import com.pravar.blacklightspringboot.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @Autowired
    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

//    @GetMapping("/current-week")
//    public List<User> getCurrentWeekLeaderboard() {
//        return leaderboardService.getCurrentWeekLeaderboardTop200();
//    }

    @GetMapping("/last-week/{country}")
    public List<User> getLastWeekLeaderboardForCountry(@PathVariable String country) {
        return leaderboardService.getLastWeekLeaderboardForCountry(country);
    }

    @GetMapping("/user-rank/{userId}")
    public int getUserRank(@PathVariable String userId) {
        int rank = leaderboardService.getUserRankByUserId(userId);
        System.out.println("user rank : " + rank);
        return rank;
    }
    @GetMapping("/hey")
    public String heyo() {
        return "Heyyypppp";
    }
}

