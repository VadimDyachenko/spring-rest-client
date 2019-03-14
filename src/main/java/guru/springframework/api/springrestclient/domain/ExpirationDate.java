package guru.springframework.api.springrestclient.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExpirationDate {
    private LocalDateTime date;
    private int timeZoneType;
    private String timezone;
}
