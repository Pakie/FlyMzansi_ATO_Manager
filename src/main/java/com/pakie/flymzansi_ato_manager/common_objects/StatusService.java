package com.pakie.flymzansi_ato_manager.common_objects;

import java.util.List;

public interface StatusService {
    List<Status> getAllStatuses();
    void SaveStatus(Status status);
    Status getStatusById(Long id);
    void deleteStatusById(Long id);
}
