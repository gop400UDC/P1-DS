package e3;
//Registro Property
public record Property(PropertyType type,String catastro, String direccion, String codepostal, int metros, int habitaciones, int baños) {

    @Override
//Metodo to String usado para convertir un objecto property en una cadena string
    public String toString() {

        return type + "\n" + catastro + "\n" + direccion + "\n" + codepostal + "\n" + metros + " meters, " + habitaciones + " rooms, " + baños + " bathrooms\n";

    }
    @Override
//Metodo constructor para saber si dos objectos son iguales
    public boolean equals(Object o) {
        if (this == o) return true;//Determina si el objecto actual es el mismo con el que se esta comparando
        if (o == null || getClass() != o.getClass()) return false;//Verifica si el objecto a comparar es nulo y si el actual y este pertenecen a la misma clase
        Property property = (Property) o;
        return catastro.equals(property.catastro);
    }

    @Override
    //Metodo hashing utilizado para generar y devolver el codigo hash del catastro de un objecto Property
    public int hashCode() {
        return catastro.hashCode();
    }
}





