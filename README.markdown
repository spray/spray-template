## _spray_ Template Project 

1. Git-clone this repository. Alternatively, download and extract a [tarball] or [zip].

        $ git clone git://github.com/spray/spray-template.git my-project

2. Change directory into your clone:

        $ cd my-project

3. Launch [SBT] (SBT 0.7.7, if you'd like to use 0.10.x use the `sbt-0.10` branch of this repository):

        $ sbt

4. Fetch the dependencies:

        > update

5. Compile everything and run all tests:

        > test

6. Start Jetty and enable continuous compilation and reloading:

        > jetty-run
        > ~prepare-webapp

7. Browse to http://localhost:8080/

8. Learn more at http://www.spray.cc/

9. Start hacking on `src/main/scala/com/example/HelloService.scala`


Apart from the Scala sources in the `src/main/scala` tree the following non-Scala configuration files are important for
SBTs "jetty-run mode":

* `src/main/resources/akka.conf`, the combined Akka and _spray_ configuration file 
* `src/main/resources/logback.xml`, the config file for the [SLF4J] logging backend "logback" (not required but recommended)
* `src/main/webapp/WEB-INF/web.xml`, the config file for the sbt-internal Jetty instance

If you'd like to deploy your _spray_ application in Akkas microkernel you can use the config files in the `config`
directory as a starting point, namely:

* `config/akka.conf`, the combined Akka and _spray_ configuration file for microkernel deployments  
* `config/microkernel-server.xml`, the config file for the Akka microkernel-internal Jetty instance  


[tarball]: http://github.com/spray/spray-template/tarball/master
[zip]: http://github.com/sirthias/spray-template/zipball/master
[SBT]: http://code.google.com/p/simple-build-tool
[SLF4J]: http://www.slf4j.org