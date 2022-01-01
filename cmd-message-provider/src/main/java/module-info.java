import org.gradle.sample.cmd.CommandLineMessageProvider;
import org.gradle.sample.messenger.spi.MessageProvider;

module sample.cmdMessageProvider {
    requires sample.messenger;
    provides MessageProvider
            with CommandLineMessageProvider;
}
