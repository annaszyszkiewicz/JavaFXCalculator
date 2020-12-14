package edu.ib;

public class Calculate {

    public String multi(String number, String previousNumber){
        String result = String.valueOf(Double.parseDouble(number)*Double.parseDouble(previousNumber));
        if (result.endsWith(".0"))
            result = result.substring(0,result.length()-2);
        return result;
    }

    public String pc(String number){
        String result = String.valueOf(Double.parseDouble(number)/100);
        if (result.endsWith(".0"))
            result = result.substring(0,result.length()-2);
        return result;
    }

    public String reverse(String number){
        String result = String.valueOf(1/Double.parseDouble(number));
        if (result.endsWith(".0"))
            result = result.substring(0,result.length()-2);
        return result;
    }

    public String pow(String number){
        String result = String.valueOf(Double.parseDouble(number)*Double.parseDouble(number));
        if (result.endsWith(".0"))
            result = result.substring(0,result.length()-2);
        return result;
    }

    public String sqrt(String number){
        String result = String.valueOf(Math.sqrt(Double.parseDouble(number)));
        if (result.endsWith(".0"))
            result = result.substring(0,result.length()-2);
        return result;
    }

    public String sign(String number){
        String result = String.valueOf(Double.parseDouble(number)-2*Double.parseDouble(number));
        if (result.endsWith(".0"))
            result = result.substring(0,result.length()-2);
        return result;
    }
}
