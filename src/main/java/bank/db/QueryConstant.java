/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.db;

/**
 * Class used to contain the query strings
 * @author Rishanthan
 */
public class QueryConstant {
    
    
    public static final String MODELPREDICTION = "CLAS_DT_1_5_PRED";
    
    public static final String MODELPROBABILITY = "CLAS_DT_1_5_PROB";

    public static final String MODELYESPROBABILITY = "CLAS_DT_1_5_PCST";
    
    // Query used to get the prediction and probability of the prediction.
    public static final String PREDICTIONQUERY =   "WITH \n" +
            "/* Start of sql for node: BANKM_PREDICT1_APPLY */\n" +
            "\"N$10010\" as (select /*+ inline */ \"BANKM_PREDICT\".\"COLUMN17\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN9\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN14\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN8\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN13\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN7\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN16\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN6\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN15\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN10\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN12\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN11\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN5\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN4\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN3\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN2\", \n" +
            "\"BANKM_PREDICT\".\"ID\", \n" +
            "\"BANKM_PREDICT\".\"COLUMN1\" \n" +
            "from \"DMUSER\".\"BANKM_PREDICT\"  )\n" +
            "/* End of sql for node: BANKM_PREDICT1_APPLY */\n" +
            ",\n" +
            "/* Start of sql for node: Apply_model */\n" +
            "\"N$10011\" as (SELECT /*+ inline */\n" +
            "\"ID\", \n" +
            "PREDICTION(\"CLAS_DT_1_5\" COST MODEL USING *) \"CLAS_DT_1_5_PRED\", \n" +
            "PREDICTION_PROBABILITY(\"CLAS_DT_1_5\", PREDICTION(\"CLAS_DT_1_5\" COST MODEL USING *) USING *) \"CLAS_DT_1_5_PROB\", \n" +
            "PREDICTION_COST(\"CLAS_DT_1_5\" COST MODEL USING *) \"CLAS_DT_1_5_PCST\"\n" +
            "FROM \"N$10010\" )\n" +
            "/* End of sql for node: Apply_model */\n" +
            "select * from \"N$10011\";";
    
    public static final String INPUTDATAINSERTQUERY = "Insert into DMUSER.BANKM_PREDICT ("
            + "ID,"
            + "COLUMN1,"
            + "COLUMN2,"
            + "COLUMN3,"
            + "COLUMN4,"
            + "COLUMN5,"
            + "COLUMN6,"
            + "COLUMN7,"
            + "COLUMN8,"
            + "COLUMN9,"
            + "COLUMN10,"
            + "COLUMN11,"
            + "COLUMN12,"
            + "COLUMN13,"
            + "COLUMN14,"
            + "COLUMN15,"
            +"COLUMN16"
            + ") values ( SE.nextval, ";
    
}
