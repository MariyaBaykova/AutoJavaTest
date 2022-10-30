public class IncorrectSideSizeException extends TriangleAreaCalculationException{
    @Override
    public String getMessage() {
        return "Длины всех сторон треугольника должны быть положительными числами";
    }
}
