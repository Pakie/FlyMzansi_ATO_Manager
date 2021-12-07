package com.pakie.flymzansi_ato_manager.flight_ops.aircraft;

import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftServiceImpl implements AircraftService{
    @Autowired
    private AircraftRepo aircraftRepo;

    @Value("${aircraft-image.folder}")
    private String imageFolder;

    @Value("${aircraft-image.size}")
    private Integer imageSize;

    private Logger logger = LoggerFactory.getLogger(AircraftServiceImpl.class);

    @Override
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepo.findAll();
    }

    @Override
    public Aircraft saveAircraft(Aircraft aircraft) {
        this.aircraftRepo.save(aircraft);

        return aircraft;
    }

    @Override
    public File upload(MultipartFile imageFile, Aircraft aircraft) throws IOException {
        try {
            String savedAircraft = aircraft.getRegistration();
            String uploadDir = imageFolder + savedAircraft;
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path path = Paths.get(uploadDir, imageFile.getOriginalFilename());
            Files.write(path, imageFile.getBytes());
            return path.toFile();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public boolean resizeImage(File sourceFile, Aircraft aircraft) {
        try {
            String savedAircraft = aircraft.getRegistration();
            String uploadDir = imageFolder + savedAircraft;
            BufferedImage bufferedImage = ImageIO.read(sourceFile);
            BufferedImage outputImage = Scalr.resize(bufferedImage, imageSize);
            String newFileName = FilenameUtils.getBaseName(sourceFile.getName())
                    + "_" + imageSize.toString() + "."
                    + FilenameUtils.getExtension(sourceFile.getName());
            Path path = Paths.get(uploadDir,newFileName);
            File newImageFile = path.toFile();
            /*if (!Files.exists(path)) {
                Files.createDirectories(path);
            }*/
            ImageIO.write(outputImage, "jpg", newImageFile);
            outputImage.flush();
            return true;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Aircraft getAircraftById(Long id) {
        Optional<Aircraft> optional = aircraftRepo.findById(id);
        Aircraft aircraft = null;
        if (optional.isPresent()){
            aircraft = optional.get();
        } else {
            throw new RuntimeException("The aircraft with ID " + id + " does not exist");
        }
        return aircraft;
    }

    @Override
    public void deleteAircraftById(Long id) {
        this.aircraftRepo.deleteById(id);
    }
}
