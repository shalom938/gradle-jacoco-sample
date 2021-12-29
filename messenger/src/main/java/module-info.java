import org.gradle.sample.messenger.MessageProvider;

module org.gradle.sample.messenger {
    exports org.gradle.sample.messenger;
    requires org.apache.commons.lang3;
    uses MessageProvider ;
}
