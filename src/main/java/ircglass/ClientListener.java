package ircglass;

import ircglass.messaging.Message;
import ircglass.messaging.MessagingService;
import net.engio.mbassy.listener.Handler;
import org.kitteh.irc.client.library.event.channel.ChannelJoinEvent;
import org.kitteh.irc.client.library.event.client.ClientNegotiationCompleteEvent;
import org.kitteh.irc.client.library.event.client.ClientReceiveCommandEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientListener {

    private final MessagingService messagingService;

    @Autowired
    public ClientListener(final MessagingService messagingService) {

        this.messagingService = messagingService;

    }

    @Handler
    public void onUserJoinChannel(ChannelJoinEvent event) {

        if (event.getClient().isUser(event.getUser())) { // It's me!

            event.getChannel().sendMessage("Hello world! Kitteh's here for cuddles.");
            return;

        }
        // It's not me!
        event.getChannel().sendMessage("Welcome, " + event.getUser().getNick() + "! :3");

    }


    @Handler
    public void meow(ClientNegotiationCompleteEvent event) {

        System.out.println("I am connected!");

    }

    //        @CommandFilter("PRIVMSG")
    @Handler
    public void privmsg(ClientReceiveCommandEvent event) {

        System.out.println("COMMAND=" + event.getCommand() + ", MESSAGE=" + event.getOriginalMessage());

        messagingService.send(new Message(event.getCommand(), event.getOriginalMessage()));
        
    }

}
