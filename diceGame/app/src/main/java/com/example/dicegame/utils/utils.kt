fun rollDice():Int{
    val listOfNumbers = listOf(1,2,3,4,5,6)
    return listOfNumbers.random()
}

fun rollNumber(): String {
    val num: Int = 0
    var list = listOf<Int>()
    while (num<1000){
       list = listOf(num)
    }
    return list.random().toString()
}