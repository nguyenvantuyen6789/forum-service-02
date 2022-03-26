package com.tuyennguyen.productservice.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDTO {

    private Long productId;

    @NonNull
    private String productName;

}
