package ru.afanasyev.moviematch.app.ipr.xml;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class Stax {

    @SneakyThrows
    public static void main(String[] args) {
        InputStream inputStream = Files.newInputStream(Path.of("src/main/resources/xml/employees.xml"));

        try (StaxStreamProcessor processor = new StaxStreamProcessor(inputStream)) {
            XMLStreamReader reader = processor.getReader();
            while (reader.hasNext()) {       // while not end of XML
                int event = reader.next();   // read next event
                if (event == XMLEvent.START_ELEMENT &&
                    "employee".equals(reader.getLocalName())) {
                    System.out.println("employee name: " + reader.getAttributeValue(0));
                }
            }
        }
    }

    public static class StaxStreamProcessor implements AutoCloseable {
        private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

        private final XMLStreamReader reader;

        public StaxStreamProcessor(InputStream is) throws XMLStreamException {
            reader = FACTORY.createXMLStreamReader(is);
        }

        public XMLStreamReader getReader() {
            return reader;
        }

        @Override
        public void close() {
            if (reader != null) {
                try {
                    reader.close();
                } catch (XMLStreamException e) {
                    log.error("error", e);
                }
            }
        }
    }
}
