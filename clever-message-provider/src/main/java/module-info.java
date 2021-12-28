import org.gradle.sample.clever.CleverMessageProvider;

module org.gradle.sample.cleverMessageProvider {
    requires org.gradle.sample.messenger;
    provides org.gradle.sample.messenger.MessageProvider
            with CleverMessageProvider;
}
