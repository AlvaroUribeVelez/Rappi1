package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUser implements Task {


    public GetUser(){

    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(Get.resource("/users/2")
                .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                        .header("header1","value1")
                )
        );
    }

}
