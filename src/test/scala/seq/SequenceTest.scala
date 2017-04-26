package seq

import org.junit.Assert.assertEquals
import org.junit.Test

import scala.collection.mutable


class SequenceTest {

  @Test
  def sequenceAppendAndPrepend() = {
    //given
    val sequence = Seq(1, 2)

    //when
    val appendSequence = sequence :+ 3
    val prependSequence = 0 +: sequence

    //then
    assertEquals(List(1, 2, 3), appendSequence)
    assertEquals(List(0, 1, 2), prependSequence)
  }

  @Test
  def padToExample() = {
    //given
    val ints = IndexedSeq(1, 2, 3)

    //when
    val indexedSeq: IndexedSeq[Int] = ints.padTo(5, 9)

    //then
    assertEquals(IndexedSeq(1, 2, 3, 9, 9), indexedSeq)
  }

  @Test
  def mutableSequenceCanBeUpdated() = {
    //given
    val seq = mutable.Seq(1, 2, 3)

    //when
    seq(2) = 99

    //then
    assertEquals(mutable.Seq(1, 2, 99), seq)
  }

}
