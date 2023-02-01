package com.legato.MemberRegistrationPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.legato.MemberRegistrationPortal.model.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	public Optional<Member> findAllByEmail(String userName);

}
