package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.users.Datum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.GetUsersQuestion;
import questions.ResponseCode;
import tasks.GetUser;
import tasks.GetUsers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;


public class Test1StepDefinitions {

    private static final String restUrl= "https://reqres.in/api";
    Actor luis;
    Datum user;

    @Given("^Luis quiere consumir el api rest servicio(\\d+)$")
    public void luisQuiereConsumirElApiRestServicio(int service) {
        luis = Actor.named("Luis Qa Auto Tester")
                .whoCan(CallAnApi.at(restUrl));

    }


    @When("^el envia la peticion rest servicio(\\d+)$")
    public void elEnviaLaPeticionServicio(int service) {



        switch (service){
            case 1:
                luis.attemptsTo(
                        GetUsers.fromPage(1)
                );

                user= new GetUsersQuestion().answeredBy(luis).
                        getData().stream().filter(x ->x.getId()==1).findFirst().orElse(null);
                break;
            case 2:
                luis.attemptsTo(
                        GetUsers.fromPage(2)
                );
                user= new GetUsersQuestion().answeredBy(luis).
                        getData().stream().filter(x ->x.getId()==8).findFirst().orElse(null);
                break;
            case 3:
                luis.attemptsTo(
                        GetUsers.fromPage(2)
                );
                user= new GetUsersQuestion().answeredBy(luis).
                        getData().stream().filter(x ->x.getId()==7).findFirst().orElse(null);


        }

    }

    @Then("^debe recibir las validaciones necesarias rest servicio(\\d+)$")
    public void debeRecibirLasValidacionesNecesariasServicio(int service) {

        switch(service){
            case 1:
                luis.should(
                        seeThat("El responsecode ", ResponseCode.was(),equalTo(200)));
                luis.should(
                        seeThat("Usuario no es null",act -> user,notNullValue())
                );
                luis.should(
                        seeThat("El email del usuario",act -> user.getEmail(),equalTo("george.bluth@reqres.in"))
                );
                break;
            case 2:
                luis.should(
                        seeThat("El responsecode ", ResponseCode.was(),equalTo(200)));
                luis.should(
                        seeThat("Usuario no es null",act -> user,notNullValue())
                );
                luis.should(
                        seeThat("El email del usuario",act -> user.getEmail(),equalTo("lindsay.ferguson@reqres.in"))
                );
                break;
            case 3:
                luis.should(
                        seeThat("El responsecode ", ResponseCode.was(),equalTo(200)));
                luis.should(
                        seeThat("Usuario no es null",act -> user,notNullValue())
                );
                luis.should(
                        seeThat("El email del usuario",act -> user.getEmail(),equalTo("michael.lawson@reqres.in"))
                );
                break;
        }

    }


}
