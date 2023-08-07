package study.querydsl.repository;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.entity.Member;

import java.util.List;

@Repository
public class MemberTestRepository extends QuerydslRepositorySupport {

    public MemberTestRepository() {
        super(Member.class);
    }

}
