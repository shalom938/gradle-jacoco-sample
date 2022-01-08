import org.sk.sample.cmd.CommandLineMessageProvider;
import org.sk.sample.message.spi.MessageProvider;

module sample.cmdMessageProvider {
    requires transitive sample.message.provider;
    provides MessageProvider with CommandLineMessageProvider;
}
