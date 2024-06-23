package ryan.cloud.myapp.common.enums;

public enum OrderStatusEnum {
    INIT("INIT"),
    SENT("SENT"),
    SUCCESS("SUCCESS");

    private String status;
    OrderStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
