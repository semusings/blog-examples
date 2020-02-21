package io.github.bhuwanupadhyay.eventstorepoc.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeliveryAddress {

  private String location;
}
