package github.fincommerce.clients.utils;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class ResponseModel<ResponseData> {
    private int code = HttpStatus.OK.value();
    private String status = HttpStatus.OK.getReasonPhrase();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time = LocalDateTime.now();
    private final ResponseData data;
}