/*
 * Concepts Covered:
 * 1. XML Structure
 * 2. XML Tags
 * 3. Storing Data in XML Format
 */
/*
 * XML (eXtensible Markup Language)
 *
 * XML is a markup language used to store and transport data
 * using custom tags.
 *
 * Features:
 * 1. Self-descriptive
 * 2. Platform independent
 * 3. Supports hierarchical data
 * 4. Uses opening and closing tags
 *
 * Example:
 * <student>
 *     <id>101</id>
 *     <name>Khushi</name>
 *     <course>Java</course>
 * </student>
 */

public class XmlDemo {

    public static void main(String[] args) {

        String studentXml =
                "<student>\n" +
                "    <id>101</id>\n" +
                "    <name>Khushi</name>\n" +
                "    <course>Java</course>\n" +
                "</student>";

        System.out.println("XML Data:");
        System.out.println(studentXml);
    }
}

/**
 * Output:
 * XML Data:
 * <student>
 *     <id>101</id>
 *     <name>Khushi</name>
 *     <course>Java</course>
 * </student>
 */