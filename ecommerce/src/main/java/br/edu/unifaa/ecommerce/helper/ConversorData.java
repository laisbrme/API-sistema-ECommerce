package br.edu.unifaa.ecommerce.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {
    
    public static String converterDateParaDataEHora(Date data) {
        
        return new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(data);
    }
}
