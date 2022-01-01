module messages.journal {
    requires utilities;
    requires transitive sample.journal.all;
    requires com.google.common;
    exports org.gradle.sample.journal;
}
