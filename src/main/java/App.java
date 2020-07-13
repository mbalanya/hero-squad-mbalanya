import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class App {
    public static void port(int herokuAssignedPort) {
    }
    public static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args){
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getWholeSquad();
            ArrayList<Hero> heros = Hero.getAllHeros();
            model.put("squads", squads);
            model.put("heros", heros);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/createSquad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            Squad newSquad = new Squad(squadName);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        post("/createHero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String heroName = request.queryParams("heroName");
            int heroAge = Integer.parseInt(request.queryParams("heroAge"));
            String heroAbility = request.queryParams("heroAbility");
            String heroWeakness = request.queryParams("heroWeakness");
            Hero newHero = new Hero(heroName, heroAge, heroAbility, heroWeakness);
            int heroSquad = Integer.parseInt(request.queryParams("heroSquad"));
            Squad newSquad = Squad.findSquad(heroSquad);
            newSquad.addHeroToSquad(newHero);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/heros/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Squad thisSquad = Squad.findSquad(Integer.parseInt(request.params("id")));
            List<Hero> squadHero = thisSquad.getSquadHeros();
            model.put("thisSquad", thisSquad);
            model.put("squadHero",squadHero);
            return new ModelAndView(model, "heros.hbs");
        }, new HandlebarsTemplateEngine());
    }


}
