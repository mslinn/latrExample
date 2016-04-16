object Hello extends App {
  import latr._

  lazy val w: Int = {
    println("I will only print once and block the world while doing it!")
    10
  }

  @lazify val x: Int = {
    println("I may print multiple times under thread contention, but I'm super cheap!")
    10
  }

  @lazifyOptimistic val y: Int = {
    println("I will only print once, using fancy atomic stuff!")
    10
  }

  @lazifyPessimistic val z: Int = {
    println("I will only print once, using good old-fashioned synchronized blocks!")
    10
  }

  println(s"w=$w; x=$x; y=$y; z=$z")
  println(s"w=$w; x=$x; y=$y; z=$z")
  println(s"w=$w; x=$x; y=$y; z=$z")
}
