package ru.tinkoff.storePrime.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.tinkoff.storePrime.converters.ProductConverter;
import ru.tinkoff.storePrime.dto.cart.CartItemDto;
import ru.tinkoff.storePrime.dto.product.ProductDto;
import ru.tinkoff.storePrime.models.Order;
import ru.tinkoff.storePrime.models.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Schema(description = "Заказ")
public class OrderDto {

    private Long id;

    private String status;

    private ProductDto product;

    private Integer quantity;

    private Long customerId;

    public static OrderDto from(Order order) {

        return OrderDto.builder().id(order.getId())
                .customerId(order.getCustomer().getId())
                .status(order.getStatus().name())
                .product(ProductConverter.getProductDtoFromProduct(order.getProduct()))
                .build();
    }

    public static List<OrderDto> from(List<Order> orders) {
        return orders.stream().map(OrderDto::from)
                .collect(Collectors.toList());
    }




}
