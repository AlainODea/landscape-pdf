landscape-pdf
================================
A remake of Nikolaus Gradwohl's cropborder in Scala backed on SBT.
Specifically tuned to build iPad-optimized PDFs for landscape display.

Usage:

    java -jar cropborder.jar
         [--in <input.pdf>]
         [--out <output.pdf>]
         [--factor<scaling factor>] [--left<dots to move the left border>]
         [--down<dots to move the lower border>]

Original Source: http://www.local-guru.net/blog/2009/06/16/ebook-pdf-border-remover

License
=======
The source code here is Apache 2.0 Licensed.  However, the dependencies and their transitive dependencies have their own licensing:

* iText 2.1.7: Dual-licensed MPL and LGPL
  * Bouncy Castle: Bouncy Castle License: http://www.bouncycastle.org/licence.html
* JewelCLI: Apache 2.0 License
