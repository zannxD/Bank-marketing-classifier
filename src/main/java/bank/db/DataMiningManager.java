/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.db;

import bank.model.CustomerTermDeposit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DataMiningManager {
    

    public static CustomerTermDeposit getPredictionResult(CustomerTermDeposit cus) throws SQLException {
        Statement stmt = null;
        Connection connection = DBConnection.getConnection();

        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(QueryConstant.PREDICTION_QUERY);
            while (rs.next()) {
                cus.y= rs.getString(QueryConstant.MODELPREDICTION);
                cus.probability=rs.getFloat(QueryConstant.MODELPROBABILITY);

                System.out.println("[Log][Info][getPredictionResult]: Prediction: "+ cus.y + "\t");
                System.out.println("[Log][Info][getPredictionResult]: Probability: "+ cus.probability + "\t");
            }
        } catch (SQLException e) {
             System.out.println("[Log][Error][getPredictionResult]: " + e );
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return cus;
    }

    public static void insertData(CustomerTermDeposit cus) throws SQLException {
        String query = "INSERT INTO BANKM_PREDICT (ID, COLUMN1, COLUMN2, COLUMN3, COLUMN4, COLUMN5, COLUMN6, " +
                "COLUMN7, COLUMN8, COLUMN9, COLUMN10, COLUMN11, COLUMN12, COLUMN13, COLUMN14, COLUMN15, COLUMN16) \n" +
                "VALUES (SE.nextval, "+cus.age+",'"+cus.job+"','"+cus.marital+"','"+cus.education+"'," +
                "'"+cus.default_+"',"+cus.balance+",'"+cus.housing+"'," +
                "'"+cus.loan+"','"+cus.contact+"',"+cus.day+",'"+cus.month+"',"+cus.duration+"," +
                ""+cus.campaign+","+cus.pdays+","+cus.previous+",'"+cus.poutcome+"')\n";

        System.out.println("[Log][Info][CustomerTermDeposit]" + query);
        Statement stmt = null;
        Connection connection = DBConnection.getConnection();

        try {
            stmt = connection.createStatement();
            int  rs = stmt.executeUpdate(query);
            if(rs>0){
                System.out.println("[Log][Info][CustomerTermDeposit] New values inserted");
            }
        } catch (SQLException e) {
            System.out.println("[Log][Error][CustomerTermDeposit]: " + e );
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }

    public static CustomerTermDeposit getLastInsertedCustomerTermDeposit(CustomerTermDeposit cus) throws SQLException {
        String query = "Select * from BANKM_PREDICT where ID = (Select MAX(ID) from BANKM_PREDICT)";
        Connection connection = DBConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                cus.id= rs.getLong("ID");

                System.out.println("[Log][Info][getLastInsertedCustomer]: Customer: "+ rs.getLong("ID"));

            }
        } catch (SQLException e) {
            System.out.println("[Log][Error][getLastInsertedCustomer]: " + e );
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return  cus;
    }
}
