package fr.lacombe.account;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_when_creating_a_negative_amount() {
        Amount.of(-1);
    }

    @Test
    public void should_add_two_amounts() {
        final Amount firstAmount = Amount.of(4L);
        final Amount secondAmount = Amount.of(2L);

        final Amount result = firstAmount.add(secondAmount);

        assertThat(result).isEqualTo(Amount.of(6L));
    }

    @Test
    public void should_subtract_0_from_0() {
        final Amount firstAmount = Amount.of(0L);
        final Amount secondAmount = Amount.of(0L);

        final Amount result = firstAmount.subtract(secondAmount);

        assertThat(result).isEqualTo(Amount.of(0L));
    }

    @Test
    public void should_subtract_0_from_1() {
        final Amount firstAmount = Amount.of(1L);
        final Amount secondAmount = Amount.of(0L);

        final Amount result = firstAmount.subtract(secondAmount);

        assertThat(result).isEqualTo(Amount.of(1L));
    }

    @Test
    public void should_subtract_0_from_2() {
        final Amount firstAmount = Amount.of(2L);
        final Amount secondAmount = Amount.of(0L);

        final Amount result = firstAmount.subtract(secondAmount);

        assertThat(result).isEqualTo(Amount.of(2L));
    }

    @Test
    public void should_subtract_1_from_3() {
        final Amount firstAmount = Amount.of(3L);
        final Amount secondAmount = Amount.of(1L);

        final Amount result = firstAmount.subtract(secondAmount);

        assertThat(result).isEqualTo(Amount.of(2L));
    }
}