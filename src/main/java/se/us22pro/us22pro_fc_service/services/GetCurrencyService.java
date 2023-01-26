package se.us22pro.us22pro_fc_service.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import se.us22pro.us22pro_fc_service.model.ConverDataModel;

@Service
public class GetCurrencyService {
    private final Logger logger = LoggerFactory.getLogger(GetCurrencyService.class);
    private static String BASE_URL = "https://api.exchangerate.host";
    private final WebClient webClient;

    public GetCurrencyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public ConverDataModel convertCurrency(ConverDataModel converDataModel){
        logger.info("convertCurrency()");
        String urlSearch = "/latest?symbols=";;
        converDataModel.setFrom_currency("EUR");
        float to_value = Float.valueOf(getCurrency(urlSearch,converDataModel.getTo_currency()));
        converDataModel.setTo_currency_value(to_value);
        converDataModel.setConverted_value(to_value * converDataModel.getPrice());
        String v = Float.toString(converDataModel.getConverted_value());
        System.out.println(converDataModel);
        return converDataModel;
    }


    /**
     * Convert currency
     * @return - Return Sting on remote endpoint system status
     */
    public String getCurrency(String urlSearch, String currency){
        logger.info("getCurrency()");
        String QUERY_VALUE  = BASE_URL + urlSearch + currency;
        //String json = this.webClient.get().uri(BASE_URL + "?from=" + from_value + "&to="+to_value)
        String json = this.webClient.get().uri(QUERY_VALUE)
                .exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        JsonObject rate = jsonObject.getAsJsonObject("rates");
        String value = rate.get(currency).getAsString();

        return value;
    }

}
