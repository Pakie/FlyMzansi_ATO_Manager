package com.pakie.flymzansi_ato_manager.flight_ops.aircraft;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AircraftService {
    List<Aircraft> getAllAircrafts();
    Aircraft saveAircraft(Aircraft aircraft);
    File upload(MultipartFile imageFile, Aircraft aircraft) throws IOException;
    boolean resizeImage(File sourceFile, Aircraft aircraft);
    Aircraft getAircraftById(Long Id);
    void deleteAircraftById(Long Id);
}
