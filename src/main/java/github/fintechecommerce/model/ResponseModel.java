package github.fintechecommerce.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseModel<ResponseData> {
    private int code =  HttpStatus.OK.value();
    private String status = HttpStatus.OK.getReasonPhrase();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime time= LocalDateTime.now();
    private  final ResponseData data;

}
