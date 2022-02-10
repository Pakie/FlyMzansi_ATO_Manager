package com.pakie.flymzansi_ato_manager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PrivilegeRepo privilegeRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege deletePrivilege = createPrivilegeIfNotFound("DELETE_PRIVILEGE");
        final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");
        final Privilege briefingBookingPrivilege = createPrivilegeIfNotFound("BRIEFING_BOOKING_PRIVILEGE");
        final Privilege flightBookingPrivilege = createPrivilegeIfNotFound("FLIGHT_BOOKING_PRIVILEGE");
        final Privilege trainingFlightBookingPrivilege = createPrivilegeIfNotFound("TRAINING_FLIGHT_BOOKING_PRIVILEGE");
        final Privilege simSessionBookingPrivilege = createPrivilegeIfNotFound("SIM_SESSION_BOOKING_PRIVILEGE");
        final Privilege createExamPrivilege = createPrivilegeIfNotFound("CREATE_EXAM_PRIVILEGE");
        final Privilege examBookingPrivilege = createPrivilegeIfNotFound("EXAM_BOOKING_PRIVILEGE");
        final Privilege maintenanceBookingPrivilege = createPrivilegeIfNotFound("MAINTENANCE_BOOKING_PRIVILEGE");
        final Privilege bookingApprovalPrivilege = createPrivilegeIfNotFound("BOOKING_APPROVAL_PRIVILEGE");
        final Privilege enrollStudentPrivilege = createPrivilegeIfNotFound("ENROLL_STUDENT_PRIVILEGE");
        final Privilege createFlightPrivilege = createPrivilegeIfNotFound("CREATE_FLIGHT_PRIVILEGE");
        final Privilege createEventPrivilege = createPrivilegeIfNotFound("CREATE_EVENT_PRIVILEGE");



        // == create initial roles
        final List<Privilege> adminPrivileges = new ArrayList<>(Arrays.asList(
                readPrivilege,
                writePrivilege,
                deletePrivilege,
                passwordPrivilege
                ));

        final List<Privilege> instructorPrivileges = new ArrayList<>(Arrays.asList(
                readPrivilege,
                passwordPrivilege,
                briefingBookingPrivilege,
                flightBookingPrivilege,
                trainingFlightBookingPrivilege,
                simSessionBookingPrivilege,
                examBookingPrivilege,
                bookingApprovalPrivilege,
                enrollStudentPrivilege,
                createFlightPrivilege,
                createEventPrivilege,
                createExamPrivilege
        ));

        final List<Privilege> pilotPrivileges = new ArrayList<>(Arrays.asList(
                readPrivilege,
                passwordPrivilege,
                flightBookingPrivilege
        ));

        final List<Privilege> studentPrivileges = new ArrayList<>(Arrays.asList(
                readPrivilege,
                passwordPrivilege,
                trainingFlightBookingPrivilege,
                simSessionBookingPrivilege,
                examBookingPrivilege,
                flightBookingPrivilege,
                briefingBookingPrivilege
        ));

        final List<Privilege> mechanicPrivileges = new ArrayList<>(Arrays.asList(
                readPrivilege,
                passwordPrivilege,
                maintenanceBookingPrivilege
        ));

        final List<Privilege> invigilatorPrivileges = new ArrayList<>(Arrays.asList(
                readPrivilege,
                passwordPrivilege,
                examBookingPrivilege,
                createExamPrivilege
        ));

        final List<Privilege> sponsorPrivileges = new ArrayList<>(Arrays.asList(readPrivilege, passwordPrivilege));
        final List<Privilege> userPrivileges = new ArrayList<>(Arrays.asList(readPrivilege, passwordPrivilege));

        final Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        final Role instructorRole = createRoleIfNotFound("ROLE_INSTRUCTOR", instructorPrivileges);
        final Role pilotRole = createRoleIfNotFound("ROLE_PILOT", pilotPrivileges);
        final Role studentRole = createRoleIfNotFound("ROLE_STUDENT", studentPrivileges);
        final Role mechanicRole = createRoleIfNotFound("ROLE_MECHANIC", mechanicPrivileges);
        final Role invigilatorRole = createRoleIfNotFound("ROLE_INVIGILATOR", invigilatorPrivileges);
        final Role sponsorRole = createRoleIfNotFound("ROLE_SPONSOR", sponsorPrivileges);
        createRoleIfNotFound("ROLE_USER", userPrivileges);

        // == create initial user
        createUserIfNotFound("test@test.com", "Test", "Test", "test", new ArrayList<>(Arrays.asList(adminRole)));

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeRepo.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilege = privilegeRepo.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Role role = roleRepo.findByName(name);
        if (role == null) {
            role = new Role(name);
        }
        role.setPrivileges(privileges);
        role = roleRepo.save(role);
        return role;
    }

    @Transactional
    User createUserIfNotFound(final String email, final String firstName, final String lastName, final String password, final Collection<Role> roles) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.setEnabled(true);
        }
        user.setRoles(roles);
        user = userRepository.save(user);
        return user;
    }

}