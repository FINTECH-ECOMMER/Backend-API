package github.fincommerce.clients.utils;

public record ResponseModelRecord<ResponseData>(int code, String status, String time, ResponseData data) {
}