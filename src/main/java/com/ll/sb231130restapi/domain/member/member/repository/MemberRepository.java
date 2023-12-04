package com.ll.sb231130restapi.domain.member.member.repository;

import com.ll.sb231130restapi.domain.member.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}