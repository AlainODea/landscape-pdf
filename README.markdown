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

* org.scala-lang/scala-library v2.9.0: Scala License http://www.scala-lang.org/node/146
* com.lowagie/itext v2.1.7: Dual-licensed MPL http://www.mozilla.org/MPL/MPL-1.1.txt and LGPL http://www.gnu.org/licenses/old-licenses/lgpl-2.0.html
  * bouncycastle/bcmail-jdk14 v138: Bouncy Castle License: http://www.bouncycastle.org/licence.html
  * bouncycastle/bcprov-jdk14 v138: Bouncy Castle License: http://www.bouncycastle.org/licence.html
  * bouncycastle/bctsp-jdk14 v138: Bouncy Castle License: http://www.bouncycastle.org/licence.html
* org.clapper/argot_2.9.0 v0.3.1: BSD License http://software.clapper.org/argot/license.html
  * org.clapper/grizzled-scala_2.9.0 v1.0.6: BSD License http://software.clapper.org/grizzled-scala/license.html
    * jline/jline v0.9.94: BSD License http://www.opensource.org/licenses/bsd-license
    * org.scala-lang/scala-library v2.9.0: Scala License http://www.scala-lang.org/node/146
  * org.scala-lang/scala-library v2.9.0: Scala License http://www.scala-lang.org/node/146
