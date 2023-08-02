package study.querydsl.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Autowired
    MemberQuerydslRepository memberQuerydslRepository;

    @Test
    void saveTest() {
        Member member = new Member("memberA", 10);
        memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.findById(member.getId()).get();
        assertThat(findMember).isEqualTo(member);

        List<Member> memberList = memberJpaRepository.findAll();
        assertThat(memberList).containsExactly(member);

        List<Member> memberA = memberJpaRepository.findByUsername("memberA");
        assertThat(memberA).containsExactly(member);
    }

    @Test
    void saveTestV2() {
        Member member = new Member("memberA", 10);
        memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.findById(member.getId()).get();
        assertThat(findMember).isEqualTo(member);

        List<Member> memberList = memberQuerydslRepository.findAll();
        assertThat(memberList).containsExactly(member);

        List<Member> memberA = memberQuerydslRepository.findByUsername("memberA");
        assertThat(memberA).containsExactly(member);
    }
}