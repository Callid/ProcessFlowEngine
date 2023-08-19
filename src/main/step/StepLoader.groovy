package main.step

import org.yaml.snakeyaml.Yaml

/**
 * Created on 2023-08-19.
 */
@groovy.transform.CompileStatic
class StepLoader {
    StepConfig[] steps

    Step[] loadSteps() {
        Step[] s = new Step[steps.length]
        for (int i=0; i<s.length; i++) {
            s[i] = steps[i].loadStep()
        }
        return s
    }

    static StepLoader loadFromFile(String fileName) {
        Yaml loader = new Yaml()
        InputStream inputStream = new FileInputStream(new File(fileName))
        StepLoader sc = loader.load(inputStream)
        return sc
    }
}
