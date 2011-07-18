## _spray_ Template Project 

1. Git-clone this repository. Alternatively, download and extract a [tarball](http://github.com/spray/spray-template/tarball/master) or [zip](http://github.com/sirthias/spray-template/zipball/master).

        $ git clone git://github.com/spray/spray-template.git my-project

2. Change directory into your clone:

        $ cd my-project

3. Launch [SBT](http://code.google.com/p/simple-build-tool) (note that you will need SBT 0.10.1):

        $ sbt

4. Fetch the dependencies:

        > update

5. Start Jetty, enabling continuous compilation and reloading:

        > jetty-run
        > ~prepare-webapp

6. Browse to http://localhost:8080/

7. Learn more at http://www.spray.cc/

8. Start hacking on `src/main/scala/com/example/HelloServiceBuilder.scala`

