package io.github.bhuwanupadhyay.eventstorepoc;

import lombok.Data;

@Data
public class OrderPlaceCommand {
  private String firstName;
  private String lastName;
  private String middleName;
  private String location;
}
