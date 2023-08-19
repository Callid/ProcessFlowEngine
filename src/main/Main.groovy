package main

import main.step.*
import org.yaml.snakeyaml.Yaml

/**
 * Created on 2023-08-19.
 */
@groovy.transform.CompileStatic
class Main {
    public static final String STEP_CONFIG = "cfg/steps.yaml"
    public static final String FLOW_CONFIG = "cfg/flows.yaml"

    public static void main(String[] args) {
        //test()

        StepLoader sc = StepLoader.loadFromFile(STEP_CONFIG)
        Step[] steps = sc.loadSteps()
        steps[0].execute()
    }

    static void test() {
        Map<String,Object> map = loadYamlString("cfg/stepTest.yaml")
        for(String s in map.keySet()) {
            println("${map[s].class}: $s = ${map[s]}")
        }

        println("Test A done")

        Yaml loader = new Yaml()
        InputStream inputStream = new FileInputStream(new File("cfg/test.yaml"))
        Flow flow = loader.load(inputStream)
        println(flow)

        FlowsHolder fh = new FlowsHolder()
        fh.flows = new Flows()
        fh.flows.flows = new Flow[2]
        fh.flows.flows[1] = (flow)
        Flow flow2 = new Flow()
        flow2.name = "logAnalyzer"
        flow2.queue = "com.acme.analyzer"
        flow2.steps = ["doSomething"].toArray(new String[0])
        fh.flows.flows[0] = (flow2)

        print(getYaml(fh))

        Yaml loader2 = new Yaml()
        InputStream inputStream2 = new FileInputStream(new File("cfg/flowTest.yaml"))
        Flows flows = loader.load(inputStream2)
        List<Object> flowArray = loader2.loadAll(inputStream2).toList()
        println(flows)
        println(flowArray)

        print(getYaml(flows))
    }

    static Map<String,Object> loadYamlString(String filename) {
        Yaml loader = new Yaml()
        InputStream inputStream = new FileInputStream(new File(filename))
        return loader.load(inputStream)
    }

    static String getYaml(Object o) {
        Yaml yaml = new Yaml()
        StringWriter writer = new StringWriter()
        yaml.dump(o,writer)
        return writer.toString()
    }
}
