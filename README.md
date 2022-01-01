# An example project of Java modules with jdk 11 and gradle

This project is an example of an application made of java modules and built with gradle.

the app is a simple http app that has a few `MessageProvider`s, upon request it will 
return all messages from all `MessageProvider`s.
currently there are two `MessageProvider`s, one that returns the command line that
started the java process and one that returns the system and environment properties.

the main module is *sample.app* in the *application* sub-project.
it requires the *messenger* module among others.

messenger is a component that loads `MessageProvider` services
and supplies their messages.

messenger also uses a `MessagesJournal` to audit the latest messages.
the journal implementation is in a gradle included build under 
directory *journals*. journals is a completely independent multimodule project 
that has its own build ,group, version etc. it produces java modules used by the main app.
it's here mostly to show how a gradle included-build works.

the messaging is just a container module that aggregates the messenger and the provider modules,
so users can just depend on the messaging module instead of messenger and all providers.


the main app starts a HttpServer that has two end points: msgs and shutdown.

- http://localhost:8001/msgs : 
will return all messages from all `MessageProvider`.
- http://localhost:8001/msgs?format=short : 
will return all messages from all `MessageProvider` in a short format.
- http://localhost:8001/shutdown : 
stop the server.


## build
./gradlew clean build