package app.backend.api.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
class MemberControllerTest {

    private final MemberService memberService = new MemberService();
    private final MemberController memberController = new MemberController(memberService);

    @Test
    void getMembersReturnsLimitedList() {
        var result = memberController.getMembers(2);

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).name());
    }

    @Test
    void getMembersThrowsForInvalidLimit() {
        var exception = assertThrows(IllegalArgumentException.class, () -> memberController.getMembers(0));

        assertEquals("limit must be between 1 and 10", exception.getMessage());
    }
}
