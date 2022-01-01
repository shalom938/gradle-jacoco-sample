import org.gradle.sample.env.EnvMessageProvider;
import org.gradle.sample.messenger.spi.MessageProvider;

module sample.envMessageProvider {
    requires sample.messenger;
    provides MessageProvider
            with EnvMessageProvider;
}
