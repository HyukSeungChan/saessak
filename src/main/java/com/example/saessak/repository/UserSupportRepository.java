package com.example.saessak.repository;

import com.example.saessak.entity.UserSupport;
import com.example.saessak.entity.UserVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSupportRepository extends JpaRepository<UserSupport, Integer> {
}
