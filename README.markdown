## _spray_ Template Project

This projects provides a starting point for your own _spray-routing_ endeavors.
There are two branches:

* The `on_spray-can` branch provides a template for a _spray-routing_ on _spray-can_ application.
* The `on_jetty` branch provides a template for a _spray-routing_ on _Jetty_ application.

You are currently on the `on_spray-can` branch.

Follow these steps to get started:

1. Git-clone this repository.

        $ git clone git://github.com/spray/spray-template.git my-project

2. Change directory into your clone:

        $ cd my-project

3. Launch SBT:

        $ sbt

4. Compile everything and run all tests:

        > test

5. Start the application:

        > re-start

6. Browse to http://localhost:8080/

7. Start the application:

        > re-stop

8. Learn more at http://www.spray.io/

9. Start hacking on `src/main/scala/com/example/MyService.scala`