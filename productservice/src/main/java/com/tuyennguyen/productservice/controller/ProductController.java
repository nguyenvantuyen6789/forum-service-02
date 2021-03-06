package com.tuyennguyen.productservice.controller;

import com.tuyennguyen.productservice.entity.Product;
import com.tuyennguyen.productservice.model.ProductDTO;
import com.tuyennguyen.productservice.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<ProductDTO> get() {
        List<Product> products = productRepo.findAll();
        List<ProductDTO> productDTOS =new ArrayList<>();

        products.forEach(product -> {
            productDTOS.add(modelMapper.map(product, ProductDTO.class));
        });

        return productDTOS;
    }

    @PostMapping
    public ProductDTO add(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        System.out.println(product);
        productRepo.save(product);

        return productDTO;
    }

    @PutMapping
    public ProductDTO update(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        productRepo.save(product);

        return productDTO;
    }

    @DeleteMapping("{productId}")
    public ProductDTO delete(@PathVariable Long productId) {
        Product product = productRepo.getById(productId);

        if (product != null) {
            productRepo.delete(product);
            return modelMapper.map(product, ProductDTO.class);
        }

        return null;
    }

}
