package com.pakie.flymzansi_ato_manager.flight_ops.pilot;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface PilotService {
    List<Pilot> getAllPilots();
    Pilot savePilot(Pilot pilot);
    File upload(MultipartFile imageFile, Pilot pilot) throws IOException;
    boolean resizeImage(File sourceFile, Pilot pilot);
    Pilot getPilotById(Long Id);
    void deletePilotById(Long Id);
}
