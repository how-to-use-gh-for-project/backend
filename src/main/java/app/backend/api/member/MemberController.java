package app.backend.api.member;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.backend.api.member.dto.MemberResponse;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private static final int MIN_LIMIT = 1;
    private static final int MAX_LIMIT = 10;

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberResponse> getMembers(@RequestParam(defaultValue = "3") int limit) {
        if (limit < MIN_LIMIT || limit > MAX_LIMIT) {
            throw new IllegalArgumentException("limit must be between 1 and 10");
        }

        return memberService.getMembers(limit);
    }
}
