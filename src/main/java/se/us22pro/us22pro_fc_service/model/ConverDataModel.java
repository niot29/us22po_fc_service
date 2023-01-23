package se.us22pro.us22pro_fc_service.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ConverDataModel {

    private Long price;
    private String from_currency;
    private String to_currency;
    private float to_currency_value;
    private float converted_value;
}
