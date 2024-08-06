package ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain;

import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Box {
    @XmlAttribute(name = "s")
    public int size;
}
