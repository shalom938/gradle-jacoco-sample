/**
 * <code>sample.messaging</code> is a container module for the <code>sample.messenger</code> module plus
 * the message providers modules.
 * <p>
 * it requires only <code>sample.messenger</code> and has gradle dependencies on the provider modules.
 * modules that want to use {@link org.sk.sample.messenger.Messenger} with its providers need only to require
 * <code>sample.messaging</code> and have gradle java dependencies on this module.
 */

module sample.messaging {
    requires transitive sample.messenger;
}
