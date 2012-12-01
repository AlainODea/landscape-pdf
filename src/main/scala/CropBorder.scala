/*
 *     Licensed to the Apache Software Foundation (ASF) under one
 *     or more contributor license agreements.  See the NOTICE file
 *     distributed with this work for additional information
 *     regarding copyright ownership.  The ASF licenses this file
 *     to you under the Apache License, Version 2.0 (the
 *     "License"); you may not use this file except in compliance
 *     with the License.  You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *     Unless required by applicable law or agreed to in writing,
 *     software distributed under the License is distributed on an
 *     "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *     KIND, either express or implied.  See the License for the
 *     specific language governing permissions and limitations
 *     under the License.
 */
import com.lowagie.text.Document
import com.lowagie.text.Rectangle
import com.lowagie.text.pdf.PdfReader
import com.lowagie.text.pdf.PdfWriter
import java.io.{File, FileOutputStream}
import org.clapper.argot._

object CropBorder {
  import ArgotConverters._
  implicit def convertFile(string: String, option: CommandLineArgument[File]): File =
    new File(string)

  val parser = new ArgotParser("CropBorder")
  val inputOption = parser.option[File]("in", "input_file", "PDF File to convert")
  val outputOption = parser.option[File]("out", "output_file", "PDF File to create")
  val factorOption = parser.option[Float](List("f", "factor"), "factor", "Scaling factor")
  val leftOption = parser.option[Float](List("l", "left"), "left", "Left edge offset")
  val downOption = parser.option[Float](List("d", "down"), "down", "Top edge offset")

  def main(args: Array[String]) {
    crop(args)
  }

  def crop(args: Array[String]) {
    parser.parse(args)
    val input = (inputOption.value.get)
    val output = (outputOption.value.get)
    val factor = (factorOption.value.get)
    val left = (leftOption.value.get)
    val down = (downOption.value.get)

    println(<text>Converting: {input} to {output} scaling by {factor} shifting by ({left}, {down})</text>.text)
    val reader = new PdfReader(input.getAbsolutePath)
    //val psize: Rectangle = reader.getPageSize(1)
    // TODO: calculate factor based on psize versus ideal iPad size
    val width = 600.0f
    val height = 400.0f
    val document = new Document(new Rectangle(height, width))
    val writer = PdfWriter.getInstance(document, new FileOutputStream(output))
    document.open()
    val outputDirectContent = writer.getDirectContent
    for (i <- 1 to reader.getNumberOfPages) {
      // add handling of title, left and right pages
      document.newPage()
      val page = writer.getImportedPage(reader, i)
      outputDirectContent.addTemplate(page, factor, 0, 0, factor, left, down)
    }
    document.close()
  }
}
