package state

import cats.data.State

object PostOrderCalc {

  type CalcState[A] = State[List[Int], A]

  val operators = List("+", "-", "*")
  def evalOne(sym: String): CalcState[Int] = State[List[Int], Int] {
    stack => 
    if(operators.contains(sym)){
      val op1 = stack.head
      val op2 = stack.tail.head
      val newStack = stack.tail.tail
      (newStack, stringToOp(sym)(op1.toInt, op2.toInt))
    }
    else (sym.toInt :: stack, sym.toInt)
  }

  def stringToOp(op: String): (Int, Int) => Int = {
    op match {
      case "+" => _ + _
      case "-" => _ - _
    }
  }

  def evalAll(syms: List[String]): CalcState[Int] = State[List[Int], Int]{ stack => 
    syms match {
      case h :: t => 
        for {
        _ <- evalOne(syms.head)
        ans <- evalAll(syms.tail)
        } yield ans
      case Nil => ???
  }
  }
}
