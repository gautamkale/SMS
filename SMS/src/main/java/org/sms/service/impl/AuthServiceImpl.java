package org.sms.service.impl;

import org.sms.entities.Apartment;
import org.sms.entities.Profile;
import org.sms.entities.ProfileApartment;
import org.sms.entities.User;
import org.sms.model.AccountStatus;
import org.sms.model.LoginDto;
import org.sms.model.OccupancyStatus;
import org.sms.model.RegisterDto;
import org.sms.repository.ApartmentRepository;
import org.sms.repository.ProfileApartmentRepository;
import org.sms.repository.ProfileRepository;
import org.sms.repository.UserRepository;
import org.sms.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService {


    private final UserRepository  userRepository;
    private final ProfileRepository profileRepository;
    private final ApartmentRepository  apartmentRepository;
    private final ProfileApartmentRepository apartmentApartmentRepository;


    public AuthServiceImpl(UserRepository userRepository, ProfileRepository profileRepository, ApartmentRepository apartmentRepository
    ,ProfileApartmentRepository apartmentApartmentRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.apartmentRepository = apartmentRepository;
        this.apartmentApartmentRepository = apartmentApartmentRepository;

    }

    @Override
    @Transactional
    public User register(RegisterDto user) {
        User userE =createUser(user);
        Apartment apartment = apartmentRepository.save(getApartment(user, userE));
        ProfileApartment profileApartment = getProfileApartment(user, apartment);
        Profile profile = getProfile(user);
        profile.setProfileApartments(Collections.singleton(profileApartment));
        Profile profile1=profileRepository.save(profile);
        userE.setProfile(profile1);
        return userRepository.save(userE);
    }

    private static ProfileApartment getProfileApartment(RegisterDto user, Apartment apartment) {
        ProfileApartment profileApartment = new ProfileApartment();
        profileApartment.setApartment(apartment);
        profileApartment.setStartDate(user.startDate());
        profileApartment.setResidencyType(user.residencyType());
        return profileApartment;
    }

    private static Profile getProfile(RegisterDto user) {
        Profile profile = new Profile();
        profile.setFirstName(user.firstName());
        profile.setLastName(user.lastName());
        profile.setContactNo(user.contactNo());
        profile.setDob(user.dob());
        profile.setOccupation(user.occupation());
        return profile;
    }

    private static Apartment getApartment(RegisterDto user, User userE) {
        Apartment apartment = new Apartment();
        apartment.setApartmentNo(user.address().flatNo());
        apartment.setFloor(user.address().floor());
        apartment.setBlockNo(user.address().blockName());
        if (user.isOwner())
            apartment.setOwner(userE);
        apartment.setBuildingName(user.address().societyName());
        apartment.setOccupancyStatus(String.valueOf(OccupancyStatus.OCCUPIED));
        return apartment;
    }

    private User createUser(RegisterDto userDto) {
        User user = new User();
        user.setEmailId(userDto.emailId());
        user.setUserName(userDto.userId());
        user.setPassword(userDto.password());
        user.setAccountStatus(String.valueOf(AccountStatus.PENDING));
        return user;
    }

    @Override
    public User login(LoginDto loginDetials) {
        return null;
    }

    @Override
    public boolean checkUserExists(RegisterDto registerDto) {
        return  profileRepository.findByContactNo(registerDto.contactNo())!=null;

    }
}
