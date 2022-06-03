package github.fintechecommerce.model;

public enum ExemptionMessages {
    IllegalArgumentException, JpaSystemException;

    public String getCustomMessage() {

        return switch (this) {
            case IllegalArgumentException -> "small";
            case JpaSystemException -> "ErrorLog in database";
        };
    }
}

