package com.Hikerent.service.impl;


import com.Hikerent.dto.request.ProductRequest;
import com.Hikerent.dto.response.ProductResponse;
import com.Hikerent.entity.Category;
import com.Hikerent.entity.Product;
import com.Hikerent.entity.Seller;
import com.Hikerent.repository.CategoryRepository;
import com.Hikerent.repository.ProductRepository;
import com.Hikerent.repository.SellerRepository;
import com.Hikerent.service.ProductService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {



    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final SellerRepository sellerRepository;





    @Override
    public ProductResponse create(ProductRequest request) {


        Category category =
                categoryRepository.findById(request.getCategoryId())
                        .orElseThrow(() ->
                                new RuntimeException("Category tidak ditemukan")
                        );



        Seller seller =
                sellerRepository.findById(request.getSellerId())
                        .orElseThrow(() ->
                                new RuntimeException("Seller tidak ditemukan")
                        );



        Product product = Product.builder()

                .namaProduk(request.getNamaProduk())

                .deskripsi(request.getDeskripsi())

                .hargaBeli(request.getHargaBeli())

                .hargaSewa(request.getHargaSewa())

                .stok(request.getStok())

                .tersedia(true)

                .category(category)

                .seller(seller)

                .build();



        return mapToResponse(
                productRepository.save(product)
        );

    }







    @Override
    public ProductResponse update(Long id, ProductRequest request) {


        Product product =
                productRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Produk tidak ditemukan")
                        );



        product.setNamaProduk(request.getNamaProduk());

        product.setDeskripsi(request.getDeskripsi());

        product.setHargaBeli(request.getHargaBeli());

        product.setHargaSewa(request.getHargaSewa());

        product.setStok(request.getStok());



        return mapToResponse(
                productRepository.save(product)
        );

    }







    @Override
    public ProductResponse getById(Long id) {


        Product product =
                productRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Produk tidak ditemukan")
                        );


        return mapToResponse(product);

    }







    @Override
    public List<ProductResponse> getAll() {


        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }








    @Override
    public List<ProductResponse> search(String keyword) {


        return productRepository
                .findByNamaProdukContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToResponse)
                .toList();

    }








    @Override
    public void delete(Long id) {

        productRepository.deleteById(id);

    }







    private ProductResponse mapToResponse(Product product){


        ProductResponse response =
                new ProductResponse();



        response.setId(product.getId());

        response.setNamaProduk(
                product.getNamaProduk()
        );


        response.setDeskripsi(
                product.getDeskripsi()
        );


        response.setHargaBeli(
                product.getHargaBeli()
        );


        response.setHargaSewa(
                product.getHargaSewa()
        );


        response.setStok(
                product.getStok()
        );


        response.setTersedia(
                product.getTersedia()
        );


        return response;

    }


}