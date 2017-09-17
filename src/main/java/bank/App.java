package bank;

import bank.model.CustomerTermDeposit;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.post;

public class App {
    public static void main(String... args) {

        // Book Services
        get("/", (req, res) ->new ModelAndView(new HashMap<>(), "index"), new JadeTemplateEngine());

        get("/insert-data",(req,res)->{
            CustomerTermDeposit cusDep = new CustomerTermDeposit();
            cusDep.setAge(20);
            cusDep.setJob("blue-collar");
            cusDep.setMarital("married");
            cusDep.setEducation("primary");
            cusDep.setDefault_("no");
            cusDep.setBalance(1500);
            cusDep.setHousing("yes");
            cusDep.setLoan("yes");
            cusDep.setContact("cellular");
            cusDep.setDay(30);
            cusDep.setMonth("feb");
            cusDep.setDuration(200);
            cusDep.setCampaign(2);
            cusDep.setPdays(-1);
            cusDep.setPrevious(4);
            cusDep.setPoutcome("failure");

            cusDep.save();

            return "Hello";
        });

    }
}