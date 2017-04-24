/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.*;

/**
 *
 * @author CREAT10N
 */
public class ScoreController {

    public static ArrayList<Integer> scores;
    public static ArrayList<String> names;

    public ScoreController() {
    }

    public static void highScores() {
        Connection con = DatabaseController.getConnection();
        String query = "SELECT name, score FROM highscore ORDER BY score DESC LIMIT 5";
        scores = new ArrayList<>();
        names = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                int score = rs.getInt("score");
                scores.add(score);
                names.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getNames() {
        return names;
    }

    public static void setNames(ArrayList<String> names) {
        ScoreController.names = names;
    }

    public static ArrayList<Integer> getScores() {
        return scores;
    }

    public static void setScores(ArrayList<Integer> scores) {
        ScoreController.scores = scores;
    }
}
