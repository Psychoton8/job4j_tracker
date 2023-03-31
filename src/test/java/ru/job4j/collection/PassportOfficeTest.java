package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestDoesNotAddMethod() {
        Citizen citizen = new Citizen("6789 123456", "Kot Kotov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen citizenFalse = new Citizen("6780 123456", "Kot Kotov");
        assertThat(office.add(citizen)).isFalse();
    }
}