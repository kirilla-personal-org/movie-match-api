package ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@XmlType(name = "cute-box")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class CuteBox extends Box {
    @XmlElement(name = "cuteAmount")
    public Integer cuteAmount;
    @XmlAttribute(name = "type")
    public CuteBoxType type;
}
