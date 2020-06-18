package questions;

import models.users.Example;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUsersQuestion implements Question {
    @Override
    public Example answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Example.class);
    }
}
