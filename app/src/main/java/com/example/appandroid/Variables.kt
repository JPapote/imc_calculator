package com.example.appandroid

fun main() {
   // println("hola mundo fuck yeah!")
   // showMyName("Papote")
   // getTrimester(11)
    val result = ticketPrice(33, true)

    println(result)
}

fun showMyName(name:String){
    print("Tu nombre es $name, o no que si?")
}

fun getTrimester(month: Int){
    when(month){
        1 -> print("Enero")
        2 -> print("Febrero")
        3 -> print("Marzo")
        4 -> print("Abril")
        5 -> print("Mayo")
        6 -> print("Julio")
        7 -> print("Junio")
        8 -> print("Agosto")
        9 -> print("Septiembre")
        10 -> print("Octubre")
        11 -> {
            monthDiciember();
            print("Para mas funciones")
        }
        12 -> print("Diciembre")
    }

    //Se puede agregar un else como si fuera un if tambien
}
fun monthDiciember(){
    println("dicimber")
}

fun ticketPrice(age:Int, isMonday: Boolean): Int{
    // los .. es para indicar el rango en el rago en el debe estar
   return when(age){
        in 0 .. 12 -> 15
        in 13 .. 60 -> if (isMonday) 25 else 30
        else -> -1
    }
}