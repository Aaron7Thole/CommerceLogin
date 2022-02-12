package com.example.commerce.repository;

import com.example.commerce.domain.Member;
import com.example.commerce.domain.UserAppId;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }


    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Member findByName(String username) {
        List<Member> result = em.createQuery("select m from Member m where m.username = :username" , Member.class)
                .setParameter("username", username)
                .getResultList();

        return result.get(0);
    }

    @Override
    public Member findByUser(String username,String Password) {
        List<Member> result = em.createQuery("select m from Member m where m.username = :username and m.password = :Password" , Member.class)
                .setParameter("username", username).setParameter("Password",Password)
                .getResultList();

        return result.get(0);
    }
    @Override
    public List<Member> findAll() {
        List<Member> member = em.createQuery("select m from Member m" , Member.class)
                .getResultList();
        for(int i = 0; i < member.size();i++){
            System.out.println(member.get(i).getId());
            System.out.println(member.get(i).getName());
            System.out.println(member.get(i).getPrivilege());
        }
        return member;
    }

    @Override
    public List<UserAppId> findAppId(Long id) {
        List<UserAppId> appids = em.createQuery("select a from UserAppId a where a.userid = :id", UserAppId.class).
                setParameter("id", id)
                .getResultList();

        return appids;
    }

    @Override
    public String findUserPrivilege(Long id){
        Member member = em.find(Member.class, id);

        return member.getPrivilege();
    }

    @Override
    public void clearstore() {

    }
}
