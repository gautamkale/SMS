package org.sms.repository;

import org.sms.entities.Profile;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends GenericRepository<Profile, Long> {
    Profile findByContactNo(long l);
}