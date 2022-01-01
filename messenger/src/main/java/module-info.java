import org.gradle.sample.messenger.spi.MessageProvider;

module org.gradle.sample.messenger {
    exports org.gradle.sample.messenger;
    exports org.gradle.sample.messenger.spi;
    requires org.apache.commons.lang3;
    requires messages.journal;
    uses MessageProvider;
}
