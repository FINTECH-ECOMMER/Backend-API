package github.fintechecommerce.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class GeneralResponse {
    private final Object data;
    private String status = HttpStatus.OK.getReasonPhrase();
    private int code = HttpStatus.OK.value();
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time = LocalDateTime.now();
}
