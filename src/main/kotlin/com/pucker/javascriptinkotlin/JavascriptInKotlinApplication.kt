package com.pucker.javascriptinkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.FileReader
import javax.script.Invocable
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

@SpringBootApplication
class JavascriptInKotlinApplication

fun main(args: Array<String>) {
    runApplication<JavascriptInKotlinApplication>(*args)

    tryScriptEngine()
}

fun tryScriptEngine() {
    val engine: ScriptEngine = ScriptEngineManager().getEngineByName("nashorn")
    engine.eval("print('running javascript on kotlin')")
    engine.eval(FileReader("src/main/resources/js/script.js"))
    engine.eval(FileReader("src/main/resources/js/function.js"))
    engine.eval(FileReader("src/main/resources/js/java.js"))

    val invocable: Invocable = engine as Invocable;

    val result = invocable.invokeFunction("showValue", "Zero", 99.99)
    println("Result from javascript =$result")

    invocable.invokeFunction("getResult", "Zero", 99.99)


}


