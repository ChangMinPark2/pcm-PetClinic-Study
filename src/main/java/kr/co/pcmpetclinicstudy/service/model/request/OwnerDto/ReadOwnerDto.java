package kr.co.pcmpetclinicstudy.service.model.request.OwnerDto;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public class ReadOwnerDto {

    private String address;

    private String city;

    private String firstName;

    private String lastName;

    private String telephone;
}
