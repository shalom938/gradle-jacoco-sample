import org.gradle.sample.cmd.CommandLineMessageProvider;

module org.gradle.sample.cmdMessageProvider {
    requires org.gradle.sample.messenger;
    provides org.gradle.sample.messenger.MessageProvider
            with CommandLineMessageProvider;
}
