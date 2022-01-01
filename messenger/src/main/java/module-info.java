import org.sk.sample.messenger.spi.MessageProvider;

module sample.messenger {
    exports org.sk.sample.messenger;
    exports org.sk.sample.messenger.spi;
    requires org.apache.commons.lang3;
    requires messages.journal;
    uses MessageProvider;
}
