package fr.lacombe.account;

import org.junit.Test;

import java.time.LocalDateTime;

import static fr.lacombe.account.OperationType.DEPOSIT;
import static org.assertj.core.api.Assertions.assertThat;

public class OperationStatementTest {

    @Test
    public void should_calculate_next_operation() {
        final LocalDateTime timestamp = LocalDateTime.now();
        final OperationStatement statement = OperationStatement.of(DEPOSIT, timestamp, Amount.of(3L), Balance.of(3L));
        final Operation operation = Operation.of(DEPOSIT, timestamp, Amount.of(5L));

        final OperationStatement result = statement.calculateNext(operation);

        assertThat(result).isEqualTo(OperationStatement.of(DEPOSIT, timestamp, Amount.of(5L), Balance.of(8L)));
    }
}