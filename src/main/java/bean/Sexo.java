package bean;

public enum Sexo {
    M('M'),F('F');
    
    private final char valor;
    
    Sexo(char valor){
        this.valor = valor;
    }
}
