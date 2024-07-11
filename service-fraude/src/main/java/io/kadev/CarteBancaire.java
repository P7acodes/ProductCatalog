package io.kadev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarteBancaire implements Serializable {

    private Long id;
    private String numeroCarte;
    private Long codeSecret;
    private String nomProprietaire;

}
