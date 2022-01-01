import org.sk.sample.cmd.CommandLineMessageProvider;
import org.sk.sample.messenger.spi.MessageProvider;

module sample.cmdMessageProvider {
    requires sample.messenger;
    provides MessageProvider with CommandLineMessageProvider;
}
