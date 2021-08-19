import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Configuration.fileDownload;
import static com.codeborne.selenide.FileDownloadMode.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.FileFilters.withExtension;



public class DownloadingTest {
    @Test
    void DowloadTest() throws InterruptedException, FileNotFoundException {
        Configuration.timeout=20000;
//        Configuration.browser = "firefox";
        Configuration.downloadsFolder = "C:\\TestDownload";
        fileDownload = FOLDER;
        open("https://www.google.com/intl/ru_ru/chrome/");

        File downloadFile = $("*[id='js-download-hero']").shouldBe(Condition.visible)
                        .download(withExtension("exe"));
        TimeUnit.SECONDS.sleep(5);
        String downloadedFileName = downloadFile.getPath().substring(downloadFile
                .getPath().lastIndexOf("\\")+1);
        Assertions.assertEquals("ChromeSetup.exe", downloadedFileName);
    }
}


