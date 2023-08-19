package main.step

/**
 * Created on 2023-08-19.
 */
@groovy.transform.CompileStatic
class HelloWorld extends Step{
    @Override
    void execute() {
        println("Hello World!")
    }
}
