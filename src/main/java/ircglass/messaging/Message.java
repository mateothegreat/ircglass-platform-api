package ircglass.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Message {

    private String command;
    private String message;

}
