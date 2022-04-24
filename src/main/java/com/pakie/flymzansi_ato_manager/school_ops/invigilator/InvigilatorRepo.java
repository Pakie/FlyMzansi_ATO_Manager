package com.pakie.flymzansi_ato_manager.school_ops.invigilator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvigilatorRepo extends JpaRepository<Invigilator, Long> {

}
