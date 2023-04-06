package kr.co.pcmpetclinicstudy.service.model.request.ownerDto;

import lombok.Getter;

@Getter
public class UpdateOwnerDto {

    private Long id;

    private String address;

    private String city;

    private String firstName;

    private String lastName;

    private String telephone;
}
