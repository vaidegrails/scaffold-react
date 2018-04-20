package com.scaffoldreact.scaffoldreact.util

import groovy.util.logging.Slf4j

@Slf4j
class ClosureReader {

    Map props = [:]
    String subKey

    ClosureReader(Closure c) {
        currentElement = convertedClosure
        iterate(c)
    }


    Map convertedClosure = [:]

    Map currentElement

    /**
     * Given a closure, iterates over all the keys
     * @param c
     * @return
     */
    def iterate(Closure c) {
        c.delegate = this
        c.each { key->
            "$key"()
        }

    }

    def methodMissing(String methodName, args) {
        log.trace ("Reading method ${methodName} with args: ${args}")
        if (methodName) {
            currentElement[methodName] = [:]
        }
        def auxElement = currentElement
        if (!args.size()) {
            return
        }

        // If the first arg is a closure, call recursive method
        for (def argument: args) {
            if (argument in Closure) {
                currentElement = currentElement[methodName]
                iterate(argument)
                currentElement = auxElement
            }
            else if (argument in Map){
                argument.keySet().each { key->
                    if (argument[key] in Closure) {
                        handleNestedClosure(methodName, key, argument, auxElement)
                    }
                    else if (argument[key] in Map) {
                        currentElement[methodName][key] = [:]
                        currentElement = currentElement[methodName][key]
                        def newArgument = argument[key]
                        newArgument.keySet().each { newKey ->
                            if (newArgument[newKey] in Closure){
                                handleNestedClosure(methodName, newKey, newArgument, auxElement)
//                                currentElement[methodName][key] = [:]
//                                currentElement = currentElement[methodName][key]
//                                iterate(argument[key])
//                                currentElement = auxElement
                            }
                            else if (argument[newKey] in Map){
                                //TODO: Does this ever happen?
                            }
                            else {
                                currentElement[newKey] = newArgument[newKey]
                            }


//
                        }
                        currentElement = auxElement

                    }
                    else {
                        currentElement[methodName][key] = argument[key]
                    }

                }
            }
            else {
                currentElement[methodName] = argument
            }

        }

        log.trace "Current element: ${currentElement}"

        return ["${methodName}": args[0]]
    }




    private void handleNestedClosure(String methodName, key, argument, auxElement) {
        currentElement[methodName][key] = [:]
        currentElement = currentElement[methodName][key]
        iterate(argument[key])
        currentElement = auxElement
    }

    def propertyMissing(String name) { name }


    static Map toMapConfig(Closure closure) {

        ClosureReader closureReader = new ClosureReader(closure)
        log.debug "Converted closure: ${closureReader.convertedClosure}"
        return closureReader.convertedClosure
    }

    static Map toMapConfig(Map mapa) {
        return mapa
    }


    static Map toMapConfig(def closure, Class aClass, List nameIncludes) {
        return new ClosureReader(closure).props
    }

}

