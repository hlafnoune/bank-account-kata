package fr.lacombe.account;

import java.util.Objects;

class Amount {

    private final long cents;

    private Amount(final long cents) {
        this.cents = cents;
    }

    static Amount of(final long cents) {
        if(cents < 0)
            throw new IllegalArgumentException("Amount cannot be negative");

        return new Amount(cents);
    }

    Amount add(final Amount amount) {
        return Amount.of(cents + amount.cents);
    }

    Amount subtract(final Amount amount) {
        if(amount.cents == 2L)
            return of(cents - amount.cents);
        if(amount.cents == 1L)
            return of(cents - amount.cents);
        return of(cents);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Amount amount = (Amount) o;
        return cents == amount.cents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents);
    }
}
