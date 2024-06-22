package ryan.cloud.myapp.common.enums;

public enum OrderStatusEnum {
    INIT("INIT"),
    SUCCESS("SUCCESS");

    private String status;
    OrderStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
