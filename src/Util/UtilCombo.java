package Util;

import java.util.ArrayList;

public class UtilCombo {
    public static ArrayList<String> listaEstados(){
        ArrayList<String> tipo = new ArrayList<>();
        tipo.add("Aguascalientes");
        tipo.add("Baja California");
        tipo.add("Baja California Sur");
        tipo.add("Campeche");
        tipo.add("Coahuila");
        tipo.add("Colima");
        tipo.add("Chiapas");
        tipo.add("Chihuahua");
        tipo.add("Ciudad de México");
        tipo.add("Durango");
        tipo.add("Guanajuato");
        tipo.add("Guerrero");
        tipo.add("Hidalgo");
        tipo.add("Jalisco");
        tipo.add("México");
        tipo.add("Michoacán");
        tipo.add("Morelos");
        tipo.add("Nayarit");
        tipo.add("Nuevo León");
        tipo.add("Oaxaca");
        tipo.add("Puebla");
        tipo.add("Querétaro");
        tipo.add("Quintana Roo");
        tipo.add("San Luis Potosí");
        tipo.add("Sinaloa");
        tipo.add("Sonora");
        tipo.add("Tabasco");
        tipo.add("Tamaulipas");
        tipo.add("Tlaxcala");
        tipo.add("Veracruz");
        tipo.add("Yucatán");
        tipo.add("Zacatecas");


        return tipo;
    }
    public static ArrayList<String> listaCiudades(){
        ArrayList<String> tipo = new ArrayList<>();
        tipo.add("Capital");
        tipo.add("Ciudad principal");
        tipo.add("Ciudad portuaria");
        tipo.add("Ciudad turística");
        tipo.add("Ciudad universitaria");
        return tipo;
    }
    public static ArrayList<String> tiposAdeudo(){
        ArrayList<String> tipo = new ArrayList<>();
        tipo.add("Comida");
        tipo.add("Renta");
        return tipo;
    }

}
