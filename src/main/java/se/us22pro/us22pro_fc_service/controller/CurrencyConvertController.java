package se.us22pro.us22pro_fc_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.us22pro.us22pro_fc_service.model.ConverDataModel;
import se.us22pro.us22pro_fc_service.services.GetCurrencyService;


@RestController
@RequestMapping("/api/v1/price")
public class CurrencyConvertController {
    private final Logger logger = LoggerFactory.getLogger(CurrencyConvertController.class);

    @Autowired
    GetCurrencyService getCurrency;

    @GetMapping("")
    public String info(){
        logger.info("info():  Application status");
        return "The application is up ..";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConverDataModel setCorrencyConvert(@RequestBody ConverDataModel converDataModel){
        logger.info("setCorrencyConvert(): ");
        System.out.println(getCurrency.convertCurrency(converDataModel));
        return getCurrency.convertCurrency(converDataModel);
    }

}
