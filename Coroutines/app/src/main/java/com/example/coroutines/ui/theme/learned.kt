package com.example.coroutines.ui.theme


/**
 *
 *
 *  var text by remember {
mutableStateOf("Text ...")
}
var text2 by remember {
mutableStateOf("Text2 ...")
}
Surface(modifier = Modifier.fillMaxSize()) {
Column {
Text(text = text)
Text(text = text2)

LaunchedEffect(Dispatchers.IO){
val time = measureTimeMillis {
val ans1 = async { doNetWorkCall1() }
val ans2 = async { doNetWorkCall2() }
Log.d(TAG, "${ans1.await()}")
Log.d(TAG, "${ans2.await()}")
text = ans1.await()
text2 = ans2.await()
}
Log.d(TAG, "Took $time")
}
}
}

suspend fun doNetWorkCall1(): String{
delay(1000)
return "Work Done 1..."
}
suspend fun doNetWorkCall2(): String{
delay(3000)
return "Work Done 2..."
}

 *  LaunchedEffect(Unit){
withContext(Dispatchers.Main){
text2 = doNetWorkCal2l()
}

GlobalScope.launch(Dispatchers.IO) {
Log.d(TAG, "Network call start executing on ${Thread.currentThread().name}")
val ans1 = doNetWorkCall()
withContext(Dispatchers.Main){
text = ans1

val job =  GlobalScope.launch(Dispatchers.Default) {

for (i in 20..60){
if(isActive){
Log.d(TAG, "i = $i")
}
runBlocking {
//cancelling main thread and executing after the coroutine job has finished
delay(1000L)
job.cancel()
Log.d(TAG, "Job Canceld")
Log.d(TAG, "main thread ${Thread.currentThread().name}")

}


private fun onButtonClicked(){
//use lifecycle scope to make sure that when the activity is stopped then
// the coroutines do stop and no other resources will be used
lifecycleScope.launch {
while (true){
delay(1000L)
Log.d(TAG, "Still running ...")
}
}
GlobalScope.launch {
delay(5000L)

startActivity(
Intent(this@MainActivity, MainActivity2::class.java)
).also { finish() }

}
}

}
}
}
 */
//val api = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//    .create(MyApi::class.java)

//GlobalScope.launch {
//    val commets = api.getComments().await()
//    for (comment in commets){
//        Log.d(TAG, "${comment.toString()}")
//    }
//}
//data class Comment(
//    val body: String,
//    val email: String,
//    val id: Int,
//    val name: String,
//    val postId: Int
//
//)
//
//interface MyApi{
//    @GET("/comments")
//    fun getComments(): Call<List<Comment>>
//}
