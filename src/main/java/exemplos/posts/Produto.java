package exemplos.posts;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Produto {

    private String nome;
    private int preco;
    private String descricao;
    private int quantidade;
    private String idProduto;
}
