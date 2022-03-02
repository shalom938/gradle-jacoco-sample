import org.sk.sample.message.spi.MessageProvider;

module sample.messenger {
    exports org.sk.sample.messenger;
    requires sample.messages.journal;
    requires sample.message.provider;
    requires sample.logging;
    uses MessageProvider;
}
