package ru.netology;

import java.util.HashMap;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    public void register(String name, Player player) {
        players.put(name, player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (String name : players.keySet()) {
            if (players.get(name).equals(players.get(playerName1))) {
                player1 = players.get(name);
            }
            if (players.get(name).equals(players.get(playerName2))) {
                player2 = players.get(name);
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Пользователь:" + playerName1 + "не зарегестрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Пользователь:" + playerName2 + "не зарегестрирован");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}

