import com.lowagie.text.Document
import com.lowagie.text.Rectangle
import com.lowagie.text.pdf.PdfReader
import com.lowagie.text.pdf.PdfWriter
import java.io.{File, FileOutputStream}
import uk.co.flamingpenguin.jewel.cli

object CropBorder {
  trait Croperation {
    @cli.Option(longName = "in", defaultValue = Array("in.pdf")) def input: File
    @cli.Option(longName = "out", defaultValue = Array("out.pdf")) def output: File
    @cli.Option(defaultValue = Array("1")) def factor: Float
    @cli.Option(defaultValue = Array("0")) def left: Float
    @cli.Option(defaultValue = Array("0")) def down: Float
  }

  def main(args: Array[String]) {
    try {
      crop(cli.CliFactory.parseArguments(classOf[Croperation], args:_*))
    } catch {
      case e: cli.ArgumentValidationException => println(e getMessage)
    }
  }

  def crop(croperation: Croperation) {
    import croperation._
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
