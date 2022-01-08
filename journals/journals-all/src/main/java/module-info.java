module sample.journal.all {
    //sample.journal is transitive so users of this module can directly use classes in sample.journal
    //without the need to require it in their module-info. it's like saying 'who ever requires this module can
    //also access the api exposed by sample.journal as if they required it'
    //it corresponds to gradle 'api' configuration
    requires transitive sample.journal;
    requires sample.journal.impl;
    requires org.apache.commons.lang3;

    exports org.sk.sample.journals;
    exports org.sk.sample.journals.exception;
}
