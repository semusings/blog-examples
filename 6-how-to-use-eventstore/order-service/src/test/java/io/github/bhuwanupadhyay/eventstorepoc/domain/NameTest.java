package io.github.bhuwanupadhyay.eventstorepoc.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class NameTest {

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void firstNameIsRequired() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage(Name.FIRST_NAME_SHOULD_NOT_BE_EMPTY);
    Name.create("   ", "prasad", "upadhyay");
  }

  @Test
  public void lastNameIsRequired() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage(Name.LAST_NAME_SHOULD_NOT_BE_EMPTY);
    Name.create("bhuwan", "prasad", "");
  }

  @Test
  public void giveValidFirstAndLastName_whenCreate_thenShouldNameCreated() {
    Name name = Name.create("bhuwan", "prasad", "upadhyay");
    assertEquals("bhuwan", name.getFirstName());
    assertEquals("prasad", name.getMiddleName());
    assertEquals("upadhyay", name.getLastName());
  }
}
