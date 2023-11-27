package org.example;

import java.util.function.Function;

public interface PlayerValidator extends Function<Player, ValidateCondition> {

    static PlayerValidator validate_age() {
        return player -> player.getAge() > 18 ? ValidateCondition.SUCCESSFUL :
                ValidateCondition.NOT_VALIDATED_FOR_UNDER_AGE;

    }

    static PlayerValidator validate_goals() {
        return player -> player.getScore() > 100 ? ValidateCondition.SUCCESSFUL :
                ValidateCondition.NOT_VALIDATED_FOR_NOT_ENOUGH_GOALS;
    }

    default PlayerValidator and(PlayerValidator other) {
        return player -> {
            ValidateCondition result = this.apply(player);
            return result.equals(ValidateCondition.SUCCESSFUL) ? other.apply(player) : result;
        };
    }
}


enum ValidateCondition {
    SUCCESSFUL, NOT_VALIDATED_FOR_NOT_ENOUGH_GOALS, NOT_VALIDATED_FOR_UNDER_AGE
}
