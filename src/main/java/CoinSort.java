import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class CoinSort {
    public static void main(String[] args) {
      String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/home.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/return", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/return.vtl");

      String stringCoins= request.queryParams("userInput");
      Integer coins = Integer.parseInt(stringCoins);

      String change;
      change = checkChange(coins);

      model.put("userInput", change);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    }
    public static String checkChange(Integer userInput) {
      String result = "";
      Integer quarters = 0;
      int dimes = 0;
      int nickels = 0;
      int pennies = 0;
      String noPenny = "";

      while (userInput > 0) {
       if (userInput >= 25){
         userInput -= 25;
         quarters++;
       } else if (userInput >= 10){
         userInput -= 10;
         dimes++;
       } else if (userInput >= 5) {
         userInput -= 5;
         nickels++;
       } else if (userInput >= 1) {
         userInput -= 1;
         pennies++;
       }else {
         userInput = 0;
         noPenny = "no more money";
       }
    }
       String quarterReturn = "";
       String dimeReturn= "";
       String nickelReturn="";
       String pennyReturn="";

       if (quarters > 0) {
         quarterReturn = (quarters + " quarters");
       }
       if (dimes > 0) {
         dimeReturn = " " + dimes + " dimes";
       }
       if (nickels > 0) {
         nickelReturn = " " + nickels + " nickels";

       }
       if (pennies > 0) {
         pennyReturn = " " + pennies + " pennies";
       }



       return result =  String.format("%s%s%s%s", quarterReturn, dimeReturn, nickelReturn, pennyReturn);
     }
    }
