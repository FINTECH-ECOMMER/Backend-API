package github.fintech.error.model;

public enum Messages {

    SUCCESSES, DELETED, CREATED,UPDATED;

    public String getCustomMessage() {

        return switch (this) {
            case SUCCESSES -> " Success";
            case DELETED -> " Deleted Successfully";
            case CREATED -> " Created Successfully";
            case UPDATED -> " Updated Successfully";
        };
    }
}