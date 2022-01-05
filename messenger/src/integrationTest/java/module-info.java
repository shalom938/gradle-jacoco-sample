import org.sk.sample.message.spi.MessageProvider;

open module sample.messenger.it {
    requires sample.messenger;
    requires sample.message.provider;
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.params;
    requires org.apache.commons.lang3;
    requires java.management;
    requires sample.testutils;
    uses MessageProvider;
}
