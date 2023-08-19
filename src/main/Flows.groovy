package main

/**
 * Created on 2023-08-19.
 */
@groovy.transform.CompileStatic
class Flows {
    Flow[] flows

    Flows() {
        flows = []
    }

    Flows(Flow a) {
        flows = [a]
    }

    Flows(Flow a, Flow b) {
        flows = [a, b]
    }

    String toString() {
        String result = "["
        for (Flow f in flows) {
            result += f.toString() + "; "
        }
        result = result.substring(0, result.length()-2) + "]"
        return result
    }
}
