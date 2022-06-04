package github.fintechecommerce.model;

public enum ExemptionMessages {
    IllegalArgumentException, JpaSystemException, NullPointerException;

    public String getCustomMessage() {

        return switch (this) {
            case IllegalArgumentException -> "small";
            case JpaSystemException -> "ErrorLog in database";
            case NullPointerException -> "NullPointerException";
        };
    }
}

