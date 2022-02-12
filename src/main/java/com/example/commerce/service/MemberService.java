package com.example.commerce.service;

import com.example.commerce.domain.Member;
import com.example.commerce.domain.UserAppId;
import com.example.commerce.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//dependency injection

//@Service
@Transactional
public class MemberService {

    //private final MemberRepository memberRepository = new TMemberRepository();


    private final MemberRepository memberRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    public Long join(Member member){


        //business logic
//        validateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

//    private void validateMember(Member member){
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {throw new IllegalStateException("Name is already exists");});
//    }


    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
    public Member findByName(String name){
        return memberRepository.findByName(name);
    }
    public Member findByUser(String name,String password){
        return memberRepository.findByUser(name,password);
    }
    public List<UserAppId> findAppId(Long id) {
        return memberRepository.findAppId(id);
    }
    public String findUserPrivilege(Long id) {
        return memberRepository.findUserPrivilege(id);
    }

}
