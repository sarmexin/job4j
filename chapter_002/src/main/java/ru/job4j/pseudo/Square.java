package ru.job4j.pseudo;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    /**
     * Method draw.
     *
     * @return
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++");
        pic.append("+     +");
        pic.append("+     +");
        pic.append("+++++++");
        return pic.toString();
    }

}
