# An example project of Java modules with jdk 11 and gradle

This project is an example of an application made of java modules and built with gradle.

the app is a simple http app that has a few `MessageProvider`s, upon request it will return all messages from
all `MessageProvider`s. currently there are two `MessageProvider`s, one that returns the command line that started the
java process and one that returns the system and environment properties.

the main module is *sample.app* in the *application* sub-project. it requires the *sample.messaging* module among others.

messenger is a component that loads `MessageProvider` services and supplies their messages.

messenger also uses a `MessagesJournal` to audit the latest messages. the journal implementation is in a gradle included
build under directory *journals*. journals is a completely independent multimodule project that has its own build
,group, version etc. it produces java modules that are used by the *sample.messages.journal* module. 
it's here mostly to show how a gradle included-build works.

the messaging is a container module that aggregates the messenger and the provider modules, so users can just
depend on the messaging module instead of messenger and all providers.

the main app starts a HttpServer that has two end points: msgs and shutdown.

- http://localhost:8001/msgs :
  will return all messages from all `MessageProvider`.
- http://localhost:8001/msgs?format=short :
  will return all messages from all `MessageProvider` in a trimmed format.
- http://localhost:8001/shutdown :
  stop the server.

## build

./gradlew clean build


## journals
journals is an included build , the project provides a journals. 
Its ok to develop it as a sub project , it will compile fine, but idea will not 'see' everything 
because of jpms issues so to develop it its best to open it in intellij as a regular project.


## logging:

to debug log4j initialization:
export APPLICATION_OPTS=-Dlog4j2.debug=true
see: https://logging.apache.org/log4j/2.x/manual/configuration.html#StatusMessages

log4j is used only in production code, unit tests code print to stdout.

log4j and required libraries need to be in the module path, they can be added with --add-modules
or can be required by consumer modules.
for yaml configuration two more libraries are required: jackson-databind and jackson-dataformat-yaml.
java.scripting module is also required by log4j.
 
so either:
'--add-modules org.apache.logging.log4j,org.apache.logging.log4j.core,java.scripting,com.fasterxml.jackson.databind,com.fasterxml.jackson.dataformat.yaml'
for example:
export APPLICATION_OPTS="-Dorg.apache.logging.log4j.simplelog.StatusLogger.level=TRACE 
    --add-modules org.apache.logging.log4j,org.apache.logging.log4j.core,java.scripting,com.fasterxml.jackson.databind,com.fasterxml.jackson.dataformat.yaml"
or can be added to the application plugin with applicationDefaultJvmArgs.

or can be added to the module-info.java of every module that wants logging:
requires org.apache.logging.log4j;
requires org.apache.logging.log4j.core;
requires java.scripting;
requires com.fasterxml.jackson.databind;
requires com.fasterxml.jackson.dataformat.yaml;

module org.apache.logging.log4j must be in every module-info.java for compilation.

the application uses the required directive in module-info.java. but instead of repeating the requires for log4j in 
every module, there is a logging module, its a container module that only requires the mecessary log4j modules. 
and so other modules can just require 'sample.logging' and add a gradle dependency to logging module. 

the app uses yaml configuration. the file is in src/dist/conf/log4j2.yaml and is copied to the 
distribution to APP_HOME/conf.  and using -Dlog4j.configurationFile to configure log4j with the location.
so the file is not in the classpath.
for unit tests we use xml configuration. so actually only the 'application' module needs the jackson 
modules because its the module that initializes log4j when starting the app. 

every test suite has a log4j2-test.xml in the classpath and this is the configuration that will be used in 
unit testing. the configuration status is set to debug so log4j2 debug info can be found in the test 
results system-out. actually only the first test to run will contain the log4j debug info.
log4j2-test.xml has a different pattern layout where the date is COMPACT, so lines starting with 
something like '20220302123403955 [Test worker] INFO' are our messages. 
the unit tests output can be found in build/test-results of every module.
 

the journals log to slf4j api, the logging module adds a dependency to log4j-slf4j-impl so slf4j
will be routed to log4j.

use System.Logger in unit tests 
