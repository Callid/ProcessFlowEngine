package main

/**
 * Created on 2023-08-19.
 */
@groovy.transform.CompileStatic
class Flow {
    String name
    String queue
    String[] steps

    String toString() {
        String result = "name = $name, queue = $queue, ${steps.length} steps"
    }
}
