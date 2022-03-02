import org.sk.sample.env.EnvMessageProvider;
import org.sk.sample.message.spi.MessageProvider;

module sample.envMessageProvider {
    requires transitive sample.message.provider;
    requires sample.logging;
    provides MessageProvider with EnvMessageProvider;
}
