package com.legato.MemberRegistrationPortal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.legato.MemberRegistrationPortal.model.LoginPayload;
import com.legato.MemberRegistrationPortal.model.Member;
import com.legato.MemberRegistrationPortal.repository.MemberRepository;
import com.legato.MemberRegistrationPortal.service.ClaimService;
import com.legato.MemberRegistrationPortal.service.MemberService;
import com.legato.MemberRegistrationPortal.service.MemberServiceImpl;

@RestController
@CrossOrigin()
public class MemberController {
	@Autowired
	private MemberService memberServiceImpl;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	ClaimService claimService;

	@PostMapping({ "/registerNewMember" })
	public String registerNewMember(@RequestBody Member member) {
		if (memberServiceImpl.registerNewUser(member)) {

			return "User saved";
		} else {

			return "User already present";
		}

	}

	@PostMapping({ "/sign-in" })
	public ResponseEntity<Optional<Member>> loginToSystem(@RequestBody LoginPayload userData) throws Exception {
		String memId = userData.getUserId();
		Optional<Member> logedInUser = memberRepository.findAllByEmail(memId);
		if(! userData.getPassword().equals(logedInUser.get().getPassword()))
		return ResponseEntity.ok(logedInUser);
		else
			System.out.println("Invalid user");
		return ResponseEntity.ok(logedInUser);
		
	}

	@PutMapping("/updateMember/{id}")
	public ResponseEntity<Member> updateBook(@PathVariable String id, @RequestBody Member memberDetails) {
		Optional<Member> memberfromDb = memberRepository.findAllByEmail(id);
		Member member = memberfromDb.get();
		member.setName(memberDetails.getName());
		member.setAddress(memberDetails.getAddress());
		member.setState(memberDetails.getState());
		member.setCountry(memberDetails.getCountry());
		member.setEmail(memberDetails.getEmail());
		member.setPan(memberDetails.getPan());
		member.setContactNo(memberDetails.getContactNo());
		member.setDob(memberDetails.getDob());
		member.setPassword(memberDetails.getPassword());
		member.setDependentOne(memberDetails.getDependentOne());
		member.setDependentOneDob(memberDetails.getDependentOneDob());
		member.setDependentTwo(memberDetails.getDependentTwo());
		member.setDependentTwoDob(memberDetails.getDependentTwoDob());

		Member updatedMember = memberRepository.save(member);
		return ResponseEntity.ok(updatedMember);

	}

	@GetMapping("/readMember/{id}")
	public Optional<Member> getMemberById(@PathVariable String id) {
		Optional<Member> member = memberRepository.findAllByEmail(id);

		return member;
	}

	@GetMapping("/getClaim/{id}")
	public long getMemberClaim(@PathVariable String id) {
		Optional<Member> member = memberRepository.findAllByEmail(id);
		long claimToken = claimService.getClaimToken(id);
		System.out.println(claimToken);

		return claimToken;
	}

}
