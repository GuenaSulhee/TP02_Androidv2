package fr.afpa.cdi.convertisseur;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XavMBP on 08/03/2016.
 */
public class Convert {
    private static Map<String, Double> conversionTable = new HashMap<String, Double>();

    static
    {
        conversionTable.put("Livre",Double.valueOf(0.6404));
        conversionTable.put("Euro",Double.valueOf(0.7697));
        conversionTable.put("Dirham",Double.valueOf(8.5656));
        conversionTable.put("Yen",Double.valueOf(76.6908));
        conversionTable.put("Francs CFA",Double.valueOf(503.17));
        conversionTable.put("Dollars US",Double.valueOf(1.0));



    }
    public static double convertir(String source, String cible, double montant)
    {
        double tauxSource = conversionTable.get(source);
        double tauxCible = conversionTable.get(cible);
        double tauxConversion = tauxCible/tauxSource;
        return (montant * tauxConversion);


    }
    public static Map<String, Double> getConversionTable()
    {
        return conversionTable;
    }


}
