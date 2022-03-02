/**
 * <code>sample.logging</code> is a container module for logging modules.
 * <p>
 * it requires log4j and other required modules.
 * modules that want to use log4j need only to require <code>sample.logging</code>
 * and add gradle java dependencies on this module.
 */

module sample.logging {
    requires transitive org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires java.scripting; //required by log4j
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
}
