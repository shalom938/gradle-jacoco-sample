import org.sk.sample.messenger.spi.MessageProvider;

module sample.messenger {
    exports org.sk.sample.messenger to sample.app;
    exports org.sk.sample.messenger.spi;
    requires org.apache.commons.lang3;
    requires sample.messages.journal;
    uses MessageProvider;
}
