## _spray_ Template Project 

1. Git-clone this repository. Alternatively, download and extract a [tarball](http://github.com/spray/spray-template/tarball/master) or [zip](http://github.com/sirthias/spray-template/zipball/master).

        $ git clone git://github.com/spray/spray-template.git my-project

2. Change directory into your clone:

        $ cd my-project

3. Launch [SBT](http://code.google.com/p/simple-build-tool) (SBT 0.7.7, if you'd like to use 0.10.x use the `sbt-0.10` branch of this repository):

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

