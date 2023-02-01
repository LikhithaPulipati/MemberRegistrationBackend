package com.legato.MemberRegistrationPortal.service;

import java.util.Optional;

import com.legato.MemberRegistrationPortal.model.Member;


public interface MemberService {

	Optional<Member> findById(Integer id);

	Member save(Member member);

	Member update(Member member);

	boolean registerNewUser(Member member);

}
