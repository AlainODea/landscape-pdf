import com.lowagie.text.Document
import com.lowagie.text.Rectangle
import com.lowagie.text.pdf.PdfReader
import com.lowagie.text.pdf.PdfWriter
import java.io.FileOutputStream

object CropBorder {
  def main(args: Array[String]) {
    var input = "in.pdf"
    var output = "out.pdf"
    var factor = 1.4f
    var left = -100.0f
    var down = -130.0f
    for ((arg, i) <- args.zipWithIndex) {
      if ("-h".equals(arg)) {
        println("Usage: java -jar cropborder.jar [-in <input.pdf>] [-out <output.pdf>] [-f <scaling factor>] [-l <dots to move the left border>] [-d <dots to move the lower border>]")
        exit(1)
      }
      else if ("-in".equals(args(i))) {
        input = args(i + 1)
      }
      else if ("-out".equals(args(i))) {
        output = args(i + 1)
      }
      else if ("-f".equals(args(i))) {
        factor = args(i + 1).toFloat
      }
      else if ("-l".equals(args(i))) {
        left = args(i + 1).toFloat
      }
      else if ("-d".equals(args(i))) {
        down = args(i + 1).toFloat
      }
    }
    println("Converting: " + input + " to " + output + " scaling by " + factor + " shifting by (" + left + ", " + down + ")")
    val reader = new PdfReader(input)
    val n = reader.getNumberOfPages
    //val psize: Rectangle = reader.getPageSize(1)
    // TODO: calculate factor based on psize versus ideal iPad size
    val width = 600.0f
    val height = 400.0f
    val document = new Document(new Rectangle(height, width))
    val writer = PdfWriter.getInstance(document, new FileOutputStream(output))
    document.open()
    val cb = writer.getDirectContent
    for (i <- 1 to n) {
      // add handling of title, left and right pages
      document.newPage
      val page = writer.getImportedPage(reader, i)
      cb.addTemplate(page, factor, 0, 0, factor, left, down)
    }
    document.close()
  }
}
