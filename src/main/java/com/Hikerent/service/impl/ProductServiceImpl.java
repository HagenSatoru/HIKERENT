package com.Hikerent.service.impl;

import com.Hikerent.dto.request.ProductRequest;
import com.Hikerent.dto.response.ProductResponse;
import com.Hikerent.entity.Category;
import com.Hikerent.entity.Organizer;
import com.Hikerent.entity.Product;
import com.Hikerent.entity.Seller;
import com.Hikerent.repository.CategoryRepository;
import com.Hikerent.repository.OrganizerRepository;
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
    private final OrganizerRepository organizerRepository; // Tambahan repository organizer

    @Override
    public ProductResponse create(ProductRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category tidak ditemukan"));

        Seller seller = null;
        Organizer organizer = null;

        // Validasi kepemilikan produk: Harus milik Seller ATAU Organizer
        if (request.getSellerId() != null && request.getOrganizerId() != null) {
            throw new RuntimeException("Produk hanya boleh dimiliki oleh Seller ATAU Organizer, tidak keduanya.");
        }

        if (request.getSellerId() != null) {
            seller = sellerRepository.findById(request.getSellerId())
                    .orElseThrow(() -> new RuntimeException("Seller tidak ditemukan"));
        } else if (request.getOrganizerId() != null) {
            organizer = organizerRepository.findById(request.getOrganizerId())
                    .orElseThrow(() -> new RuntimeException("Organizer tidak ditemukan"));
        } else {
            throw new RuntimeException("Produk harus memiliki pemilik (Seller ID atau Organizer ID wajib diisi)");
        }

        Product product = Product.builder()
                .namaProduk(request.getNamaProduk())
                .deskripsi(request.getDeskripsi())
                .hargaBeli(request.getHargaBeli())
                .hargaSewa(request.getHargaSewa())
                .stok(request.getStok())
                .tersedia(true)
                .category(category)
                .seller(seller)
                .organizer(organizer)
                .build();

        return mapToResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produk tidak ditemukan"));

        product.setNamaProduk(request.getNamaProduk());
        product.setDeskripsi(request.getDeskripsi());
        product.setHargaBeli(request.getHargaBeli());
        product.setHargaSewa(request.getHargaSewa());
        product.setStok(request.getStok());

        return mapToResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produk tidak ditemukan"));
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
    public List<ProductResponse> getByOrganizerId(Long organizerId) {
        // Pastikan Anda menambahkan method ini di ProductRepository jika belum ada:
        // List<Product> findByOrganizerId(Long organizerId);
        return productRepository.findByOrganizerId(organizerId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> search(String keyword) {
        return productRepository.findByNamaProdukContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    private ProductResponse mapToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setNamaProduk(product.getNamaProduk());
        response.setDeskripsi(product.getDeskripsi());
        response.setHargaBeli(product.getHargaBeli());
        response.setHargaSewa(product.getHargaSewa());
        response.setStok(product.getStok());
        response.setTersedia(product.getTersedia());

        // Cek relasi category
        if (product.getCategory() != null) {
            response.setNamaKategori(product.getCategory().getNamaKategori());
        }

        // Cek apakah milik Seller
        if (product.getSeller() != null) {
            response.setNamaSeller(product.getSeller().getNamaToko());
        }

        // Cek apakah milik Organizer
        if (product.getOrganizer() != null) {
            response.setNamaOrganizer(product.getOrganizer().getNamaOrganizer());
        }

        return response;
    }
}