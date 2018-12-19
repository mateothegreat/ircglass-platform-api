package ircglass;

import lombok.Data;

@Data
public class ClientMessage {

    public String target;
    public String message;

}
