package com.example.commerce.repository;

import com.example.commerce.domain.Member;
import com.example.commerce.domain.UserAppId;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Member findByName(String name);
    Member findByUser(String name,String password);
    List<Member> findAll();
    public void clearstore();
    List<UserAppId> findAppId(Long id);
    String findUserPrivilege(Long id);


}
