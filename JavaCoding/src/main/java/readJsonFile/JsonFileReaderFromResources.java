package readJsonFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class JsonFileReaderFromResources {

    static class UserData {
        private LocalDateTime localDateTime;
        private String username;
        private LocalDate localDate;

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public void setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }
    }

    public static void main(String[] args) {
        try {
            // Load file from resources folder using class loader
            ClassLoader classLoader = JsonFileReaderFromResources.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("readJsontext.json");

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());


            UserData userData = mapper.readValue(inputStream, UserData.class);

            System.out.println("Username: " + userData.getUsername());
            System.out.println("LocalDateTime: " + userData.getLocalDateTime());
            System.out.println("userLocalDate=="+userData.getLocalDate());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
