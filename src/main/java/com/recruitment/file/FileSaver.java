package com.recruitment.file;

import com.recruitment.handler.CustomExceptionHandler;
import com.recruitment.logger.MainLogger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
    private static final MainLogger LOGGER = MainLogger.getLogger(CustomExceptionHandler.class);

    @Value("${value.filePath}")
    private String rootPath;

    public String saveAndGetPath(MultipartFile file, String filePath) {
        try {
            String fileFormat = Objects.requireNonNull(file.getOriginalFilename()).
                    substring(file.getOriginalFilename().lastIndexOf('.'));

            String fileName = getFileName();
            StringBuilder filePathBuilder = new StringBuilder()
                    .append(rootPath + filePath)
                    .append(fileName)
                    .append(fileFormat);
            LOGGER.info("filePath: " + filePathBuilder);

            Path path = Paths.get(filePathBuilder.toString());
            byte[] bytes = file.getBytes();
            Files.write(path, bytes);
//            return filePathBuilder.toString();
            return fileName + fileFormat;
        } catch (IOException ex) {
            LOGGER.error("IOException: {} ", ex.getLocalizedMessage());
        } catch (Exception ex) {
            LOGGER.error("Exception: {} ", ex.getLocalizedMessage());
        }
        return null;
    }

    private String getFileName() {
        return String.format("%s_%s",
                System.currentTimeMillis(),
                getRandomName());
    }

    public void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

    private String getRandomName() {
        return UUID.randomUUID().toString().substring(0, 7).replace("-", "");
    }
}
