package com.Hikerent.service.impl;


import com.Hikerent.dto.request.NewsRequest;
import com.Hikerent.dto.response.NewsResponse;
import com.Hikerent.entity.News;
import com.Hikerent.repository.NewsRepository;
import com.Hikerent.service.NewsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {



    private final NewsRepository newsRepository;




    @Override
    public NewsResponse create(NewsRequest request) {


        News news = News.builder()

                .judul(
                        request.getJudul()
                )

                .isi(
                        request.getIsi()
                )

                .gambar(
                        request.getGambar()
                )

                .sumber(
                        request.getSumber()
                )

                .build();



        return mapToResponse(
                newsRepository.save(news)
        );

    }






    @Override
    public NewsResponse update(
            Long id,
            NewsRequest request
    ){


        News news =
                newsRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Berita tidak ditemukan"
                                )
                        );



        news.setJudul(
                request.getJudul()
        );


        news.setIsi(
                request.getIsi()
        );


        news.setGambar(
                request.getGambar()
        );


        news.setSumber(
                request.getSumber()
        );



        return mapToResponse(
                newsRepository.save(news)
        );

    }






    @Override
    public List<NewsResponse> getAll(){


        return newsRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }







    @Override
    public NewsResponse getById(Long id){


        News news =
                newsRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Berita tidak ditemukan"
                                )
                        );


        return mapToResponse(news);

    }







    @Override
    public void delete(Long id){

        newsRepository.deleteById(id);

    }








    private NewsResponse mapToResponse(
            News news
    ){

        NewsResponse response =
                new NewsResponse();


        response.setId(
                news.getId()
        );


        response.setJudul(
                news.getJudul()
        );


        response.setIsi(
                news.getIsi()
        );


        response.setGambar(
                news.getGambar()
        );


        response.setSumber(
                news.getSumber()
        );


        return response;

    }

}