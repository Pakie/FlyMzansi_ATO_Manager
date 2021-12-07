package com.pakie.flymzansi_ato_manager.flight_ops.aircraft.image;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    @Value("${aircraft-image.folder}")
    private String imageFolder;

    private Logger logger = LoggerFactory.getLogger(ImageUploadServiceImpl.class);

    @Override
    public File upload(MultipartFile imageFile) throws IOException {
        try {

            Path path = Paths.get(imageFolder, imageFile.getOriginalFilename());
            Files.write(path, imageFile.getBytes());
            return path.toFile();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

}
*/
