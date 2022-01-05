/**
 * sample.messaging is a container module for the sample.messenger plus the message providers nodules.
 * it requires only sample.messenger and has dependencies on the provider modules.
 * modules that want to use org.sk.sample.messenger.Messenger with its providers need only to require
 * sample.messaging and have gradle java dependencies on this module.
 */

module sample.messaging {
    requires transitive sample.messenger;
}
