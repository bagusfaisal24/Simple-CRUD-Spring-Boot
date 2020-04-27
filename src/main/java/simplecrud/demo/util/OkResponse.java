package simplecrud.demo.util;

import lombok.Data;

@Data
public class OkResponse {

    private String message;

    public OkResponse() {
        this.message = "ok";
    }

}
