package ircglass;

import ircglass.messaging.MessagingService;
import org.kitteh.irc.client.library.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final MessagingService messagingService;
    private final ClientListener   clientListener;
    private       Client           client;

    @Autowired
    public ClientService(final MessagingService messagingService,
                         final ClientListener clientListener) {

        this.messagingService = messagingService;
        this.clientListener = clientListener;

    }

    public void connect() {

        client = Client.builder().nick("af3f334f4a3f").serverHost("chat.freenode.net").buildAndConnect();

        client.getEventManager().registerEventListener(clientListener);
        client.addChannel("#agaeq14");
        client.sendMessage("mateothegreat", "connect");

    }

    public void sendMessage(String target, String message) {

        client.sendMessage(target, message);

    }

}
