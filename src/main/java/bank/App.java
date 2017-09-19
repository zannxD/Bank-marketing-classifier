package bank;

import bank.db.DBConnection;
import bank.model.CustomerTermDeposit;
import bank.service.CustomerService;
import com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.post;

public class App {
    public static void main(String... args) {

        Connection con = DBConnection.getConnection();
        CustomerService customerService = new  CustomerService();
        Gson gson = new Gson();

        get("/", (req, res) ->new ModelAndView(new HashMap<>(), "index"), new JadeTemplateEngine());

        post("/save", (req,res)->{
            try {
                CustomerTermDeposit cus = customerService.createCustomerTermDeposit(req.body());
                return gson.toJson(cus);
            }catch(Exception e){
                res.status(400);
                System.out.println("[Log][Error][HttpSave]" + e);
                return gson.toJson(e);
            }
        });


    }
}