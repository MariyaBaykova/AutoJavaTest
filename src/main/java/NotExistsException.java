public class NotExistsException extends TriangleAreaCalculationException{
    @Override
    public String getMessage() {
        return "Треугольник с такими сторонами не может существовать";
    }
}
