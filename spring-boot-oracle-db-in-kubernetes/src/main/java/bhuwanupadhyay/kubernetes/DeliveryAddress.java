package bhuwanupadhyay.kubernetes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeliveryAddress {
    private String address;

    public DeliveryAddress(String address) {
        this.address = address;
    }
}
