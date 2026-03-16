package app.backend.api.member;

import java.util.List;

import org.springframework.stereotype.Service;

import app.backend.api.member.dto.MemberResponse;

@Service
public class MemberService {

    private static final List<MemberResponse> SAMPLE_MEMBERS = List.of(
            new MemberResponse(1L, "Alice"),
            new MemberResponse(2L, "Bob"),
            new MemberResponse(3L, "Chris"),
            new MemberResponse(4L, "Dana"),
            new MemberResponse(5L, "Evan"));

    public List<MemberResponse> getMembers(int limit) {
        int safeLimit = Math.min(limit, SAMPLE_MEMBERS.size());
        return SAMPLE_MEMBERS.subList(0, safeLimit);
    }
}
