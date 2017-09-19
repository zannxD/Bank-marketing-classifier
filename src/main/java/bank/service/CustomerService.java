package bank.service;

import bank.db.DataMiningManager;
import com.google.gson.Gson;
import bank.model.CustomerTermDeposit;

import java.sql.SQLException;

public class CustomerService {

    public CustomerTermDeposit createCustomerTermDeposit(String body) throws SQLException {
        System.out.println("[Log][Info][createCustomerTermDeposit]" + body);
        CustomerTermDeposit cus = new Gson().fromJson(body,CustomerTermDeposit.class);
        System.out.println("[Log][Success][createCustomerTermDeposit]" + cus);

        DataMiningManager.insertData(cus);
        DataMiningManager.getLastInsertedCustomerTermDeposit(cus);
        DataMiningManager.getPredictionResult(cus);
        return cus;
    }
}
