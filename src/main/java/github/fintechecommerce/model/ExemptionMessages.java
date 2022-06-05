package github.fintechecommerce.model;

public enum ExemptionMessages {
    IllegalArgumentException, JpaSystemException, NullPointerException, INTERNAL_SERVER_ERROR;

    public String getCustomMessage() {

        return switch (this) {
            case IllegalArgumentException -> "small";
            case JpaSystemException -> "ErrorLog in database";
            case NullPointerException -> "NullPointerException";
            case INTERNAL_SERVER_ERROR -> "Internal Server Error";
        };
    }
}

