package ru.afanasyev.moviematch.app.ipr.xml;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@RequiredArgsConstructor
@Slf4j
public class JaxpXmlParser {
    /**
     * JAXP имеет ряд преимуществ и оказывается ценным в различных вариантах использования.
     * Его универсальность и совместимость с различными процессорами XML делают его надежным выбором.
     *
     * С помощью программного интерфейса JAXP, не зависящего от поставщика,
     * мы можем переключаться между различными парсерами или процессорами XML без необходимости изменять наш код.
     * Это обеспечивает бесшовную интеграцию и готовность решений по обработке XML к будущему.
     *
     * JAXP обычно используется в сценариях, требующих детального контроля над обработкой XML,
     * таких как сложные преобразования документов или проверка,
     * где его обширные возможности отвечают конкретным потребностям разработчиков.
     *
     * </p>
     *
     * В этом примере мы используем JAXP для анализа XML-файла с именем «input.xml».
     * Мы создаем экземпляр DocumentBuilderFactory и используем его для получения DocumentBuilder.
     * DocumentBuilder отвечает за анализ XML-файла и создание объекта Document, который представляет XML-данные.
     */
    public void parse(File file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            log.info(document.getDocumentElement().getTextContent());
        } catch (Exception e) {
            log.error("Can not parce file", e);
        }
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/xml/note.xml");
        JaxpXmlParser parser = new JaxpXmlParser();
        parser.parse(file);

        file = new File("src/main/resources/movies.data/movies.csv");
        parser.parse(file);
    }
}
