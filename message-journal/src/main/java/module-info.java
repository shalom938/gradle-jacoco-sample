module sample.messages.journal {
    requires utilities;
    requires transitive sample.journal.all;
    requires com.google.common;
    requires sample.logging;
    exports org.sk.sample.messagejournal to sample.messenger;
}
