import org.gradle.sample.cmd.CommandLineMessageProvider;
import org.gradle.sample.messenger.spi.MessageProvider;

module org.gradle.sample.cmdMessageProvider {
    requires org.gradle.sample.messenger;
    provides MessageProvider
            with CommandLineMessageProvider;
}
