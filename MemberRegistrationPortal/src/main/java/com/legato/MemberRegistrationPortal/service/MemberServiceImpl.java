package com.legato.MemberRegistrationPortal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.legato.MemberRegistrationPortal.model.Member;
import com.legato.MemberRegistrationPortal.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private  MemberRepository memberRepository;

	@Override
	public Optional<Member> findById(Integer id) {

		return memberRepository.findById(id);
	}

	@Override
	public Member save(Member member) {

		return memberRepository.save(member);
	}

	@Override
	public Member update(Member member) {
		if (member.getName() == null)
			throw new NullPointerException("Memeber not found, ID is required for update the data");

		return memberRepository.saveAndFlush(member);
	}
	
//	public long getClaimToken(Integer id) {
//		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
//		
//		return number;
//	}
	public boolean registerNewUser(Member member) {
		System.out.println(member.getId());
		boolean registryMember = memberRepository.existsById(member.getId());
		//System.out.println(registryMember.get().getId());
		if (!registryMember) {
			memberRepository.save(member);
			System.out.println("User Saved Successfully");
			return true;
		} else {
			System.out.println("no user");
			return false;
		}
	}
	
}
