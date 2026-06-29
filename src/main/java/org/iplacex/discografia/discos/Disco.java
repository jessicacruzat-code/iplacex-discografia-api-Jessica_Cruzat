package org.iplacex.discografia.discos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("discos")
public class Disco {

    @Id
    public String _id;

    @Field("titulo")
    public String titulo;

    @Field("anio")
    public int anio;

    @Field("genero")
    public String genero;

    @Field("artistaId")
    public String artistaId;

}
