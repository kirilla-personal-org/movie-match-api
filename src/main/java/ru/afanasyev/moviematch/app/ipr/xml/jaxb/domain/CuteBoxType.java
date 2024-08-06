package ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum CuteBoxType {
    @XmlEnumValue("Kotiki")
    CATS,
    @XmlEnumValue("Sobachki")
    DOGS
}
