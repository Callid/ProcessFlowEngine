package main.step

import main.Flow
import org.yaml.snakeyaml.Yaml

/**
 * Created on 2023-08-19.
 */
@groovy.transform.CompileStatic
class StepConfig {
    String name
    String className

    Step loadStep() {
        Class<?> stepClass = Class.forName(className)
        Object step = stepClass.getDeclaredConstructor().newInstance()

        if (step instanceof Step) {
            return step
        } else {
            throw new IllegalArgumentException("Step $name is defined with class $className, but class is not a subclass of Step!")
        }
    }
}
