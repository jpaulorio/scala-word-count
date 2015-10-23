package com.datatraining.scala

import scalax.file.Path
import scalax.io._
import java.io._

object WordCount {

	def main(args: Array[String]) {

		val inputFile = args(0)

		val outputFile = args(1)

		val path: Path = Path (outputFile)
		
		path.deleteRecursively(continueOnFailure = false)

		val input = io.Source.fromFile(inputFile).getLines()

		val words = input.flatMap(line => line.split(" "))

		val wordsMap = words.map(word => (word, 1)).toList

		val grouped = wordsMap.groupBy(_._1)

		val reduced = for (i <- grouped) yield (i._1, i._2.foldLeft(0)((acc,x) => acc + x._2))

		val sorted = reduced.toList.sortWith(_._2 > _._2)

		val writer = new PrintWriter(new File(outputFile))
		for (l <- sorted) yield writer.write(s"${l._1} :: ${l._2}\n")
		writer.close()

		println(s"Done! Result saved to $outputFile")
	}

}