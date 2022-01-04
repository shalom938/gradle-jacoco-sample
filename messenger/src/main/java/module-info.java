import org.sk.sample.message.spi.MessageProvider;

module sample.messenger {
    exports org.sk.sample.messenger to sample.app;
    requires sample.messages.journal;
    requires sample.message.provider;
    uses MessageProvider;
}
