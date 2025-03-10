package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.Owner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OwnerDto {

  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String telephone;

  // 새 엔티티 여부 확인 (thymeleaf 템플릿 맞춰 작성)
  private boolean isNew = false;


  @Builder
  public OwnerDto(String firstName, String lastName, String address, String city, String telephone, boolean isNew) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.telephone = telephone;
    this.isNew = isNew;
  }

  // Entity → DTO 변환 메서드
  public static OwnerDto fromEntity(Owner owner) {
    return OwnerDto.builder()
      .firstName(owner.getFirstName())
      .lastName(owner.getLastName())
      .address(owner.getAddress())
      .city(owner.getCity())
      .telephone(owner.getTelephone())
      .isNew(false)
      .build();
  }

  // DTO → Entity 변환 메서드
  public Owner toEntity() {
    return Owner.of(firstName, lastName, address, city, telephone);
  }

  // thymeleaf Owner 등록 템플릿의 owner[new]를 사용하기 위한 getter 추가
  public boolean getNew() {
    return isNew;
  }
}

