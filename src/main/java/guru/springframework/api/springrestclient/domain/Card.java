package guru.springframework.api.springrestclient.domain;

import lombok.Data;

@Data
public class Card {
    private String type;
    private int number;
    private ExpirationDate expirationDate;
    private String iban;
    private String swift;
}
