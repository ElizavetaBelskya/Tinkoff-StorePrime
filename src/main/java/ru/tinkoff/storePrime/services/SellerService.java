package ru.tinkoff.storePrime.services;

import ru.tinkoff.storePrime.dto.user.NewOrUpdateSellerDto;
import ru.tinkoff.storePrime.dto.user.SellerDto;

public interface SellerService {

    SellerDto addSeller(NewOrUpdateSellerDto sellerDto);

    void deleteSeller(Long sellerId);

    SellerDto updateSeller(Long id, NewOrUpdateSellerDto updatedSeller);

    SellerDto getSeller(Long id);
    void updateCardBalanceBySellerId(Long sellerId, Double amount);


}
