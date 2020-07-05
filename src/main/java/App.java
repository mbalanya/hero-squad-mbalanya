import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args){
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
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
