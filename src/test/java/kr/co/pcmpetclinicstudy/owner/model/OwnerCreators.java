package kr.co.pcmpetclinicstudy.owner.model;

import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;

public class OwnerCreators{

    public static OwnerReqDto.CREATE ownerReqDto_create_creators(){

        return OwnerReqDto.CREATE.builder()
                .address("guri")
                .city("test")
                .firstName("changmin")
                .lastName("Park")
                .telephone("010-1111-2222")
                .build();
    }

    public static OwnerReqDto.CREATE ownerReqDto_create_creators(String telephone){

        return OwnerReqDto.CREATE.builder()
                .address("guri")
                .city("test")
                .firstName("changmin")
                .lastName("Park")
                .telephone("010-1111-2222")
                .build();
    }

    public static OwnerReqDto.UPDATE ownerReqDto_update_creators(String telephone){

        return OwnerReqDto.UPDATE.builder()
                .ownerId(1L)
                .address("guri")
                .city("test")
                .firstName("changmin")
                .lastName("Park")
                .telephone("010-1111-2222")
                .build();
    }
}
