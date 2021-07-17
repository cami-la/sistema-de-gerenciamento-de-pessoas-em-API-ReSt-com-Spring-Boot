package one.digitalinnovation.personapi.controller.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.entity.Phone;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDto {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

    public PhoneDto(Phone phone) {
        this.id = phone.getId();
        this.type = phone.getType();
        this.number = phone.getNumber();
    }

    /*public String converterPhoneType(Phone phone) {
        return phone.getType().toString();
    }*/
}
