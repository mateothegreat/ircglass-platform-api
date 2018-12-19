package ircglass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(final ClientService clientService) {

        this.clientService = clientService;

    }

    @GetMapping
    public void connect() {

        clientService.connect();

    }

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody ClientMessage clientMessage) {

        clientService.sendMessage(clientMessage.target, clientMessage.message);

        return new ResponseEntity<>("OK", HttpStatus.OK);
        
    }

}

