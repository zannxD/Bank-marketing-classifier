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
    
    
    public static final String MODELPREDICTION = "CLAS_GLM_1_5_PRED";
    
    public static final String MODELPROBABILITY = "CLAS_GLM_1_5_PROB";

    public static final String PREDICTION_QUERY = "\n" +
            "WITH \n" +
            "/* Start of sql for node: BANKM1_APPLY */\n" +
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
            "from \"DMUSER\".\"BANKM_PREDICT\" \n" +
            "WHERE \"BANKM_PREDICT\".\"ID\" = (SELECT MAX(\"B\".\"ID\") from \"DMUSER\".\"BANKM_PREDICT\" B )\n" +
            ")\n" +
            "/* End of sql for node: BANKM1_APPLY */\n" +
            ",\n" +
            "/* Start of sql for node: Apply_model */\n" +
            "\"N$10011\" as (SELECT /*+ inline */\n" +
            "\"ID\", \n" +
            "PREDICTION(\"CLAS_GLM_1_5\" USING *) \"CLAS_GLM_1_5_PRED\", \n" +
            "PREDICTION_PROBABILITY(\"CLAS_GLM_1_5\" USING *) \"CLAS_GLM_1_5_PROB\", \n" +
            "PREDICTION_BOUNDS(\"CLAS_GLM_1_5\", 0.95 USING *).LOWER \"CLAS_GLM_1_5_PBLW\", \n" +
            "PREDICTION_BOUNDS(\"CLAS_GLM_1_5\", 0.95 USING *).UPPER \"CLAS_GLM_1_5_PBUP\"\n" +
            "FROM \"N$10010\" )\n" +
            "/* End of sql for node: Apply_model */\n" +
            "select * from \"N$10011\"";

}
