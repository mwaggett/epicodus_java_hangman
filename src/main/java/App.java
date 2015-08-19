import java.util.Random;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.*;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;

public class App {

  public static void main(String[] args) {

    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();

      Puzzle newPuzzle = request.session().attribute("newPuzzle");
      if (newPuzzle==null) {
        newPuzzle = new Puzzle();
        request.session().attribute("newPuzzle", newPuzzle);
      }

      Hangman newHangman = request.session().attribute("newHangman");
      if (newHangman==null) {
        newHangman = new Hangman(newPuzzle);
        request.session().attribute("newHangman", newHangman);
      }

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap model = new HashMap();

      Puzzle newPuzzle = request.session().attribute("newPuzzle");
      if (newPuzzle==null) {
        newPuzzle = new Puzzle();
        request.session().attribute("newPuzzle", newPuzzle);
      }

      Hangman newHangman = request.session().attribute("newHangman");
      if (newHangman==null) {
        newHangman = new Hangman(newPuzzle);
        request.session().attribute("newHangman", newHangman);
      }

      int previousGuesses = newPuzzle.getWrongGuesses();
      char guess = request.queryParams("guess").charAt(0);
      newPuzzle.guess(guess);

      if (newPuzzle.getWrongGuesses() > previousGuesses) {
        newHangman.addHead();
      }

      model.put("newPuzzle", newPuzzle);
      model.put("newHangman", newHangman);

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    // get("/newpage", (request, response) -> {
    //   HashMap model = new HashMap();
    //   model.put("template", "templates/newpage.vtl");
    //
    //   <Class> param = request.queryParams("param");
    //   model.put("param", param);
    //   <Class> result = someMethod(param);
    //   model.put("result", result);
    //
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }

}
