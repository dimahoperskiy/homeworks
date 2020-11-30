import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

       Pref pref = new Pref();
       int num = 0;
       boolean start = false;

       while (true) {

           try {
               if (pref.getService() == 0 & start == false) {
                   printSettings();
                   Scanner scanner = new Scanner(System.in);
                   num = scanner.nextInt();
                   start = true;
                   pref.setService(num);
               } else if (pref.getService() != 0 & start == false) {
                   num = pref.getService();
                   start = true;
               } else {
                   System.out.println("Select command:");
                   System.out.println("     1 - Refresh");
                   System.out.println("     2 - Settings");
                   System.out.println("     3 - Exit");
                   System.out.print("Enter command number: ");
                   Scanner scanner = new Scanner(System.in);
                   int option = scanner.nextInt();

                   if (option == 1) {
                       num = pref.getService();
                   } else if (option == 2) {
                       printSettings();
                       Scanner scanner1 = new Scanner(System.in);
                       num = scanner1.nextInt();
                       pref.setService(num);
                   } else if (option == 3) {
                       break;
                   } else {
                       System.out.println("Wrong input");
                   }

               }

               if (num == 1) {
                   Document yandex = Jsoup.connect("https://yandex.ru/pogoda/moscow").get();
                   String temp1 = yandex.select("div.temp.fact__temp.fact__temp_size_s > span.temp__value").text();
                   String pressure1 = yandex.select("div.term.term_orient_v.fact__pressure > div.term__value").text();
                   String wet1 = yandex.select("div.term.term_orient_v.fact__humidity > div.term__value").text();

                   printForecast(temp1, pressure1, wet1, "Yandex");

               } else if (num == 2) {
                   Document gismeteo = Jsoup.connect("https://www.gismeteo.ru/weather-moscow-4368/now/").get();
                   String temp2 = gismeteo.select("div.now__weather > span.unit.unit_temperature_c > span.nowvalue__text_l").text();
                   String pressure2P = gismeteo.select("div.nowinfo__item.nowinfo__item_pressure >" +
                           " div.nowinfo__block >" +
                           " div.unit.unit_pressure_mm_hg_atm >" +
                           " div.nowinfo__value").text() + " ";
                   String pressure2Sign = gismeteo.select("div.nowinfo__item.nowinfo__item_pressure >" +
                           " div.nowinfo__block >" +
                           " div.unit.unit_pressure_mm_hg_atm >" +
                           " div.nowinfo__measure").text();
                   String pressure2 = pressure2P + pressure2Sign;


                   String wet2W = gismeteo.select("div.nowinfo__item.nowinfo__item_humidity" +
                           " > div.nowinfo__block > div.nowinfo__value").text();


                   String wet2Sign = gismeteo.select("div.nowinfo__item.nowinfo__item_humidity" +
                           " > div.nowinfo__block > div.nowinfo__measure").text();
                   String wet2 = wet2W + wet2Sign;

                   printForecast(temp2, pressure2, wet2, "Gismeteo");

               } else if (num == 3) {
                   Document weather = Jsoup.connect("https://www.accuweather.com/ru/ru/moscow/294021/current-weather/294021").get();
                   String temp3 = weather.select("div.current-weather-info > div.temp > div.display-temp").text();
                   String pressure3 = weather.select("div.current-weather-details > div.right > div.detail-item.spaced-content").first().child(1).text();
                   String wet3 = weather.select("div.current-weather-details > div.left > div.detail-item.spaced-content").get(2).child(1).text();

                   printForecast(temp3, pressure3, wet3, "Accuweather");

               } else if (num == 4) {
                   String url = "https://api.openweathermap.org/data/2.5/weather?" +
                           "q=Moscow&" +
                           "lang=ru&" +
                           "units=metric&" +
                           "appid=97953d48f454dc9640f736c33b04d52d";

                   URL obj = new URL(url);

                   Map<String, Map<String, Object>> map = new ObjectMapper().readValue(obj, HashMap.class);


                   String temp = map.get("main").get("temp").toString() + "°C";
                   String pressure = map.get("main").get("pressure").toString() + " мбар";
                   String wet = map.get("main").get("humidity").toString() + " %";
                   printForecast(temp, pressure, wet, "OpenWeatherMap");

               } else if (num == 5) {
                   break;
               } else System.out.println("Wrong input");
           } catch (InputMismatchException e) {
               System.out.println("Wrong input");
           }
       }
    }

    public static void printForecast(String temp, String pressure, String wet, String service) {
        System.out.println("----------");
        System.out.println("Weather forecast provided by " + service + ":");
        System.out.println("     Current temperature: " + temp);
        System.out.println("     Current atmosphere pressure: " + pressure);
        System.out.println("     Current humidity: " + wet);
        System.out.println("----------");
    }

    public static void printSettings() {
        System.out.println("Chose one of the weather forecast services:");
        System.out.println("    1 - Yandex");
        System.out.println("    2 - Gismeteo");
        System.out.println("    3 - Accuweather");
        System.out.println("    4 - OpenWeatherMap");
        System.out.println("    5 - Exit");

        System.out.print("Enter number of service: ");
    }
}
