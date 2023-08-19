package main.step

/**
 * Created on 2023-08-19.
 */
@groovy.transform.CompileStatic
abstract class Step {
    String name

    abstract void execute()
}
