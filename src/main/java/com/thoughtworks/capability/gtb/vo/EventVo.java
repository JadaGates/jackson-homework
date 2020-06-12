package com.thoughtworks.capability.gtb.vo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author itutry
 * @create 2020-05-21_16:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventVo {

  private String id;
  private String name;
  private EventType type;
  @JsonSerialize(using = LocalDateTimeSerializer.class)
//  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
  private LocalDateTime time;

  @JsonUnwrapped
  private UserVo user;

  private static class LocalDateTimeSerializer extends StdSerializer<LocalDateTime>

  {

    protected LocalDateTimeSerializer() {
      super(LocalDateTime.class);
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
      gen.writeNumber(value.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }
  }

  private static class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime>
  {
    protected LocalDateTimeDeserializer() {
    super(LocalDateTime.class);
  }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

      return null;
    }


  }
}
