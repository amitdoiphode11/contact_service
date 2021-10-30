package com.eaglesoft.contact_service.repository;

import com.eaglesoft.contact_service.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    List<Contact> findAllByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("delete from Contact where userId= :userId")
    void deleteAllByUserId(@Param("userId") Long userId);
}
