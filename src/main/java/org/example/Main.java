package org.example;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(17,102,"meraj");

        PlayerValidator playerValidator = PlayerValidator.validate_age();
        PlayerValidator combined = playerValidator.and(PlayerValidator.validate_goals());


        ValidateCondition apply = combined.apply(player);
        System.out.println(apply);

    }
}