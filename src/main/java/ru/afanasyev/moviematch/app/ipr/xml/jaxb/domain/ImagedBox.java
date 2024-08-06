package ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlType(name = "image-box")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class ImagedBox extends Box {
    @XmlElement(name = "imageCode")
    public String imageCode;
}
