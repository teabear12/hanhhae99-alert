package hanghae99.alert.global.log;

import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LogSchedular {
    /* 매일자정  */
    @Scheduled(cron = "0 0 0 * * *")
    public void readLogFile () throws IOException {
        /* 오늘날짜 */
        Date d = new Date();
        /*어제날짜 */
        d = new Date(d.getTime()+(1000*60*60*24*-1));
        SimpleDateFormat yesterday = new SimpleDateFormat("yyyy-MM-dd");

        /* 어제 날짜의 로그파일 읽어들임 */
        String filePath = "/log"+ yesterday.format(d)+".0.log";
        List<String> lines = Files.readAllLines(Paths.get(filePath),
                StandardCharsets.UTF_8);
    }
}
