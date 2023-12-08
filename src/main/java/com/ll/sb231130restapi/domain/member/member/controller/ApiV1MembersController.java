package com.ll.sb231130restapi.domain.member.member.controller;

import com.ll.sb231130restapi.domain.member.member.dto.MemberDto;
import com.ll.sb231130restapi.domain.member.member.entity.Member;
import com.ll.sb231130restapi.domain.member.member.service.MemberService;
import com.ll.sb231130restapi.global.rq.Rq;
import com.ll.sb231130restapi.global.rsData.RsData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class ApiV1MembersController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final Rq rq;

    @Getter
    @Setter
    public static class LoginRequestBody {
        private String username;
        private String password;
    }

    @Getter
    public static class LoginResponseBody {
        private final MemberDto item;

        public LoginResponseBody(Member member) {
            item = new MemberDto(member);
        }
    }

    @PostMapping("/login")
    public RsData<LoginResponseBody> login (@RequestBody LoginRequestBody requestBody) {
        RsData<Member> checkRs = memberService.checkUsernameAndPassword(
                requestBody.getUsername(),
                requestBody.getPassword()
        );

        Member member = checkRs.getData();

        return checkRs.of(new LoginResponseBody(member));
    }

    // 전 기기 로그아웃
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/apiKey")
    public RsData<?> regenApiKey () {
        Member member = rq.getMember();

        memberService.regenApiKey(member);

        return RsData.of(
                "200",
                "해당 키가 재생성 되었습니다."
        );
    }
}