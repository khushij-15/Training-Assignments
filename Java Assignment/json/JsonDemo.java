/*
 * Concepts Covered:
 * 1. JSON Structure
 * 2. JSON Object
 * 3. JSON Array
 */
/*
 * JSON (JavaScript Object Notation)
 *
 * JSON is a lightweight data-interchange format used to store
 * and exchange data between applications.
 *
 * Features:
 * 1. Human readable
 * 2. Lightweight
 * 3. Language independent
 * 4. Uses key-value pairs
 *
 * Example:
 * {
 *     "id": 101,
 *     "name": "Khushi",
 *     "course": "Java"
 * }
 */

public class JsonDemo {

    public static void main(String[] args) {

        String studentJson ="{" + "\"id\":101," + "\"name\":\"Khushi\"," + "\"course\":\"Java\"" + "}";

        String skillsJson =
                "[\"Java\", \"SQL\", \"Python\"]";

        System.out.println("JSON Object:");
        System.out.println(studentJson);

        System.out.println("\nJSON Array:");
        System.out.println(skillsJson);
    }
}

/**
 * Output:
 * JSON Object:
 * {"id":101,"name":"Khushi","course":"Java"}
 *
 * JSON Array:
 * ["Java", "SQL", "Python"]
 */