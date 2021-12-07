package com.pakie.flymzansi_ato_manager.flight_ops.aircraft;

import com.pakie.flymzansi_ato_manager.flight_ops.aircraft_type.AircraftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class AircraftController {
    @Autowired
    AircraftService aircraftService;

    @Value("${aircraft-image.folder}")
    private String imageFolder;

    @Autowired
    AircraftTypeService aircraftTypeService;

    //List Aircrafts
    @GetMapping("/aircrafts")
    //public String aircrafts(){
    public String getAllAircrafts(Model model) {
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());
        return "aircraft/aircrafts";
    }

    @GetMapping("/aircrafts/add-aircraft")
    public String addAircraft(Model model){
        Aircraft aircraft = new Aircraft();
        model.addAttribute("aircraft", aircraft);
        model.addAttribute("aircraftTypes", aircraftTypeService.getAllAircraftTypes());
        return "aircraft/add_aircraft";
    }

    @PostMapping("/saveAircraft")
    public String saveAircraft(@ModelAttribute("aircraft") Aircraft aircraft,
                               @RequestParam("fileImage") MultipartFile imageFile, RedirectAttributes redirectAttributes) throws IOException {

        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        aircraft.setImage(fileName);
        Aircraft savedAircraft = aircraftService.saveAircraft(aircraft);

        //The directory will be updated accordingly for production.
        String uploadDir = imageFolder + savedAircraft.getRegistration();
        Path uploadPath = Paths.get(uploadDir);


        if(imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please choose file to upload.");
            return "aircraft/add_aircraft";
        }

        File file = aircraftService.upload(imageFile, aircraft);
        if(file == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Upload failed.");
            return "aircraft/add_aircraft";
        }

        boolean resizeResult =  aircraftService.resizeImage(file, aircraft);
            if(!resizeResult) {
            redirectAttributes.addFlashAttribute("errorMessage", "Resize failed.");
                return "aircraft/add_aircraft";
        }

        return "redirect:/aircrafts";
    }

    @GetMapping("/aircrafts/update-aircraft/{id}")
    public String updateAircraft(@PathVariable(value = "id") Long id, Model model){
        Aircraft aircraft = aircraftService.getAircraftById(id);
        model.addAttribute("aircraft", aircraft);
        model.addAttribute("aircraftTypes", aircraftTypeService.getAllAircraftTypes());

        return "aircraft/update_aircraft";
    }
    @GetMapping("/aircrafts/delete-aircraft/{id}")
    public String deleteAircraft(@PathVariable(value = "id") Long id, Model model){
        this.aircraftService.deleteAircraftById(id);
        return "redirect:/aircrafts";
    }
}

/* throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        aircraft.setImage(fileName);
        Aircraft savedAircraft = aircraftService.saveAircraft(aircraft);

        //The directory will be updated accordingly for production.
        String uploadDir = "./src/main/resources/static/global_assets/images/uploads/aircraft/" + savedAircraft.getRegistration();

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try {
                InputStream inputStream = multipartFile.getInputStream();
                Path filePath = uploadPath.resolve(fileName);
                System.out.println(filePath.toString());

                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Oops! Failed to upload file " + fileName);
        }  */
