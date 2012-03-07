## _spray_ Template Project

This projects provides a starting point for your own _spray-server_ on _spray-can_ endeavors.
The branch you are currently looking at is targeted at **_spray_ 0.9.0**.

Boot strap your application by following these steps:

1. Git-clone this repository.

        $ git clone git://github.com/spray/spray-template.git my-project

2. Change directory into your clone:

        $ cd my-project

3. Launch [SBT] (SBT 0.11):

        $ sbt

4. Compile everything and run all tests:

        > test

5. Start the application:

        > re-start

6. Browse to http://localhost:8080/

7. Start the application:

        > re-stop

8. Learn more at http://www.spray.cc/

9. Start hacking on `src/main/scala/com/example/HelloService.scala`


Apart from the Scala sources in the `src/main/scala` tree the following non-Scala configuration files are important:

* `src/main/resources/akka.conf`, the combined Akka and _spray_ configuration file 
* `src/main/resources/logback.xml`, the config file for the [SLF4J] logging backend "logback" (not required but recommended)

  [SBT]: https://github.com/harrah/xsbt/wiki
  [SLF4J]: http://www.slf4j.org