# This is a simple journal used by java modules example.

this project produces two main modules: sample.journal and sample.journal.impl. the module sample.journal.all is a
container module that contains the two above. users can '*requires sample.journal.all*' if they want both the interface
and some implementations. or they can '*requires sample.journal*' if they want only the interface.

the implementation packages in module sample.journal.impl are hidden, the module only opens reflection access to the
module sample.journal.

