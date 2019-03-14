package guru.springframework.api.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExpirationDate {
    private LocalDateTime date;
    private int timeZoneType;
    private String timezone;
}
