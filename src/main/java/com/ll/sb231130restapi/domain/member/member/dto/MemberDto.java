package com.ll.sb231130restapi.domain.member.member.dto;

import com.ll.sb231130restapi.domain.member.member.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {
    private final Long id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final String username;
    private final String nickname;
    private final String apiKey;

    public MemberDto(Member member) {
        id = member.getId();
        createDate = member.getCreateDate();
        modifyDate = member.getModifyDate();
        username = member.getUsername();
        nickname = member.getNickname();
        apiKey = member.getApiKey();
    }
}
