package org.iplacex.discografia.artistas;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("artistas")
public class Artista {

    @Id
    public String _id;

    @Field("nombre")
    public String nombre;

    @Field("pais")
    public String pais;

    @Field("anioFundacion")
    public int anioFundacion;
}
