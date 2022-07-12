package github.fincommerce.clients.errors;

public record ErrorRequest(

        int errorId,
        String errorName, String errorMessage, String stackTrace, String serviceName, String serviceEndpoint,
        String ipAddress, String endPointMethod, String requestParams
) {
}
