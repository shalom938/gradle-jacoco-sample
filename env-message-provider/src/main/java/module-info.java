import org.sk.sample.env.EnvMessageProvider;
import org.sk.sample.messenger.spi.MessageProvider;

module sample.envMessageProvider {
    requires sample.messenger;
    provides MessageProvider with EnvMessageProvider;
}
