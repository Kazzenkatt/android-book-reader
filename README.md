# Book Reader 3

Book Reader 3 (v3.0.0) - Simple UI with 16 KB page size support. Based on many open-source projects:

  * FBReader (https://gitlab.com/axet/android-fbreader-library) - Upgraded to SDK 35 with 16 KB support
  * Pdfium (https://github.com/oothp/pdfium-android) - 16 KB compatible fork
  * Djvulibre (https://gitlab.com/axet/android-djvulibre) - Rebuilt with 16 KB support
  * K2PdfOpt (https://gitlab.com/axet/android-k2pdfopt) - PDF reflow, rebuilt with 16 KB support

Supported formats: fb2, html, txt, epub, mobi, rtf, doc, pdf, djvu, cbr, cbz.

## 16 KB Page Size Support

This app is compliant with Google Play's 16 KB page size requirement (November 2025 deadline).

**All formats have full 16 KB support:**
- ✅ EPUB, FB2, MOBI, TXT, HTML (FBReader)
- ✅ PDF (io.github.oothp:pdfium-android)
- ✅ PDF Reflow (K2pdfopt, rebuilt from source)
- ✅ DjVu (rebuilt from source)

## Changes in v3.0.0

- Full 16 KB page size support for all native libraries
- Migrated to AndroidX (no Jetifier)
- Gradle 9.0, AGP 8.5.2, compileSdk/targetSdk 35, Java 21
- PDF library replaced with 16 KB compatible fork (io.github.oothp:pdfium-android)
- K2PdfOpt and DjVu rebuilt from source with 16 KB alignment

All the best in this world is free!

# Manual install

    gradlew.bat assembleDebug
    gradlew.bat installDebug

# Translate

If you want to translate 'Book Reader' to your language  please read following:

  * [HOWTO-Translate.md](/docs/HOWTO-Translate.md)

# Screenshots

![shot](/docs/shot.png)
