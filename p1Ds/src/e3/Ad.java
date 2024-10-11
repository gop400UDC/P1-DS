package e3;

public class Ad {
    //Atributos de la clase visibles dentro de la propia clase
    private String agencia;
    private AdType type;
    private Property property;
    private double precio;
//Metodo contructor para crear un objecto Ad con sus especificos atributos
    public Ad(String agencia, Property property,AdType type, double precio) {
        this.agencia = agencia;
        this.type = type;
        this.property = property;
        this.precio = precio;
    }
//Metodo que devuelve un valor bool en funcion de si dos objectos son iguales segun los campos property de cada uno
    public boolean isPropertyEqual(Ad otherAd) {
        return this.property.equals(otherAd.property);
    }
//Metodo de verificacion que devuelve  un valor bool en funcion del rango de precios normales de una propiedad
    public boolean isPriceNormal() {

        if(type==AdType.RENTAL){
            return precio<10000;
        }else if(type==AdType.PURCHASE){
            return precio >= 10000 && precio <= 1000000;
        }
        return false;

    }
//Metodo que devuelve el precio en metodos cuadrados de una propiedad,siempre que los datos sean correctos
    public double priceMetersEuros() {
        if (property.metros() == 0) {

            throw new ArithmeticException("Error,no se ha podido calcular el precio por metro cuadrado de la propiedad\n");

        }
        return precio / property.metros();
    }
//Metodo que reduce el precio de una propiedad segun un porcentaje proporcionado
    public void dropPrice(double porcentaje) {
        if (porcentaje< 0 || porcentaje > 100) {

            throw new IllegalArgumentException("Error, porcentaje invalido\n");//Mensaje de error en caso de porcejante invalido

        }
        precio *= (1 - porcentaje / 100);
    }
    //Metodo que devuelve el precio de la propiedad seleccionada
    public double getPriceInEuros() {

        return precio;

    }
    public Property getProperty(){
        return this.property;
    }
//Metodo constructor que crea una copia de un objecto Ad existente
    public Ad(Ad other) {

        this.agencia = other.agencia;

        this.type = other.type;

        this.property = other.property;

        this.precio = other.precio;

    }

}
