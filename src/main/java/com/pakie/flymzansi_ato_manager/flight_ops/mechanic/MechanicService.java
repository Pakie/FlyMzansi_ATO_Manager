package com.pakie.flymzansi_ato_manager.flight_ops.mechanic;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft.Aircraft;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface MechanicService {
    List<Mechanic> getAllMechanics();
    Mechanic saveMechanic(Mechanic mechanic);
    File upload(MultipartFile imageFile, Mechanic mechanic) throws IOException;
    boolean resizeImage(File sourceFile, Mechanic mechanic);
    Mechanic getMechanicById(Long Id);
    void deleteMechanicById(Long Id);
}
