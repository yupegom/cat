package state
import cats.data.State

object StateMonad extends App {
  val step1 = State[Int, String] { num => 
    val ans = num + 1
    (ans, s"Result of step 1 is $ans")
  }

  val step2 = State[Int, String] { num => 
    val ans = num * 2
    (ans, s"Result of step 2 is $ans")
  }

  val result = for {
    s1 <- step1
    s2 <- step2
  }yield (s1, s2)

  val (state, ans) = result.run(10).value
  println(s"The state is $state and the answer is $ans")
}
