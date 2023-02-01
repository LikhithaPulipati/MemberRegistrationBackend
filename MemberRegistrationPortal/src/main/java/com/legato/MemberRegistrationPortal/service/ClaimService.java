package com.legato.MemberRegistrationPortal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legato.MemberRegistrationPortal.model.Claim;
import com.legato.MemberRegistrationPortal.model.Member;
import com.legato.MemberRegistrationPortal.repository.ClaimRepository;
import com.legato.MemberRegistrationPortal.repository.MemberRepository;


@Service
public class ClaimService {
	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	
	public long getClaimToken(String email) {
		long number = 0;
		Optional<Member> member = memberRepository.findAllByEmail(email);
		Claim getMemberClaim = claimRepository.findAllByEmail(email);
		//boolean userIdFromClaim = getMemberClaim.;
		
			Claim newClaim = new Claim();
			newClaim.setUserId(member.get().getId());
			 number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			 newClaim.setClaimToken(number);
			 newClaim.setClaimDate(LocalDate.now());
			 claimRepository.save(newClaim);
		
				return number;
		
		
	}

}
