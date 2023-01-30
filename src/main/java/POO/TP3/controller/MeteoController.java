package POO.TP3.controller;

import POO.TP3.model.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

@Controller
public class MeteoController {

    @Autowired
    ObjectMapper objectMapper;

    double lat,lng;
    @PostMapping("/meteo")
    public String meteo(@RequestParam(name="address") String namePOST, Model model) throws JSONException, JsonProcessingException {
        model.addAttribute("address", namePOST);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api-adresse.data.gouv.fr/search/?q=" + namePOST + "&limit=1";
        JsonNode result = restTemplate.getForObject(url, JsonNode.class);

        JSONObject json = new JSONObject(result.toString());
        JSONArray features = json.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            JSONObject feature = features.getJSONObject(i);
            String featureType = feature.getString("type");
            System.out.println("Feature " + (i + 1) + " type : " + featureType);
            JSONObject geometry = feature.getJSONObject("geometry");
            JSONArray coordinates = geometry.getJSONArray("coordinates");

            lng = coordinates.getDouble(0);
            lat = coordinates.getDouble(1);

            model.addAttribute("lng", coordinates.get(0).toString());
            model.addAttribute("lat", coordinates.get(1).toString());
        }
        url = "https://api.meteo-concept.com/api/forecast/daily/0?token=a22d17674f2cf3fdd8c25f52d9bf7aa5cfb18f09c5f86f12c5107d73b2d7d7a1&latlng="
                + lat + ',' + lng + "&world=false";

        result = restTemplate.getForObject(url, JsonNode.class);
        Weather forecast = objectMapper.readValue(result.toString(), Weather.class);


        model.addAttribute("forecast",forecast);
        return "meteo";
    }
}
