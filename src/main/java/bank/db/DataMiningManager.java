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

import static bank.db.QueryConstant.INPUTDATAINSERTQUERY;

/**
 * Class representing an DataMiningManager.
 * @author Rishanthan
 */
public class DataMiningManager {
    
    /**
     * Method used to get the prediction results.
     * @param connection - DB Connection.
     * @return
     * @throws SQLException 
     */
    public static String[] getPredictionResult(Connection connection) throws SQLException {
        Statement stmt = null;
        String[] results = new String[2];

        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(QueryConstant.PREDICTIONQUERY);
            while (rs.next()) {
                results[0]= rs.getString(QueryConstant.MODELPREDICTION);
                results[1]=rs.getString(QueryConstant.MODELPROBABILITY);

                System.out.println("[Log][Info][getPredictionResult]: Prediction: "+ results[0] + "\t");
                System.out.println("[Log][Info][getPredictionResult]: Probability: "+ results[1] + "\t");
            }
        } catch (SQLException e) {
             System.out.println("[Log][Error][getPredictionResult]: " + e );
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        
        return results;
    }
    

    public static void insertNewData( CustomerTermDeposit cusDep)throws SQLException {
        Statement stmt = null;
        Connection connection = DBConnection.getConnection();
        
        String query =
        INPUTDATAINSERTQUERY
                +cusDep.getAge() +",' "+cusDep.getJob() +"', '"+cusDep.getMarital()
                +"',' "+cusDep.getEducation()
                +"',' "+cusDep.getDefault_()
                +"',' "+cusDep.getBalance()
                +"',' "+cusDep.getHousing()
                +"',' "+cusDep.getLoan()
                +"',' "+cusDep.getContact()
                +"',' "+cusDep.getDay()
                +"',' "+cusDep.getMonth()
                +"',' "+cusDep.getDuration()
                +"',' "+cusDep.getCampaign()
                +"',' "+cusDep.getPdays()
                +"',' "+cusDep.getPrevious()
                +"',' "+cusDep.getPoutcome()+
                "')";


        System.out.println(query);
        try {
            stmt = connection.createStatement();
            int  rs = stmt.executeUpdate(query);
            if(rs>0){
                System.out.println("[Log][Info][insertNewData] New values inserted");
            }
        } catch (SQLException e) {
            System.out.println("[Log][Error][insertNewData]: " + e );
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    /**
     * Method used to delete the previous data in the database table.
     * @param connection - DB Connection
     * @throws SQLException 
     */
    public static void deletePreviousData(Connection connection) throws SQLException {
        
        if (!checkDataExists(connection)) {
            return;
        }
        
        Statement stmt = null;
        String query = "DELETE FROM DMUSER.PRIMARY_TUMOR_APPLY";
        
        try {
            stmt = connection.createStatement();
            int  rs = stmt.executeUpdate(query);
            
            if(rs>0){
                System.out.println("[Log][Succes][deletePreviousData]: Database Cleared");
            }
        } catch (SQLException e) {
             System.out.println("[Log][Error][deletePreviousData]: " + e );
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    /**
     * Method used to check whether any data exists in the table.
     * @param connection - DB Connection.
     * @return - boolean
     * @throws SQLException 
     */
    public static boolean checkDataExists(Connection connection) throws SQLException{
        
        System.out.println("[Log][Info][checkDataExists]: Start");
        
        Statement stmt = null;
        String query = "SELECT * FROM DMUSER.PRIMARY_TUMOR_APPLY";
        boolean result = true;
        
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next()){
                result = true;
            }  
        } catch (SQLException e) {
             System.out.println("[Log][Error][checkDataExists]:"+ e );
             result = false;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        
        System.out.println("[Log][Info][checkDataExists]: Finish");
        
        return result;
    }
}
