package ladder.application.exception;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-02
 */
public class RewardNotMatchException extends RuntimeException {
    public RewardNotMatchException() {
        super("해당하는 아이템이 없습니다.");
    }
}
