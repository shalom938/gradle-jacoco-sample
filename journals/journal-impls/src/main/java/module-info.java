module sample.journal.impl {
    requires sample.journal;
    requires com.google.common;
    requires org.slf4j;
    //open the package for reflection to commons-lang3 because we do reflection with commons-lang3
    opens org.sk.sample.journal.impl.string to sample.journal.all, org.apache.commons.lang3;
}
