package com.pakie.flymzansi_ato_manager.booking;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.ZoneOffset;

public class BookingSerializer extends StdSerializer<Booking> {

    public BookingSerializer() {
        this(null);
    }

    public BookingSerializer(Class<Booking> t) {
        super(t);
    }

    @Override
    public void serialize(Booking booking, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", booking.getId());
        //jsonGenerator.writeStringField("title", booking.getWork().getTitle());
        jsonGenerator.writeNumberField("start", booking.getStart().toInstant(ZoneOffset.UTC).toEpochMilli());
        jsonGenerator.writeNumberField("end", booking.getEnd().toInstant(ZoneOffset.UTC).toEpochMilli());
        jsonGenerator.writeStringField("url", "/appointments/" + booking.getId());
        jsonGenerator.writeStringField("color", booking.getStatus().equals(BookingStatus.SCHEDULED) ? "#28a745" : "grey");
        jsonGenerator.writeEndObject();

    }
}
