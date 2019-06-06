package kz.greetgo.diploma.register.beans.all;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.file_storage.FileStorage;
import kz.greetgo.file_storage.errors.UnknownMimeType;
import kz.greetgo.file_storage.impl.FileStorageBuilder;
import kz.greetgo.file_storage.impl.FileStorageBuilderConfigurator;
import kz.greetgo.file_storage.impl.LocalUtil;

@Bean
public class FStorage {

  public BeanGetter<DbSessionFactory> dbSessionFactory;

  @Bean
  public FileStorage fileStorage() {
    
    return FileStorageBuilder
      .newBuilder()
      .configureFrom(Mtype.get())
      .mandatoryMimeType(true)
      .mandatoryName(true)
      .inDb(dbSessionFactory.get().getDataSource())
      .build();

  }


  static class Mtype implements FileStorageBuilderConfigurator {


    private static final Set<String> MIME_TYPE_OK = new HashSet<>();
    private static final Map<String, String> EXTENSION_MIME_TYPE = new HashMap<>();

    static {
      addMimeType(".txt   ~ Text file                       ~ text/plain                                   ");

      addMimeType(".aac   ~ AAC audio file                  ~ audio/aac                                    ");
      addMimeType(".abw   ~ AbiWord document                ~ application/x-abiword                        ");
      addMimeType(".avi   ~ AVI: Audio Video Interleave     ~ video/x-msvideo                              ");
      addMimeType(".azw   ~ Amazon Kindle eBook format      ~ application/vnd.amazon.ebook                 ");
      addMimeType(".bin   ~ Any kind of binary data         ~ application/octet-stream                     ");
      addMimeType(".bz    ~ BZip archive                    ~ application/x-bzip                           ");
      addMimeType(".bz2   ~ BZip2 archive                   ~ application/x-bzip2                          ");
      addMimeType(".csh   ~ C-Shell script                  ~ application/x-csh                            ");
      addMimeType(".css   ~ Cascading Style Sheets (CSS)    ~ text/css                                     ");
      addMimeType(".csv   ~ Comma-separated values (CSV)    ~ text/csv                                     ");
      addMimeType(".doc   ~ Microsoft Word                  ~ application/msword                           ");
      addMimeType(".eot   ~ MS Embedded OpenType fonts      ~ application/vnd.ms-fontobject                ");
      addMimeType(".epub  ~ Electronic publication (EPUB)   ~ application/epub+zip                         ");
      addMimeType(".ics   ~ iCalendar format                ~ text/calendar                                ");
      addMimeType(".jar   ~ Java Archive (JAR)              ~ application/java-archive                     ");
      addMimeType(".js    ~ JavaScript (ECMAScript)         ~ application/javascript                       ");
      addMimeType(".json  ~ JSON format                     ~ application/json                             ");
      addMimeType(".mpeg  ~ MPEG Video                      ~ video/mpeg                                   ");
      addMimeType(".mpkg  ~ Apple Installer Package         ~ application/vnd.apple.installer+xml          ");
      addMimeType(".oga   ~ OGG audio                       ~ audio/ogg                                    ");
      addMimeType(".ogv   ~ OGG video                       ~ video/ogg                                    ");
      addMimeType(".ogx   ~ OGG                             ~ application/ogg                              ");
      addMimeType(".otf   ~ OpenType font                   ~ font/otf                                     ");
      addMimeType(".ppt   ~ Microsoft PowerPoint            ~ application/vnd.ms-powerpoint                ");
      addMimeType(".rar   ~ RAR archive                     ~ application/x-rar-compressed                 ");
      addMimeType(".rtf   ~ Rich Text Format (RTF)          ~ application/rtf                              ");
      addMimeType(".sh    ~ Bourne shell script             ~ application/x-sh                             ");
      addMimeType(".tar   ~ Tape Archive (TAR)              ~ application/x-tar                           ");
      addMimeType(".ts    ~ Typescript file                 ~ video/vnd.dlna.mpeg-tts                      ");
      addMimeType(".ttf   ~ TrueType Font                   ~ font/ttf                                     ");
      addMimeType(".vsd   ~ Microsoft Visio                 ~ application/vnd.visio                        ");
      addMimeType(".wav   ~ Waveform Audio Format           ~ audio/x-wav                                  ");
      addMimeType(".weba  ~ WEBM audio                      ~ audio/webm                                   ");
      addMimeType(".webm  ~ WEBM video                      ~ video/webm                                   ");
      addMimeType(".webp  ~ WEBP image                      ~ image/webp                                   ");
      addMimeType(".woff  ~ Web Open Font Format (WOFF)     ~ font/woff                                    ");
      addMimeType(".woff2 ~ Web Open Font Format (WOFF)     ~ font/woff2                                   ");
      addMimeType(".xhtml ~ XHTML                           ~ application/xhtml+xml                        ");
      addMimeType(".xls   ~ Microsoft Excel                 ~ application/vnd.ms-excel                     ");
      addMimeType(".xml   ~ XML                             ~ application/xml                              ");
      addMimeType(".xul   ~ XUL                             ~ application/vnd.mozilla.xul+xml              ");
      addMimeType(".zip   ~ ZIP archive                     ~ application/zip                              ");
      addMimeType(".7z    ~ 7-zip archive                   ~ application/x-7z-compressed                  ");

      addMimeType(".pdf   ~ Adobe Portable Document Format (PDF)  ~ application/pdf                        ");

      addMimeType(".png       ~ Portable Network Graphics             ~ image/png                          ");
      addMimeType(".ico       ~ Icon format                           ~ image/x-icon                       ");
      addMimeType(".svg       ~ Scalable Vector Graphics (SVG)        ~ image/svg+xml                      ");
      addMimeType(".gif       ~ Graphics Interchange Format (GIF)     ~ image/gif                          ");
      addMimeType(".tif .tiff ~ Tagged Image File Format (TIFF)       ~ image/tiff                         ");
      addMimeType(".jpeg .jpg ~ JPEG images                           ~ image/jpeg                         ");

      addMimeType(".htm .html~HyperText Markup Language (HTML)~text/html");
      addMimeType(".mid .midi~Musical Instrument Digital Interface (MIDI)~audio/midi");

      addMimeType(".3gp ~ 3GPP audio/video container  ~ video/3gpp                                   ");
      addMimeType(".3gp ~ 3GPP audio/video container  ~ audio/3gpp    ~if it doesn't contain video   ");
      addMimeType(".3g2 ~ 3GPP2 audio/video container ~ video/3gpp2                                  ");
      addMimeType(".3g2 ~ 3GPP2 audio/video container ~ audio/3gpp2   ~if it doesn't contain video   ");
      addMimeType(".odp ~ OpenDocument presentation document~application/vnd.oasis.opendocument.presentation  ");
      addMimeType(".ods ~ OpenDocument spreadsheet document~application/vnd.oasis.opendocument.spreadsheet    ");
      addMimeType(".odt ~ OpenDocument text document~application/vnd.oasis.opendocument.text                  ");
      addMimeType(".arc ~ Archive document (multiple files embedded)~application/octet-stream                 ");
      addMimeType(".swf ~ Small web format (SWF) or Adobe Flash document~application/x-shockwave-flash        ");
      addMimeType(".doc   ~ asdf   ~  application/msword");
      addMimeType(".dot   ~ asdf   ~  application/msword");
      addMimeType(".docx  ~ asdf   ~  application/vnd.openxmlformats-officedocument.wordprocessingml.document");
      addMimeType(".dotx  ~ asdf   ~  application/vnd.openxmlformats-officedocument.wordprocessingml.template");
      addMimeType(".docm  ~ asdf   ~  application/vnd.ms-word.document.macroEnabled.12");
      addMimeType(".dotm  ~ asdf   ~  application/vnd.ms-word.template.macroEnabled.12");
      addMimeType(".xls   ~ asdf   ~  application/vnd.ms-excel");
      addMimeType(".xlt   ~ asdf   ~  application/vnd.ms-excel");
      addMimeType(".xla   ~ asdf   ~  application/vnd.ms-excel");
      addMimeType(".xlsx  ~ asdf   ~  application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
      addMimeType(".xltx  ~ asdf   ~  application/vnd.openxmlformats-officedocument.spreadsheetml.template");
      addMimeType(".xlsm  ~ asdf   ~  application/vnd.ms-excel.sheet.macroEnabled.12");
      addMimeType(".xltm  ~ asdf   ~  application/vnd.ms-excel.template.macroEnabled.12");
      addMimeType(".xlam  ~ asdf   ~  application/vnd.ms-excel.addin.macroEnabled.12");
      addMimeType(".xlsb  ~ asdf   ~  application/vnd.ms-excel.sheet.binary.macroEnabled.12");
      addMimeType(".ppt   ~ asdf   ~  application/vnd.ms-powerpoint");
      addMimeType(".pot   ~ asdf   ~  application/vnd.ms-powerpoint");
      addMimeType(".pps   ~ asdf   ~  application/vnd.ms-powerpoint");
      addMimeType(".ppa   ~ asdf   ~  application/vnd.ms-powerpoint");
      addMimeType(".pptx  ~ asdf   ~  application/vnd.openxmlformats-officedocument.presentationml.presentation");
      addMimeType(".potx  ~ asdf   ~  application/vnd.openxmlformats-officedocument.presentationml.template");
      addMimeType(".ppsx  ~ asdf   ~  application/vnd.openxmlformats-officedocument.presentationml.slideshow");
      addMimeType(".ppam  ~ asdf   ~  application/vnd.ms-powerpoint.addin.macroEnabled.12");
      addMimeType(".pptm  ~ asdf   ~  application/vnd.ms-powerpoint.presentation.macroEnabled.12");
      addMimeType(".potm  ~ asdf   ~  application/vnd.ms-powerpoint.template.macroEnabled.12");
      addMimeType(".ppsm  ~ asdf   ~  application/vnd.ms-powerpoint.slideshow.macroEnabled.12");
      addMimeType(".mdb   ~ asdf   ~  application/vnd.ms-access");
      addMimeType(".docx   ~ asdf   ~  application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    }

    private static void addMimeType(String line) {
      String mimeType = line.split("~")[2].trim();
      String[] extensions = line.split("~")[0].trim().split("\\s+");

      MIME_TYPE_OK.add(mimeType);

      for (String extension : extensions) {
        if (extension.startsWith(".")) extension = extension.substring(1);
        EXTENSION_MIME_TYPE.put(extension, mimeType);
      }
    }


    enum Ins {
      VALUE;

      final Mtype instance = new Mtype();
    }

    public static Mtype get() {
      return Mtype.Ins.VALUE.instance;
    }

    private Mtype() {
    }

    @Override
    public void configure(FileStorageBuilder fileStorageBuilder) {
      fileStorageBuilder.mimeTypeExtractor(this::extractMimeType);
      fileStorageBuilder.mimeTypeValidator(this::validator);
    }

    private Boolean validator(String mimeType) {
      if (mimeType == null) return true;
      if (!MIME_TYPE_OK.contains(mimeType)) {
        throw new UnknownMimeType(
          mimeType,
          "No MIME type '" + mimeType + "' in " + MIME_TYPE_OK.stream().sorted().collect(Collectors.toList())
        );
      }
      return true;
    }

    private String extractMimeType(String fileName) {
      String extension = LocalUtil.extractExtension(fileName);
      return EXTENSION_MIME_TYPE.get(extension);
    }
  }


}

