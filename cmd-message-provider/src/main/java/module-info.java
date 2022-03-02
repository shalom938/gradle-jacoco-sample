import org.sk.sample.cmd.CommandLineMessageProvider;
import org.sk.sample.message.spi.MessageProvider;

module sample.cmdMessageProvider {
    requires transitive sample.message.provider;
    requires sample.logging;
    provides MessageProvider with CommandLineMessageProvider;
}
