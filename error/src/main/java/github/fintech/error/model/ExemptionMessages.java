package github.fintech.error.model;

public enum ExemptionMessages {

    IllegalArgumentException, BAD_GATEWAY, NullPointerException, INTERNAL_SERVER_ERROR;

    public String getCustomMessage() {

        return switch (this) {
            case IllegalArgumentException -> "Conflict";
            case BAD_GATEWAY -> "ErrorLog in database";
            case NullPointerException -> "No Data Returned";
            case INTERNAL_SERVER_ERROR -> "Internal Server Error!!!";

        };
    }
}
