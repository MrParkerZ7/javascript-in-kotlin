function getResult(v1 , v2){
    var javaClass = Java.type("com.pucker.javascriptinkotlin.Method")
    print("Your java result is '" + javaClass.makeResult( v1 , v2 ) + "'")
}