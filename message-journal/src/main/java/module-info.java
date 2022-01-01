module sample.messages.journal {
    requires utilities;
    requires transitive sample.journal.all;
    requires com.google.common;
    exports org.sk.sample.messagejournal to sample.messenger;
}
