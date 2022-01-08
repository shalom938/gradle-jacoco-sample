/**
 * this is only a test util module , classes to be used in unit testing.
 * A regular jar doesn't play well with gradle modular testing and module patching, even trying to make
 * it automatic module didn't play well.
 * gradle test fixture also didn't play well with modules and the new JvmTestSuite.
 */
module sample.testutils {
    exports org.sk.sample.test;
    requires org.apache.commons.lang3;
    requires java.management;
}
