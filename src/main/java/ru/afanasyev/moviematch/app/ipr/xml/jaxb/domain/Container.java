package ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain;

import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@XmlType(name = "container")
@XmlRootElement
public class Container {
    @XmlAttribute(name = "id")
    public String id;

    @XmlElementWrapper(name="box-list", nillable = true)
    @XmlElements({
        @XmlElement(name = "imagedBox", type = ImagedBox.class),
        @XmlElement(name = "cuteBox", type = CuteBox.class)
    })
    public List<Box> boxes = new ArrayList<>();

    public void addBox(Box box) {
        boxes.add(box);
    }
}
