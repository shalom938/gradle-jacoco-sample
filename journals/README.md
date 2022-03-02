# This is a simple journal used by java modules example.

this project produces two main modules: sample.journal and sample.journal.impl.<br/>
the module sample.journal.all is a container module that contains the two above.<br/>
users can '*requires sample.journal.all*' if they want both the interface and some implementations.<br/>
or they can '*requires sample.journal*' if they want only the interface.<br/>

the implementation packages in module sample.journal.impl are hidden, the module only opens reflection access to the
module sample.journal-all.


# build

to work on this project its best to open it in idea as a regular project

./gradlew clean build

# logging
the code uses slf4j-api for logging with no default implementation. for unit testing slf4j-simple is used
with configuration in src/test/resources/simplelogger.properties.
consumer modules should provide an implementation for slf4j, without that slf4j will default to no-op logger.
an implementation could be slf4j-simple of slf4j to log4j2 bridge.