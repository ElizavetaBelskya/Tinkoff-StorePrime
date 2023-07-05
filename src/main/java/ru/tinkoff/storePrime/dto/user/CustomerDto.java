package ru.tinkoff.storePrime.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.tinkoff.storePrime.dto.location.AddressDto;
import ru.tinkoff.storePrime.models.user.Customer;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Schema(description = "Покупатель")
public class CustomerDto extends AccountDto {

    @Schema(description = "Имя", example = "Иван")
    private String name;

    @Schema(description = "Фамилия", example = "Иванов")
    private String surname;

    @Schema(description = "Пол", example = "MALE")
    private Customer.Gender gender;

    @Schema(description = "Дата рождения", example = "2000-01-01")
    private LocalDate birthdayDate;

    private AddressDto addressDto;

    public static CustomerDto from(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .cardBalance(customer.getCardBalance())
                .name(customer.getName())
                .surname(customer.getSurname())
                .gender(customer.getGender())
                .birthdayDate(customer.getBirthdayDate())
                .addressDto(AddressDto.from(customer.getAddress()))
                .build();
    }

}