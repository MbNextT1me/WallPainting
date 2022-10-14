import java.nio.file.Paths
import java.nio.file.Files

fun printArr(arr:Array<IntArray>, n: Int, m:Int) {
    for (i in 0..n-1){ for (j in 0..m-1)print(arr[i][j])
        println()}
}

fun paintWall(arr:Array<IntArray>, k: Int, n: Int, m:Int) {
    var maxV: Int = 0
    var maxH: Int = 0


    for (i in 0..n-1){
        var counter = 0
        for (j in 0..m-1) {
            if (arr[i][j] != 0) counter++
        }
        if (counter > maxH) maxH = counter
    }

    for (i in 0..m-1){
        var counter = 0
        for (j in 0..n-1) {
            if (arr[j][i] != 0) counter++
        }
        if (counter > maxV) maxV = counter
    }

    if (k < maxV && k < maxH ) {
        println("No")
    }
    else{
        var l = 0
        if (maxH > maxV) l = maxH
        else l = maxV
        for (i in 0..n-1){
            var counter = i
            for (j in 0..m-1) {
                if (arr[i][j] != 0) {
                    if (counter >= l) counter = 0
                    counter++
                    arr[i][j] = counter
                }
                else {counter++}
            }
        }
        println("Yes")
        printArr(arr,n,m)
    }

}

fun main(){
    val lines = arrayListOf<String>()
    val path = Paths.get("test.txt")
    Files.readAllLines(path, Charsets.UTF_8).forEach {lines.add(it)}

    var c_lines = 0
    val t = lines[c_lines].toInt()

    //Считываем файл, после чего вызываем функцию закраски и пишем, что для массива данных i результат yes or now
    for (z in 1..t){
        c_lines++
        var list = lines[c_lines].split(" ")
        val n = list[0].toInt()
        val m = list[1].toInt()
        val k = list[2].toInt()
        val arr = Array(n) { IntArray(m)}
        for (i in 0..n-1) {
            c_lines++
            list = lines[c_lines].split(" ")
            for (j in 0..m-1) {
                arr[i][j] = list[j].toInt()
            }
        }
        paintWall(arr, k, n, m)
    }
}