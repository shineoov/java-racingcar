package racingcar.domain;

@FunctionalInterface
public interface MoveStrategy {
    boolean isMoveAble();
}