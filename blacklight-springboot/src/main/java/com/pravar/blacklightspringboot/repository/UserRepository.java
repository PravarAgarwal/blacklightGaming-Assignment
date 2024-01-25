package com.pravar.blacklightspringboot.repository;

import com.pravar.blacklightspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.Country = :country AND u.timeStamp BETWEEN :start AND :end ORDER BY u.Score DESC")

    List<User> getLastWeekLeaderboardForCountry(
            @Param("country") String country,
            @Param("start") Timestamp start,
            @Param("end") Timestamp end
    );
//    @Query(value = "SELECT u FROM User u WHERE u.country = :country AND YEARWEEK(u.createdAt, 1) = YEARWEEK(CURRENT_DATE, 1) - 1 ORDER BY u.score DESC")
//    List<User> findLastWeekLeaderboardForCountryTop200(@Param("country") String country);

//    @Query("SELECT COUNT(u) + 1 FROM User u WHERE u.Score > (SELECT u2.Score FROM User u2 WHERE u2.UID = :uid)")
//    int findUserRankByUserId(@Param("uid") String uid);
    @Query("SELECT COUNT(u) + 1 FROM User u WHERE u.Score > COALESCE((SELECT u2.Score FROM User u2 WHERE u2.UID = :uid), 0)")
    int findUserRankByUserId(@Param("uid") String uid);
}
