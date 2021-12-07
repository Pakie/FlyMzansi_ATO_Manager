package com.pakie.flymzansi_ato_manager.flight_ops.aircraft.image;

import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/*@Service
public class ImageServiceImpl implements ImageService {

    @Value("${aircraft-image.folder}")
    private String imageFolder;

    @Value("${aircraft-image.size}")
    private Integer imageSize;

    private Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Override
    public boolean resizeImage(File sourceFile) {
        try {
            BufferedImage bufferedImage = ImageIO.read(sourceFile);
            BufferedImage outputImage = Scalr.resize(bufferedImage, imageSize);
            String newFileName = FilenameUtils.getBaseName(sourceFile.getName())
                    + "_" + imageSize.toString() + "."
                    + FilenameUtils.getExtension(sourceFile.getName());
            Path path = Paths.get(imageFolder,newFileName);
            File newImageFile = path.toFile();
            ImageIO.write(outputImage, "jpg", newImageFile);
            outputImage.flush();
            return true;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }
}*/
