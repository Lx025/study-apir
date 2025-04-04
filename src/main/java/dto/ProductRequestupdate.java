package dto;

import java.math.BigDecimal;

import com.github.lx025.study_apir.model.Product;

public class ProductRequestUpdate {

    private BigDecimal valor;

    public Product toModel(Product product) {
        product.setValor(this.valor);
        return product;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    

}
