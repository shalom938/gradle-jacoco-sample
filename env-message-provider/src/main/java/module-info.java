import org.gradle.sample.env.EnvMessageProvider;
import org.gradle.sample.messenger.spi.MessageProvider;

module org.gradle.sample.envMessageProvider {
    requires org.gradle.sample.messenger;
    provides MessageProvider
            with EnvMessageProvider;
}
