package ryan.cloud.myapp.controller;

import lombok.Data;

@Data
public class CommonResp {

    private String resultCode;
    private boolean success;
    private String message;

}
