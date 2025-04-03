package com.example.demo.adapterPrototype.adapter;

import com.example.demo.adapterPrototype.api.BookingComApi;
import com.example.demo.adapterPrototype.dto.AttractionDto;
import com.example.demo.adapterPrototype.dto.BookingComAttractionDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingComAdapter implements com.example.demo.adapterPrototype.adapter.AttractionAdapter {
    private BookingComApi bookingComApi;

    public BookingComAdapter(BookingComApi bookingComApi) {
        this.bookingComApi = bookingComApi;
    }

    @Override
    public List<AttractionDto> getAttractions(String location) {
        List<BookingComAttractionDto> rawData = bookingComApi.retrieveAttractions(location);
        List<AttractionDto> attractions = new ArrayList<>();

        for (BookingComAttractionDto item : rawData) {
            attractions.add(new AttractionDto(item.name(), item.location(), item.rating(), item.provider()));
        }

        return attractions;
    }

    @Override
    public String getName() {
        return "BookingCom";
    }
}
